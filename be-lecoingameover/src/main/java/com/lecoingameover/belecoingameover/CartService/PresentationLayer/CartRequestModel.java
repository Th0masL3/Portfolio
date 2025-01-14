package com.lecoingameover.belecoingameover.CartService.PresentationLayer;


import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.CartItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartRequestModel {
    private List<CartItem> items;

    private double total;
}
