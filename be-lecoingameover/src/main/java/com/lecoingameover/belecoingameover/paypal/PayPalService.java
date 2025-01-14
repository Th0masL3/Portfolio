package com.lecoingameover.belecoingameover.paypal;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class PayPalService {

    @Autowired
    private WebClient paypalWebClient;

    public String getAccessToken() {
        return paypalWebClient.post()
                .uri("/v1/oauth2/token")
                .bodyValue("grant_type=client_credentials")
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> (String) response.get("access_token"))
                .block();
    }


    public Map<String, Object> createOrder(Double total, String currency, String description) {
        String accessToken = getAccessToken();
        Map<String, Object> orderPayload = new HashMap<>();
        orderPayload.put("intent", "CAPTURE");
        orderPayload.put("purchase_units", new Object[]{
                Map.of("amount", Map.of(
                        "currency_code", currency,
                        "value", total
                ), "description", description)
        });

        return paypalWebClient.post()
                .uri("/v2/checkout/orders")
                .headers(headers -> headers.setBearerAuth(accessToken))
                .bodyValue(orderPayload)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                .block();
    }


    public Map<String, Object> captureOrder(String orderId) {
        String accessToken = getAccessToken();
        return paypalWebClient.post()
                .uri("/v2/checkout/orders/" + orderId + "/capture")
                .headers(headers -> headers.setBearerAuth(accessToken))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                .block();
    }
}
