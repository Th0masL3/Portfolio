package com.lecoingameover.belecoingameover.presentationlayer;

import com.lecoingameover.belecoingameover.businesslayer.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseModel> getUserById(@PathVariable String userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PostMapping("/{userId}/add")
    public ResponseEntity<UserResponseModel> addUserFromAuth0(@PathVariable String userId) {
        return ResponseEntity.ok(userService.addUserFromAuth0(userId));
    }

    @PutMapping("/{userId}/sync")
    public ResponseEntity<UserResponseModel> syncUserWithAuth0(@PathVariable String userId) {
        return ResponseEntity.ok(userService.syncUserWithAuth0(userId));
    }
    private String getCurrentUserId() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
    @GetMapping("/me")
    public ResponseEntity<UserResponseModel> getCurrentUser() {
        String userId = getCurrentUserId(); // A method to fetch the current user's ID from the security context
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping("/{userId}/block")
    public ResponseEntity<Void> blockUserById(
            @PathVariable String userId,
            @RequestParam boolean isBlocked) {
        userService.blockUserById(userId, isBlocked);
        return ResponseEntity.ok().build();
    }
}
