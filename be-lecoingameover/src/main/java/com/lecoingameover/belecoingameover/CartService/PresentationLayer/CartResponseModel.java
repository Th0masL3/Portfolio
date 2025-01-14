package com.lecoingameover.belecoingameover.CartService.PresentationLayer;

import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.CartItem;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Builder
@AllArgsConstructor
@Getter
@Setter
public class CartResponseModel {

    private String cartId;
    private List<CartItem> items;

    private double total;

}
