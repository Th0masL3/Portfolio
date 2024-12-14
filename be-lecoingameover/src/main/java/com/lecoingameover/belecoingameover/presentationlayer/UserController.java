package com.lecoingameover.belecoingameover.presentationlayer;

import com.lecoingameover.belecoingameover.businesslayer.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseModel>> getAllUsers() {
        List<UserResponseModel> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseModel> getUserById(@PathVariable String userId) {
        UserResponseModel user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }
}