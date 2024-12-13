package com.lecoingameover.belecoingameover.Security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AuthenticationErrorHandlerTest {

    private AuthenticationErrorHandler authenticationErrorHandler;

    @Mock
    private ObjectMapper mapper;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private AuthenticationException authException;

    private StringWriter stringWriter;
    private PrintWriter printWriter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        authenticationErrorHandler = new AuthenticationErrorHandler(mapper);

        // Initialize StringWriter and PrintWriter
        stringWriter = new StringWriter();
        printWriter = new PrintWriter(stringWriter);
    }

    @Test
    void commence_shouldSetUnauthorizedStatusAndWriteErrorResponse() throws Exception {
        // Arrange
        when(response.getWriter()).thenReturn(printWriter);

        String errorMessageJson = "{\"message\":\"Requires authentication\"}";
        when(mapper.writeValueAsString(any())).thenReturn(errorMessageJson);

        // Act
        authenticationErrorHandler.commence(request, response, authException);

        // Assert
        verify(response).setStatus(HttpStatus.UNAUTHORIZED.value());
        verify(response).setContentType(MediaType.APPLICATION_JSON_VALUE);
        verify(mapper).writeValueAsString(any());

        // Assert that the written JSON matches the expected message
        assertEquals(errorMessageJson, stringWriter.toString().trim());
    }
}
