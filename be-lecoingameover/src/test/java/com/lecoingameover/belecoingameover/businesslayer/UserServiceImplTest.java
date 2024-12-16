package com.lecoingameover.belecoingameover.businesslayer;


import com.lecoingameover.belecoingameover.auth0.Auth0Client;
import com.lecoingameover.belecoingameover.presentationlayer.UserResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private Auth0Client auth0Client;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        // Arrange
        List<UserResponseModel> mockUsers = Arrays.asList(
                UserResponseModel.builder()
                        .userId("1")
                        .email("john.doe@example.com")
                        .firstName("John")
                        .lastName("Doe")
                        .roles(Arrays.asList("USER"))
                        .permissions(Arrays.asList("READ"))
                        .build(),
                UserResponseModel.builder()
                        .userId("2")
                        .email("jane.smith@example.com")
                        .firstName("Jane")
                        .lastName("Smith")
                        .roles(Arrays.asList("ADMIN"))
                        .permissions(Arrays.asList("READ", "WRITE"))
                        .build()
        );

        when(auth0Client.getAllUsers()).thenReturn(mockUsers);

        // Act
        List<UserResponseModel> result = userService.getAllUsers();

        // Assert
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFirstName());
        assertEquals("Doe", result.get(0).getLastName());
        assertEquals(Arrays.asList("USER"), result.get(0).getRoles());
        assertEquals(Arrays.asList("READ"), result.get(0).getPermissions());
        verify(auth0Client, times(1)).getAllUsers();
    }

    @Test
    void testGetUserById() {
        // Arrange
        UserResponseModel mockUser = UserResponseModel.builder()
                .userId("1")
                .email("john.doe@example.com")
                .firstName("John")
                .lastName("Doe")
                .roles(Arrays.asList("USER"))
                .permissions(Arrays.asList("READ"))
                .build();

        when(auth0Client.getUserById("1")).thenReturn(mockUser);

        // Act
        UserResponseModel result = userService.getUserById("1");

        // Assert
        assertEquals("1", result.getUserId());
        assertEquals("john.doe@example.com", result.getEmail());
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
        assertEquals(Arrays.asList("USER"), result.getRoles());
        assertEquals(Arrays.asList("READ"), result.getPermissions());
        verify(auth0Client, times(1)).getUserById("1");
    }
}