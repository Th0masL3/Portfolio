package com.lecoingameover.belecoingameover.businesslayer;

import com.lecoingameover.belecoingameover.auth0.Auth0Client;
import com.lecoingameover.belecoingameover.presentationlayer.UserResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final Auth0Client auth0Client;

    @Override
    public List<UserResponseModel> getAllUsers() {
        return auth0Client.getAllUsers();
    }

    @Override
    public UserResponseModel getUserById(String userId) {
        return auth0Client.getUserById(userId);
    }
}