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
    void setUp() {
        MockitoAnnotations.openMocks(this);
        globalErrorHandler = new GlobalErrorHandler(mapper);

        stringWriter = new StringWriter();
        printWriter = new PrintWriter(stringWriter);
    }



    @Test
    void createBody_shouldSerializeErrorMessage() throws Exception {
        // Arrange
        String message = "Test message";
        String expectedJson = "{\"message\":\"Test message\"}";
        when(mapper.writeValueAsString(any())).thenReturn(expectedJson);

        // Act
        String result = globalErrorHandler.createBody(message);

        // Assert
        assertEquals(expectedJson, result);
        verify(mapper).writeValueAsString(any(GlobalErrorHandler.ErrorMessage.class));
    }


}
