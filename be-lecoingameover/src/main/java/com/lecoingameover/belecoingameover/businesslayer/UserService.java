package com.lecoingameover.belecoingameover.businesslayer;

import com.lecoingameover.belecoingameover.presentationlayer.UserResponseModel;

import java.util.List;

public interface UserService {
    List<UserResponseModel> getAllUsers();
    UserResponseModel getUserById(String userId);
    UserResponseModel addUserFromAuth0(String auth0UserId);
    UserResponseModel syncUserWithAuth0(String auth0UserId);
    void blockUserById(String userId, boolean isBlocked);
}
