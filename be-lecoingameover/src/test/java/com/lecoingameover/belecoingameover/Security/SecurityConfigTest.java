package com.lecoingameover.belecoingameover.Security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SecurityConfigTest {

    private SecurityConfig securityConfig;

    @Mock
    private AuthenticationErrorHandler authenticationErrorHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        securityConfig = new SecurityConfig(authenticationErrorHandler);
    }

    @Test
    void makePermissionsConverter_shouldReturnJwtAuthenticationConverter() {
        var jwtAuthConverter = securityConfig.makePermissionsConverter();
        assertNotNull(jwtAuthConverter, "JwtAuthenticationConverter should not be null");
    }

    @Test
    void corsFilter_shouldReturnCorsFilter() {
        CorsFilter corsFilter = securityConfig.corsFilter();
        assertNotNull(corsFilter, "CorsFilter should not be null");
    }

    @Test
    void corsConfigurationSource_shouldContainExpectedConfiguration() {
        UrlBasedCorsConfigurationSource source = securityConfig.corsConfigurationSource();

        assertNotNull(source, "UrlBasedCorsConfigurationSource should not be null");

        CorsConfiguration corsConfig = source.getCorsConfigurations().get("/**");
        assertNotNull(corsConfig, "CorsConfiguration should not be null");
        assertNotNull(corsConfig.getAllowedOrigins(), "Allowed origins should not be null");
        assertNotNull(corsConfig.getAllowedHeaders(), "Allowed headers should not be null");
        assertNotNull(corsConfig.getAllowedMethods(), "Allowed methods should not be null");
    }

}
