package com.lecoingameover.belecoingameover.paypal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodyUriSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class PayPalServiceTest {

    @Mock
    private WebClient paypalWebClient;

    @InjectMocks
    private PayPalService payPalService;

    private RequestBodyUriSpec requestBodyUriSpec;
    private RequestHeadersSpec<?> requestHeadersSpec;
    private ResponseSpec responseSpec;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Mocking the WebClient behavior
        requestBodyUriSpec = mock(RequestBodyUriSpec.class);
        requestHeadersSpec = mock(RequestHeadersSpec.class);
        responseSpec = mock(ResponseSpec.class);

        when(paypalWebClient.post()).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(anyString())).thenReturn(requestBodyUriSpec);

        // Handle generics using Answer
        doAnswer(invocation -> requestHeadersSpec)
                .when(requestBodyUriSpec).bodyValue(any());

        doAnswer(invocation -> requestHeadersSpec)
                .when(requestHeadersSpec).headers(any());

        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
    }

    @Test
    void testGetAccessToken_success() {
        // Arrange
        Map<String, String> mockResponse = Map.of("access_token", "mock_access_token");
        when(responseSpec.bodyToMono(eq(Map.class))).thenReturn(Mono.just(mockResponse));

        // Act
        String accessToken = payPalService.getAccessToken();

        // Assert
        assertNotNull(accessToken);
        assertEquals("mock_access_token", accessToken);
    }


//    @Test
//    void testCreateOrder_success() {
//        // Arrange
//        Map<String, Object> mockOrderResponse = Map.of(
//                "id", "mock_order_id",
//                "status", "CREATED",
//                "links", List.of(Map.of("href", "http://mock-link.com"))
//        );
//
//        when(responseSpec.bodyToMono(any(ParameterizedTypeReference.class)))
//                .thenReturn(Mono.just(mockOrderResponse));
//        when(payPalService.getAccessToken()).thenReturn("mock_access_token");
//
//        // Act
//        Map<String, Object> orderResponse = payPalService.createOrder(100.0, "USD", "Mock Description");
//
//        // Assert
//        assertNotNull(orderResponse);
//        assertEquals("CREATED", orderResponse.get("status"));
//        assertEquals("mock_order_id", orderResponse.get("id"));
//        assertNotNull(orderResponse.get("links"));
//    }
//
//    @Test
//    void testCreateOrder_failure() {
//        // Arrange
//        when(responseSpec.bodyToMono(any(ParameterizedTypeReference.class))).thenReturn(Mono.empty());
//        when(payPalService.getAccessToken()).thenReturn("mock_access_token");
//
//        // Act & Assert
//        RuntimeException exception = assertThrows(RuntimeException.class, () ->
//                payPalService.createOrder(100.0, "USD", "Mock Description"));
//        assertEquals("Failed to create PayPal order", exception.getMessage());
//    }
//
//    @Test
//    void testCaptureOrder_success() {
//        // Arrange
//        Map<String, Object> mockCaptureResponse = Map.of("status", "COMPLETED");
//        when(responseSpec.bodyToMono(any(ParameterizedTypeReference.class)))
//                .thenReturn(Mono.just(mockCaptureResponse));
//        when(payPalService.getAccessToken()).thenReturn("mock_access_token");
//
//        // Act
//        Map<String, Object> captureResponse = payPalService.captureOrder("mock_order_id");
//
//        // Assert
//        assertNotNull(captureResponse);
//        assertEquals("COMPLETED", captureResponse.get("status"));
//    }
//
//    @Test
//    void testCaptureOrder_failure() {
//        // Arrange
//        when(responseSpec.bodyToMono(any(ParameterizedTypeReference.class)))
//                .thenThrow(new RuntimeException("Mock Exception"));
//        when(payPalService.getAccessToken()).thenReturn("mock_access_token");
//
//        // Act & Assert
//        RuntimeException exception = assertThrows(RuntimeException.class, () ->
//                payPalService.captureOrder("mock_order_id"));
//        assertEquals("Failed to capture PayPal order. Please try again later.", exception.getMessage());
//    }
}

