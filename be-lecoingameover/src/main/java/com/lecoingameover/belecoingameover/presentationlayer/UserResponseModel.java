package com.lecoingameover.belecoingameover.presentationlayer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseModel {
    private String userId;
    private String email;
    private String firstName;
    private String lastName;
    private List<String> roles;
    private List<String> permissions;
    private boolean isBlocked;
}