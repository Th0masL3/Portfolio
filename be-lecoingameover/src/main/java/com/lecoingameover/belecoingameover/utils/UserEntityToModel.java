package com.lecoingameover.belecoingameover.utils;

import com.lecoingameover.belecoingameover.dataaccess.User;
import com.lecoingameover.belecoingameover.presentationlayer.UserResponseModel;

public class UserEntityToModel {

    public static UserResponseModel toUserResponseModel(User user) {
        return UserResponseModel.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .roles(user.getRoles())
                .permissions(user.getPermissions())
                .build();
    }
}
