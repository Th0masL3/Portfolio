package com.lecoingameover.belecoingameover.Security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


import java.io.IOException;

@Component
@Slf4j
public class GlobalErrorHandler {

    private final ObjectMapper mapper;

    public GlobalErrorHandler(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public void handleAuthenticationError(HttpServletRequest request, HttpServletResponse response, Exception ex) throws IOException {
        log.warn("Authentication error: {}, URI: {}", ex.getMessage(), request.getRequestURI());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(createBody("Unauthorized: " + ex.getMessage()));
    }

    public void handleAccessDenied(HttpServletRequest request, HttpServletResponse response, Exception ex) throws IOException {
        log.warn("Access denied for URI: {}. Message: {}", request.getRequestURI(), ex.getMessage());
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write(createBody("Permission denied"));
    }

    String createBody(String message) {
        try {
            return mapper.writeValueAsString(new ErrorMessage(message));
        } catch (IOException e) {
            log.error("Error serializing response body: {}", e.getMessage());
            return "{\"message\":\"" + message + "\"}";
        }
    }

    static class ErrorMessage {
        private final String message;

        public ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
