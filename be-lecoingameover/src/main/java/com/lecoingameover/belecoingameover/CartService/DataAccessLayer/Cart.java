package com.lecoingameover.belecoingameover.CartService.DataAccessLayer;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Document(collection = "cart")
public class Cart {

    private List<CartItem> cartItems;
}
