package com.lecoingameover.belecoingameover.CartService.DataAccessLayer;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class CartItem {
    @Id
    private String cartItemId;

    private String name;
    private double price;
    private String description;
}
