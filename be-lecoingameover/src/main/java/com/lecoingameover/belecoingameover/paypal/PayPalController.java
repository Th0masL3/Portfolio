package com.lecoingameover.belecoingameover.paypal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/paypal")
public class PayPalController {

    @Autowired
    private PayPalService payPalService;

    @PostMapping("/create-order")
    public Map<String, Object> createOrder(@RequestParam Double total,
                                           @RequestParam String currency,
                                           @RequestParam String description) {
        return payPalService.createOrder(total, currency, description);
    }

    @PostMapping("/capture-order/{orderId}")
    public Map<String, Object> captureOrder(@PathVariable String orderId) {
        return payPalService.captureOrder(orderId);
    }
}

