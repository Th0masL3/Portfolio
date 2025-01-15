package com.lecoingameover.belecoingameover.auth0;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lecoingameover.belecoingameover.presentationlayer.UserResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class Auth0ClientImpl implements Auth0Client {

    @Value("${auth0.domain}")
    String domain;

    @Value("${auth0.clientId}")
    String clientId;

    @Value("${auth0.clientSecret}")
    String clientSecret;

    @Value("${auth0.audience}")
    String audience;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public Auth0ClientImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public String getAccessToken() {
        Auth0TokenRequestModel requestModel = new Auth0TokenRequestModel(
                clientId, clientSecret, audience, "client_credentials"
        );

        log.info("Requesting Auth0 Management API Access Token...");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Auth0TokenRequestModel> request = new HttpEntity<>(requestModel, headers);

        ResponseEntity<Auth0TokenResponseModel> response = restTemplate.postForEntity(
                "https://" + domain + "/oauth/token", request, Auth0TokenResponseModel.class
        );

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            log.info("Auth0 Access Token Retrieved Successfully");
            return response.getBody().getAccessToken();
        } else {

            throw new RuntimeException("Auth0 Token Request Failed");
        }
    }

    @Override
    public UserResponseModel getUserById(String auth0UserId) {
        log.info("Fetching Auth0 User Details for User ID: {}", auth0UserId);

        String token = getAccessToken();
        Auth0UserResponseModel user = fetchUser(auth0UserId, token);
        List<Auth0RoleResponseModel> roles = fetchRoles(auth0UserId, token);
        List<Auth0PermissionResponseModel> permissions = fetchPermissions(auth0UserId, token);

        return mapToUserResponseModel(auth0UserId, user, roles, permissions);
    }

    @Override
    public List<UserResponseModel> getAllUsers() {
        log.info("Fetching all Auth0 Users");

        String token = getAccessToken();
        List<Auth0UserResponseModel> users = fetchAllUsers(token);

        return users.stream()
                .map(user -> {
                    List<Auth0RoleResponseModel> roles = fetchRoles(user.getUserId(), token);
                    List<Auth0PermissionResponseModel> permissions = fetchPermissions(user.getUserId(), token);
                    return mapToUserResponseModel(user.getUserId(), user, roles, permissions);
                })
                .collect(Collectors.toList());
    }

    public Auth0UserResponseModel fetchUser(String auth0UserId, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<Auth0UserResponseModel> response = restTemplate.exchange(
                "https://" + domain + "/api/v2/users/" + auth0UserId,
                HttpMethod.GET,
                request,
                Auth0UserResponseModel.class
        );

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            log.info("Fetched Auth0 User with ID {}: {}", auth0UserId, response.getBody());
            return response.getBody();
        } else {

            throw new RuntimeException("Failed to fetch Auth0 User");
        }
    }

    public List<Auth0UserResponseModel> fetchAllUsers(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<Auth0UserResponseModel[]> response = restTemplate.exchange(
                "https://" + domain + "/api/v2/users",
                HttpMethod.GET,
                request,
                Auth0UserResponseModel[].class
        );

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            log.info("Fetched all Auth0 Users");
            return List.of(response.getBody());
        } else {

            throw new RuntimeException("Failed to fetch all Auth0 Users");
        }
    }

    public List<Auth0RoleResponseModel> fetchRoles(String auth0UserId, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<Auth0RoleResponseModel[]> response = restTemplate.exchange(
                "https://" + domain + "/api/v2/users/" + auth0UserId + "/roles",
                HttpMethod.GET,
                request,
                Auth0RoleResponseModel[].class
        );

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            log.info("Fetched Roles for User ID {}: {}", auth0UserId, response.getBody());
            return List.of(response.getBody());
        } else {

            throw new RuntimeException("Failed to fetch roles");
        }
    }

    public List<Auth0PermissionResponseModel> fetchPermissions(String auth0UserId, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<Auth0PermissionResponseModel[]> response = restTemplate.exchange(
                "https://" + domain + "/api/v2/users/" + auth0UserId + "/permissions",
                HttpMethod.GET,
                request,
                Auth0PermissionResponseModel[].class
        );

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            log.info("Fetched Permissions for User ID {}: {}", auth0UserId, response.getBody());
            return List.of(response.getBody());
        } else {

            throw new RuntimeException("Failed to fetch permissions");
        }
    }

    private UserResponseModel mapToUserResponseModel(
            String auth0UserId,
            Auth0UserResponseModel auth0User,
            List<Auth0RoleResponseModel> roles,
            List<Auth0PermissionResponseModel> permissions) {

        List<String> roleNames = roles.stream().map(Auth0RoleResponseModel::getName).toList();
        List<String> permissionNames = permissions.stream().map(Auth0PermissionResponseModel::getName).toList();

        log.info("Mapping User Response for User ID {} with Roles and Permissions", auth0UserId);

        return UserResponseModel.builder()
                .userId(auth0User.getUserId())
                .email(auth0User.getEmail())
                .firstName(auth0User.getFirstName())
                .lastName(auth0User.getLastName())
                .roles(roleNames)
                .permissions(permissionNames)
                .build();
    }
    @Override
    public void assignRoleToUser(String auth0UserId, String roleName) {
        log.info("Assigning Role '{}' to User ID: {}", roleName, auth0UserId);

        try {
            // Obtain the access token
            String token = getAccessToken();

            // Prepare the API URL
            String url = "https://" + domain + "/api/v2/users/" + auth0UserId + "/roles";

            // Set headers
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(token);
            headers.setContentType(MediaType.APPLICATION_JSON);

            // Create the request body
            AssignRolesRequestModel requestBody = new AssignRolesRequestModel(roleName);

            // Wrap the request body and headers into an HttpEntity
            HttpEntity<AssignRolesRequestModel> request = new HttpEntity<>(requestBody, headers);

            // Make the POST request using RestTemplate
            ResponseEntity<Void> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    request,
                    Void.class
            );

            if (response.getStatusCode().is2xxSuccessful()) {
                log.info("Role '{}' assigned successfully to User ID: {}", roleName, auth0UserId);
            } else {
                log.error("Failed to assign role '{}' to User ID: {}. Status: {}", roleName, auth0UserId, response.getStatusCode());
                throw new RuntimeException("Failed to assign role to user");
            }
        } catch (Exception e) {
            log.error("Error assigning role '{}' to User ID: {}", roleName, auth0UserId, e);
            throw new RuntimeException("Error occurred while assigning role to user", e);
        }
    }


}