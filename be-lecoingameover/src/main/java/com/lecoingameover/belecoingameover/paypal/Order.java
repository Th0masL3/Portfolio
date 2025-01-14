package com.lecoingameover.belecoingameover.paypal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderId;
    private String status;
    private Double amount;
    private String currency;
    private String description;
}
