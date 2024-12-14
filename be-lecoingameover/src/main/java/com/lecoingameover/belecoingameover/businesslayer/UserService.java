package com.lecoingameover.belecoingameover.businesslayer;

import com.lecoingameover.belecoingameover.presentationlayer.UserResponseModel;

import java.util.List;

public interface UserService {
    List<UserResponseModel> getAllUsers();
    UserResponseModel getUserById(String userId);
}