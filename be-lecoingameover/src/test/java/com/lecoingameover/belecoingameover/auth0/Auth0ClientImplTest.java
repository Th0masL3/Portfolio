/*
package com.lecoingameover.belecoingameover.auth0;

import com.lecoingameover.belecoingameover.presentationlayer.UserResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class Auth0ClientImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private Auth0ClientImpl auth0Client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        auth0Client = spy(new Auth0ClientImpl(restTemplate, null));
        auth0Client.domain = "mock-domain";
        auth0Client.clientId = "mock-client-id";
        auth0Client.clientSecret = "mock-client-secret";
        auth0Client.audience = "mock-audience";
    }

    @Test
    void testGetAccessToken() {
        // Mock response
        Auth0TokenResponseModel tokenResponse = new Auth0TokenResponseModel();
        tokenResponse.setAccessToken("mock-access-token");

        when(restTemplate.postForEntity(
                eq("https://mock-domain/oauth/token"),
                any(HttpEntity.class),
                eq(Auth0TokenResponseModel.class)
        )).thenReturn(new ResponseEntity<>(tokenResponse, HttpStatus.OK));

        // Test
        String accessToken = auth0Client.getAccessToken();

        // Assert
        assertNotNull(accessToken);
        assertEquals("mock-access-token", accessToken);
    }

    @Test
    void testFetchUser() {
        String auth0UserId = "auth0|123";
        String token = "mock-access-token";

        Auth0UserResponseModel mockUser = new Auth0UserResponseModel();
        mockUser.setUserId(auth0UserId);
        mockUser.setEmail("test@example.com");

        when(restTemplate.exchange(
                eq("https://mock-domain/api/v2/users/" + auth0UserId),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(Auth0UserResponseModel.class)
        )).thenReturn(new ResponseEntity<>(mockUser, HttpStatus.OK));

        // Test
        Auth0UserResponseModel user = auth0Client.fetchUser(auth0UserId, token);

        // Assert
        assertNotNull(user);
        assertEquals(auth0UserId, user.getUserId());
    }

    @Test
    void testFetchRoles() {
        String auth0UserId = "auth0|123";
        String token = "mock-access-token";

        Auth0RoleResponseModel mockRole = new Auth0RoleResponseModel();
        mockRole.setName("Admin");

        when(restTemplate.exchange(
                eq("https://mock-domain/api/v2/users/" + auth0UserId + "/roles"),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(Auth0RoleResponseModel[].class)
        )).thenReturn(new ResponseEntity<>(new Auth0RoleResponseModel[]{mockRole}, HttpStatus.OK));

        // Test
        List<Auth0RoleResponseModel> roles = auth0Client.fetchRoles(auth0UserId, token);

        // Assert
        assertNotNull(roles);
        assertEquals(1, roles.size());
        assertEquals("Admin", roles.get(0).getName());
    }

    @Test
    void testFetchPermissions() {
        String auth0UserId = "auth0|123";
        String token = "mock-access-token";

        Auth0PermissionResponseModel mockPermission = new Auth0PermissionResponseModel();
        mockPermission.setName("read:users");

        when(restTemplate.exchange(
                eq("https://mock-domain/api/v2/users/" + auth0UserId + "/permissions"),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(Auth0PermissionResponseModel[].class)
        )).thenReturn(new ResponseEntity<>(new Auth0PermissionResponseModel[]{mockPermission}, HttpStatus.OK));

        // Test
        List<Auth0PermissionResponseModel> permissions = auth0Client.fetchPermissions(auth0UserId, token);

        // Assert
        assertNotNull(permissions);
        assertEquals(1, permissions.size());
        assertEquals("read:users", permissions.get(0).getName());
    }

    @Test
    void testFetchAllUsers() {
        String token = "mock-access-token";

        Auth0UserResponseModel mockUser1 = new Auth0UserResponseModel();
        mockUser1.setUserId("auth0|123");
        mockUser1.setEmail("user1@example.com");

        Auth0UserResponseModel mockUser2 = new Auth0UserResponseModel();
        mockUser2.setUserId("auth0|456");
        mockUser2.setEmail("user2@example.com");

        when(restTemplate.exchange(
                eq("https://mock-domain/api/v2/users"),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(Auth0UserResponseModel[].class)
        )).thenReturn(new ResponseEntity<>(new Auth0UserResponseModel[]{mockUser1, mockUser2}, HttpStatus.OK));

        // Test
        List<Auth0UserResponseModel> users = auth0Client.fetchAllUsers(token);

        // Assert
        assertNotNull(users);
        assertEquals(2, users.size());
        assertEquals("auth0|123", users.get(0).getUserId());
    }
}
*/