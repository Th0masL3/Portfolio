package com.lecoingameover.belecoingameover.dataaccess;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users") // Maps this class to the "users" collection in MongoDB
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;

    private String userId;

    private String email;

    private String firstName;

    private String lastName;

    private List<String> roles;

    private List<String> permissions;

    private boolean blocked;
}
