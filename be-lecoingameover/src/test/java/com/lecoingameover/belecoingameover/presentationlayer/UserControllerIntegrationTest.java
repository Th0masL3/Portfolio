package com.lecoingameover.belecoingameover.presentationlayer;

import com.lecoingameover.belecoingameover.businesslayer.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        // Arrange
        UserResponseModel user1 = new UserResponseModel("1", "John", "Doe", "john.doe@example.com", List.of("Admin"), List.of("read:users"));
        UserResponseModel user2 = new UserResponseModel("2", "Jane", "Doe", "jane.doe@example.com", List.of("User"), List.of("write:posts"));
        when(userService.getAllUsers()).thenReturn(List.of(user1, user2));

        // Act
        ResponseEntity<List<UserResponseModel>> response = userController.getAllUsers();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void testGetUserById() {
        // Arrange
        String userId = "1";
        UserResponseModel user = new UserResponseModel(userId, "John", "Doe", "john.doe@example.com", List.of("Admin"), List.of("read:users"));
        when(userService.getUserById(userId)).thenReturn(user);

        // Act
        ResponseEntity<UserResponseModel> response = userController.getUserById(userId);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(userId, response.getBody().getUserId());
        verify(userService, times(1)).getUserById(userId);
    }
}
