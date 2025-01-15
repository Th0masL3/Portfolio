package com.lecoingameover.belecoingameover.CartService.PresentationLayer;

import com.lecoingameover.belecoingameover.CartService.BusinessLayer.CartService;
import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.CartItem;
import com.lecoingameover.belecoingameover.utils.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CartControllerTest {

    @Mock
    private CartService cartService;

    @InjectMocks
    private CartController cartController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCartById_ValidCartId_ReturnsCartResponse() {
        // Arrange
        String cartId = "1";
        CartResponseModel responseModel = CartResponseModel.builder()
                .cartId(cartId)
                .items(List.of(new CartItem("item1", "Product A", 10.0, "Description A")))
                .total(10.0)
                .build();

        when(cartService.getCartById(cartId)).thenReturn(responseModel);

        // Act
        ResponseEntity<CartResponseModel> response = cartController.getCartById(cartId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(responseModel, response.getBody());
        verify(cartService, times(1)).getCartById(cartId);
    }

    @Test
    void getCartById_CartNotFound_ThrowsNotFoundException() {
        // Arrange
        String cartId = "1";
        when(cartService.getCartById(cartId)).thenThrow(new NotFoundException("cart not found"));

        // Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class, () -> cartController.getCartById(cartId));
        assertEquals("cart not found", exception.getMessage());
        verify(cartService, times(1)).getCartById(cartId);
    }
}
