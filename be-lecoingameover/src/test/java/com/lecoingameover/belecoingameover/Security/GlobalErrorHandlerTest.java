package com.lecoingameover.belecoingameover.Security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class GlobalErrorHandlerTest {

    private GlobalErrorHandler globalErrorHandler;

    @Mock
    private ObjectMapper mapper;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    private StringWriter stringWriter;
    private PrintWriter printWriter;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        globalErrorHandler = new GlobalErrorHandler(mapper);

        stringWriter = new StringWriter();
        printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);
    }

    @Test
    void handleAuthenticationError_shouldSetUnauthorizedStatusAndWriteMessage() throws IOException {
        // Arrange
        String exceptionMessage = "Invalid token";
        String uri = "/test-uri";
        String expectedJson = "{\"message\":\"Unauthorized: Invalid token\"}";

        when(request.getRequestURI()).thenReturn(uri);
        when(mapper.writeValueAsString(any(GlobalErrorHandler.ErrorMessage.class))).thenReturn(expectedJson);

        // Act
        globalErrorHandler.handleAuthenticationError(request, response, new Exception(exceptionMessage));

        // Assert
        verify(response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        assertEquals(expectedJson, stringWriter.toString());
    }

    @Test
    void handleAccessDenied_shouldSetForbiddenStatusAndWriteMessage() throws IOException {
        // Arrange
        String exceptionMessage = "Access restricted";
        String uri = "/restricted-uri";
        String expectedJson = "{\"message\":\"Permission denied\"}";

        when(request.getRequestURI()).thenReturn(uri);
        when(mapper.writeValueAsString(any(GlobalErrorHandler.ErrorMessage.class))).thenReturn(expectedJson);

        // Act
        globalErrorHandler.handleAccessDenied(request, response, new Exception(exceptionMessage));

        // Assert
        verify(response).setStatus(HttpServletResponse.SC_FORBIDDEN);
        assertEquals(expectedJson, stringWriter.toString());
    }


    @Test
    void createBody_shouldSerializeErrorMessage() throws Exception {
        // Arrange
        String message = "Test message";
        String expectedJson = "{\"message\":\"Test message\"}";

        when(mapper.writeValueAsString(any(GlobalErrorHandler.ErrorMessage.class))).thenReturn(expectedJson);

        // Act
        String result = globalErrorHandler.createBody(message);

        // Assert
        assertEquals(expectedJson, result);
        verify(mapper).writeValueAsString(any(GlobalErrorHandler.ErrorMessage.class));
    }


}
