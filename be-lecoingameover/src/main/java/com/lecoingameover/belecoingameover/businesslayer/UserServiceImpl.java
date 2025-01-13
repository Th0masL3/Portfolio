package com.lecoingameover.belecoingameover.businesslayer;

import com.lecoingameover.belecoingameover.auth0.Auth0Client;
import com.lecoingameover.belecoingameover.dataaccess.User;
import com.lecoingameover.belecoingameover.dataaccess.UserRepository;
import com.lecoingameover.belecoingameover.presentationlayer.UserResponseModel;
import com.lecoingameover.belecoingameover.utils.UserEntityToModel;
import com.lecoingameover.belecoingameover.utils.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final Auth0Client auth0Client;
    private final UserRepository userRepository;

    @Override
    public List<UserResponseModel> getAllUsers() {
        // Fetch users from the database
        List<User> dbUsers = userRepository.findAll();

        // Fetch users from Auth0
        List<UserResponseModel> auth0Users = auth0Client.getAllUsers();

        // Sync missing Auth0 users into the database
        for (UserResponseModel auth0User : auth0Users) {
            boolean existsInDb = dbUsers.stream()
                    .anyMatch(dbUser -> dbUser.getUserId().equals(auth0User.getUserId()));
            if (!existsInDb) {
                User newUser = User.builder()
                        .userId(auth0User.getUserId())
                        .email(auth0User.getEmail())
                        .firstName(auth0User.getFirstName())
                        .lastName(auth0User.getLastName())
                        .roles(auth0User.getRoles())
                        .permissions(auth0User.getPermissions())
                        .build();
                userRepository.save(newUser);
            }
        }

        // Convert the updated database users to response models
        return userRepository.findAll()
                .stream()
                .map(UserEntityToModel::toUserResponseModel)
                .collect(Collectors.toList());
    }


    @Override
    public UserResponseModel getUserById(String userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + userId));
        return UserEntityToModel.toUserResponseModel(user);
    }

    @Override
    public UserResponseModel addUserFromAuth0(String auth0UserId) {
        var auth0User = auth0Client.getUserById(auth0UserId);
        Optional<User> existingUser = userRepository.findByUserId(auth0UserId);

        if (existingUser.isPresent()) {
            log.info("User already exists in database: {}", existingUser.get());
            return UserEntityToModel.toUserResponseModel(existingUser.get());
        }

        User newUser = User.builder()
                .userId(auth0UserId)
                .email(auth0User.getEmail())
                .firstName(auth0User.getFirstName())
                .lastName(auth0User.getLastName())
                .roles(auth0User.getRoles())
                .permissions(auth0User.getPermissions())
                .build();

        userRepository.save(newUser);
        log.info("User added from Auth0: {}", newUser);

        return UserEntityToModel.toUserResponseModel(newUser);
    }

    @Override
    public UserResponseModel syncUserWithAuth0(String auth0UserId) {
        var auth0User = auth0Client.getUserById(auth0UserId);
        User existingUser = userRepository.findByUserId(auth0UserId)
                .orElseThrow(() -> new NotFoundException("User not found in database: " + auth0UserId));

        existingUser.setEmail(auth0User.getEmail());
        existingUser.setFirstName(auth0User.getFirstName());
        existingUser.setLastName(auth0User.getLastName());
        existingUser.setRoles(auth0User.getRoles());
        existingUser.setPermissions(auth0User.getPermissions());

        userRepository.save(existingUser);
        log.info("User synced with Auth0: {}", existingUser);

        return UserEntityToModel.toUserResponseModel(existingUser);
    }
}
