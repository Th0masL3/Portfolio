package com.lecoingameover.belecoingameover.CartService.PresentationLayer;

import com.lecoingameover.belecoingameover.CartService.BusinessLayer.CartService;
import com.lecoingameover.belecoingameover.businesslayer.ProductService;
import com.lecoingameover.belecoingameover.presentationlayer.ProductResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cart")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {
    private CartService cartService;
    public CartController(CartService cartService) {this.cartService = cartService;}

    @GetMapping("/{cartId}")
    public ResponseEntity<CartResponseModel> getCartById(@PathVariable("cartId") String cartId) {
        CartResponseModel cart = cartService.getCartById(cartId);
        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }
}
