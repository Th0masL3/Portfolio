package com.lecoingameover.belecoingameover.CartService.PresentationLayer;

import com.lecoingameover.belecoingameover.CartService.BusinessLayer.CartService;
import com.lecoingameover.belecoingameover.businesslayer.ProductService;
import com.lecoingameover.belecoingameover.dataaccess.Product;
import com.lecoingameover.belecoingameover.presentationlayer.ConsoleRequestModel;
import com.lecoingameover.belecoingameover.presentationlayer.ConsoleResponseModel;
import com.lecoingameover.belecoingameover.presentationlayer.ProductRequestModel;
import com.lecoingameover.belecoingameover.presentationlayer.ProductResponseModel;
import jakarta.validation.Valid;
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
    @PostMapping("/product/{productId}")
    public ResponseEntity<CartResponseModel> addProductToCartItem(@Valid @RequestBody ProductRequestModel productRequestModel,@PathVariable("productId") String productId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.addProductToCartItem(productRequestModel,productId));
    }
    @PostMapping("/console/{consoleId}")
    public ResponseEntity<CartResponseModel> addConsoleToCartItem(@Valid @RequestBody ConsoleRequestModel consoleRequestModel,@PathVariable("consoleId") String consoleId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.addConsoleToCartItem(consoleRequestModel,consoleId));
    }
}
