package com.lecoingameover.belecoingameover.auth0;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lecoingameover.belecoingameover.presentationlayer.UserResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
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

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private Auth0ClientImpl auth0Client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize the mocked client with values
        auth0Client = spy(new Auth0ClientImpl(restTemplate, objectMapper));
        auth0Client.domain = "mock-domain";
        auth0Client.clientId = "mock-client-id";
        auth0Client.clientSecret = "mock-client-secret";
        auth0Client.audience = "mock-audience";
    }

    @Test
    void testGetAccessToken() {
        Auth0TokenResponseModel tokenResponse = new Auth0TokenResponseModel();
        tokenResponse.setAccessToken("mock-access-token");

        when(restTemplate.postForEntity(
                eq("https://mock-domain/oauth/token"),
                any(HttpEntity.class),
                eq(Auth0TokenResponseModel.class)
        )).thenReturn(new ResponseEntity<>(tokenResponse, HttpStatus.OK));

        String accessToken = auth0Client.getAccessToken();

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
        mockUser.setFirstName("John");
        mockUser.setLastName("Doe");

        when(restTemplate.exchange(
                eq("https://mock-domain/api/v2/users/" + auth0UserId),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(Auth0UserResponseModel.class)
        )).thenReturn(new ResponseEntity<>(mockUser, HttpStatus.OK));

        Auth0UserResponseModel user = auth0Client.fetchUser(auth0UserId, token);

        assertNotNull(user);
        assertEquals(auth0UserId, user.getUserId());
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());

        verify(restTemplate, times(1)).exchange(
                eq("https://mock-domain/api/v2/users/" + auth0UserId),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(Auth0UserResponseModel.class)
        );
    }

    @Test
    void testFetchRoles() {
        String auth0UserId = "auth0|123";
        String token = "mock-access-token";

        Auth0RoleResponseModel mockRole = new Auth0RoleResponseModel();
        mockRole.setId("role-id");
        mockRole.setName("Admin");
        mockRole.setDescription("Administrator Role");

        when(restTemplate.exchange(
                eq("https://mock-domain/api/v2/users/" + auth0UserId + "/roles"),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(Auth0RoleResponseModel[].class)
        )).thenReturn(new ResponseEntity<>(new Auth0RoleResponseModel[]{mockRole}, HttpStatus.OK));

        List<Auth0RoleResponseModel> roles = auth0Client.fetchRoles(auth0UserId, token);

        assertNotNull(roles);
        assertEquals(1, roles.size());
        assertEquals("Admin", roles.get(0).getName());
        assertEquals("role-id", roles.get(0).getId());

        verify(restTemplate, times(1)).exchange(
                eq("https://mock-domain/api/v2/users/" + auth0UserId + "/roles"),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(Auth0RoleResponseModel[].class)
        );
    }

    @Test
    void testFetchPermissions() {
        String auth0UserId = "auth0|123";
        String token = "mock-access-token";

        Auth0PermissionResponseModel mockPermission = new Auth0PermissionResponseModel();
        mockPermission.setName("read:users");
        mockPermission.setDescription("Read user details");

        when(restTemplate.exchange(
                eq("https://mock-domain/api/v2/users/" + auth0UserId + "/permissions"),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(Auth0PermissionResponseModel[].class)
        )).thenReturn(new ResponseEntity<>(new Auth0PermissionResponseModel[]{mockPermission}, HttpStatus.OK));

        List<Auth0PermissionResponseModel> permissions = auth0Client.fetchPermissions(auth0UserId, token);

        assertNotNull(permissions);
        assertEquals(1, permissions.size());
        assertEquals("read:users", permissions.get(0).getName());
        assertEquals("Read user details", permissions.get(0).getDescription());

        verify(restTemplate, times(1)).exchange(
                eq("https://mock-domain/api/v2/users/" + auth0UserId + "/permissions"),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(Auth0PermissionResponseModel[].class)
        );
    }

    @Test
    void testGetUserById() {
        String auth0UserId = "auth0|123";
        String token = "mock-access-token";

        Auth0UserResponseModel mockUser = new Auth0UserResponseModel();
        mockUser.setUserId(auth0UserId);
        mockUser.setEmail("test@example.com");
        mockUser.setFirstName("John");
        mockUser.setLastName("Doe");

        doReturn(token).when(auth0Client).getAccessToken();
        doReturn(mockUser).when(auth0Client).fetchUser(auth0UserId, token);
        doReturn(List.of()).when(auth0Client).fetchRoles(auth0UserId, token);
        doReturn(List.of()).when(auth0Client).fetchPermissions(auth0UserId, token);

        UserResponseModel user = auth0Client.getUserById(auth0UserId);

        assertNotNull(user);
        assertEquals(auth0UserId, user.getUserId());
        assertEquals("test@example.com", user.getEmail());
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());

        verify(auth0Client, times(1)).getAccessToken();
        verify(auth0Client, times(1)).fetchUser(auth0UserId, token);
        verify(auth0Client, times(1)).fetchRoles(auth0UserId, token);
        verify(auth0Client, times(1)).fetchPermissions(auth0UserId, token);
    }
    @Test
    void testFetchAllUsers() {
        String token = "mock-access-token";

        Auth0UserResponseModel user1 = new Auth0UserResponseModel();
        user1.setUserId("auth0|123");
        user1.setEmail("user1@example.com");
        user1.setFirstName("User");
        user1.setLastName("One");

        Auth0UserResponseModel user2 = new Auth0UserResponseModel();
        user2.setUserId("auth0|456");
        user2.setEmail("user2@example.com");
        user2.setFirstName("User");
        user2.setLastName("Two");

        Auth0UserResponseModel[] mockUsers = {user1, user2};

        when(restTemplate.exchange(
                eq("https://mock-domain/api/v2/users"),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(Auth0UserResponseModel[].class)
        )).thenReturn(new ResponseEntity<>(mockUsers, HttpStatus.OK));

        List<Auth0UserResponseModel> users = auth0Client.fetchAllUsers(token);

        assertNotNull(users);
        assertEquals(2, users.size());
        assertEquals("auth0|123", users.get(0).getUserId());
        assertEquals("auth0|456", users.get(1).getUserId());
        verify(restTemplate, times(1)).exchange(
                eq("https://mock-domain/api/v2/users"),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(Auth0UserResponseModel[].class)
        );
    }
    @Test
    void testGetAllUsers() {
        String token = "mock-access-token";


        Auth0UserResponseModel mockUser = new Auth0UserResponseModel();
        mockUser.setUserId("auth0|123");
        mockUser.setEmail("user1@example.com");
        mockUser.setFirstName("User");
        mockUser.setLastName("One");

        Auth0RoleResponseModel mockRole = new Auth0RoleResponseModel();
        mockRole.setName("Admin");

        Auth0PermissionResponseModel mockPermission = new Auth0PermissionResponseModel();
        mockPermission.setName("read:users");

        doReturn(token).when(auth0Client).getAccessToken();
        doReturn(List.of(mockUser)).when(auth0Client).fetchAllUsers(token);
        doReturn(List.of(mockRole)).when(auth0Client).fetchRoles("auth0|123", token);
        doReturn(List.of(mockPermission)).when(auth0Client).fetchPermissions("auth0|123", token);

        List<UserResponseModel> users = auth0Client.getAllUsers();

        assertNotNull(users);
        assertEquals(1, users.size());
        assertEquals("auth0|123", users.get(0).getUserId());
        assertEquals("user1@example.com", users.get(0).getEmail());
        assertEquals(List.of("Admin"), users.get(0).getRoles());
        assertEquals(List.of("read:users"), users.get(0).getPermissions());
    }

}

