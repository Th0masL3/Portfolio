package com.lecoingameover.belecoingameover.auth0;

import com.lecoingameover.belecoingameover.presentationlayer.UserResponseModel;

import java.util.List;

public interface Auth0Client {
    UserResponseModel getUserById(String auth0UserId);
    List<UserResponseModel> getAllUsers();
    void assignRoleToUser(String auth0UserId, String roleName);
}
