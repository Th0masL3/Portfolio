package com.lecoingameover.belecoingameover.businesslayer;

import com.lecoingameover.belecoingameover.auth0.Auth0Client;
import com.lecoingameover.belecoingameover.dataaccess.User;
import com.lecoingameover.belecoingameover.dataaccess.UserRepository;
import com.lecoingameover.belecoingameover.presentationlayer.UserResponseModel;
import com.lecoingameover.belecoingameover.utils.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private Auth0Client auth0Client;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        // Mock users in the database
        when(userRepository.findAll()).thenReturn(List.of(
                User.builder()
                        .userId("1")
                        .email("john.doe@example.com")
                        .firstName("John")
                        .lastName("Doe")
                        .build(),
                User.builder()
                        .userId("2")
                        .email("jane.doe@example.com")
                        .firstName("Jane")
                        .lastName("Doe")
                        .build()
        ));

        // Test method
        List<UserResponseModel> users = userService.getAllUsers();

        // Verify results
        assertEquals(2, users.size());
        assertEquals("1", users.get(0).getUserId());
        assertEquals("2", users.get(1).getUserId());

        verify(userRepository, times(1)).findAll();
    }
    @Test
    void testGetUserById() {
        // Mock user
        User dbUser = User.builder()
                .userId("db|123")
                .email("dbuser@example.com")
                .firstName("Db")
                .lastName("User")
                .roles(List.of("admin"))
                .permissions(List.of("read"))
                .build();
        when(userRepository.findByUserId("db|123")).thenReturn(Optional.of(dbUser));

        // Test method
        UserResponseModel user = userService.getUserById("db|123");

        // Verify results
        assertEquals("db|123", user.getUserId());
        assertEquals("dbuser@example.com", user.getEmail());
        assertEquals("Db", user.getFirstName());
        assertEquals("User", user.getLastName());
        verify(userRepository, times(1)).findByUserId("db|123");
    }

    @Test
    void testGetUserByIdNotFound() {
        when(userRepository.findByUserId("nonexistent")).thenReturn(Optional.empty());

        // Test method and assert exception
        assertThrows(NotFoundException.class, () -> userService.getUserById("nonexistent"));
        verify(userRepository, times(1)).findByUserId("nonexistent");
    }

    @Test
    void testAddUserFromAuth0() {
        // Mock Auth0 user
        UserResponseModel auth0User = UserResponseModel.builder()
                .userId("auth0|456")
                .email("auth0user@example.com")
                .firstName("Auth0")
                .lastName("User")
                .roles(List.of("customer"))
                .permissions(List.of("write"))
                .build();
        when(auth0Client.getUserById("auth0|456")).thenReturn(auth0User);
        when(userRepository.findByUserId("auth0|456")).thenReturn(Optional.empty());

        // Test method
        UserResponseModel addedUser = userService.addUserFromAuth0("auth0|456");

        // Verify results
        assertEquals("auth0|456", addedUser.getUserId());
        assertEquals("auth0user@example.com", addedUser.getEmail());
        verify(auth0Client, times(1)).getUserById("auth0|456");
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testSyncUserWithAuth0() {
        // Mock Auth0 user
        UserResponseModel auth0User = UserResponseModel.builder()
                .userId("auth0|456")
                .email("updated@example.com")
                .firstName("Updated")
                .lastName("User")
                .roles(List.of("customer"))
                .permissions(List.of("read", "write"))
                .build();
        when(auth0Client.getUserById("auth0|456")).thenReturn(auth0User);

        // Mock existing database user
        User dbUser = User.builder()
                .userId("auth0|456")
                .email("auth0user@example.com")
                .firstName("Auth0")
                .lastName("User")
                .roles(List.of("customer"))
                .permissions(List.of("write"))
                .build();
        when(userRepository.findByUserId("auth0|456")).thenReturn(Optional.of(dbUser));

        // Test method
        UserResponseModel syncedUser = userService.syncUserWithAuth0("auth0|456");

        // Verify results
        assertEquals("auth0|456", syncedUser.getUserId());
        assertEquals("updated@example.com", syncedUser.getEmail());
        assertEquals("Updated", syncedUser.getFirstName());
        assertEquals("User", syncedUser.getLastName());
        verify(auth0Client, times(1)).getUserById("auth0|456");
        verify(userRepository, times(1)).save(any(User.class));
    }
    @Test
    void testBlockUserById() {
        // Mock existing database user
        User dbUser = User.builder()
                .userId("auth0|123")
                .email("user@example.com")
                .firstName("John")
                .lastName("Doe")
                .blocked(false)
                .build();
        when(userRepository.findByUserId("auth0|123")).thenReturn(Optional.of(dbUser));

        // Mock Auth0 call
        doNothing().when(auth0Client).blockUser("auth0|123", true);

        // Test method to block the user
        userService.blockUserById("auth0|123", true);

        // Verify database update
        verify(userRepository, times(1)).save(dbUser);
        assertTrue(dbUser.isBlocked());

        // Verify interaction with Auth0
        verify(auth0Client, times(1)).blockUser("auth0|123", true);

        // Test method to unblock the user
        userService.blockUserById("auth0|123", false);

        // Verify database update
        verify(userRepository, times(2)).save(dbUser);
        assertFalse(dbUser.isBlocked());

        // Verify interaction with Auth0
        verify(auth0Client, times(1)).blockUser("auth0|123", false);
    }

    @Test
    void testBlockUserByIdNotFound() {
        when(userRepository.findByUserId("nonexistent")).thenReturn(Optional.empty());

        // Test method and assert exception
        assertThrows(NotFoundException.class, () -> userService.blockUserById("nonexistent", true));

        // Verify no interactions with Auth0 or save
        verify(auth0Client, never()).blockUser(anyString(), anyBoolean());
        verify(userRepository, never()).save(any(User.class));
    }

}
