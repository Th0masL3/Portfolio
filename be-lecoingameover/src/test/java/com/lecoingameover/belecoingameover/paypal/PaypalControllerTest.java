package com.lecoingameover.belecoingameover.paypal;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Nested
@ExtendWith(MockitoExtension.class)
class PayPalControllerTest {

    @InjectMocks
    private PayPalController payPalController;

    @Mock
    private PayPalService payPalService;

    private MockMvc mockMvc;

    @Test
    void testCreateOrder_Success() throws Exception {
        // Arrange
        Double total = 100.0;
        String currency = "USD";
        String description = "Test Description";

        Map<String, Object> mockResponse = Map.of(
                "id", "test-order-id",
                "status", "CREATED",
                "links", Map.of("href", "http://mock-link.com")
        );
        when(payPalService.createOrder(total, currency, description)).thenReturn(mockResponse);

        mockMvc = MockMvcBuilders.standaloneSetup(payPalController).build();

        // Act & Assert
        mockMvc.perform(post("/api/paypal/create-order")
                        .param("total", String.valueOf(total))
                        .param("currency", currency)
                        .param("description", description)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("test-order-id"))
                .andExpect(jsonPath("$.status").value("CREATED"))
                .andExpect(jsonPath("$.links.href").value("http://mock-link.com"));
    }



    @Test
    void testCaptureOrder_Success() throws Exception {
        // Arrange
        String orderId = "test-order-id";

        Map<String, Object> mockResponse = Map.of("status", "COMPLETED");
        when(payPalService.captureOrder(orderId)).thenReturn(mockResponse);

        mockMvc = MockMvcBuilders.standaloneSetup(payPalController).build();

        // Act & Assert
        mockMvc.perform(post("/api/paypal/capture-order/{orderId}", orderId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("COMPLETED"));
    }

    @Test
    void testCreateOrder_BadRequest() throws Exception {
        // Arrange: Missing parameters
        mockMvc = MockMvcBuilders.standaloneSetup(payPalController).build();

        // Act & Assert
        mockMvc.perform(post("/api/paypal/create-order")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
