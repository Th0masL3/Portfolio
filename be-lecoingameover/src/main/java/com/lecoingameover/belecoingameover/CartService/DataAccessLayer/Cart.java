package com.lecoingameover.belecoingameover.CartService.DataAccessLayer;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Document(collection = "cart")
public class Cart {
    @Id
    private String cartId;

    private List<CartItem> items;

    private double total;
}
