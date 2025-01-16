package com.lecoingameover.belecoingameover.CartService.PresentationLayer;

import com.lecoingameover.belecoingameover.CartService.BusinessLayer.CartService;
import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.CartItem;
import com.lecoingameover.belecoingameover.presentationlayer.ConsoleRequestModel;
import com.lecoingameover.belecoingameover.presentationlayer.ProductRequestModel;
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
    @Test
    void addProductToCartItem_ValidRequest_ReturnsCreatedResponse() {
        // Arrange
        String productId = "product1";
        ProductRequestModel productRequest = ProductRequestModel.builder()

                .productName("Product A")
                .productSalePrice(20.0)
                .productDescription("Description A")
                .genre("Action")
                .productQuantity(5)
                .image("productImage.jpg")
                .build();

        CartResponseModel responseModel = CartResponseModel.builder()
                .cartId("1")
                .items(List.of(new CartItem(productId, "Product A", 20.0, "Description A")))
                .total(20.0)
                .build();

        when(cartService.addProductToCartItem(productRequest, productId)).thenReturn(responseModel);

        // Act
        ResponseEntity<CartResponseModel> response = cartController.addProductToCartItem(productRequest, productId);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(responseModel, response.getBody());
        verify(cartService, times(1)).addProductToCartItem(productRequest, productId);
    }

    @Test
    void addProductToCartItem_ProductNotFound_ThrowsNotFoundException() {
        // Arrange
        String productId = "product1";
        ProductRequestModel productRequest = ProductRequestModel.builder().build();

        when(cartService.addProductToCartItem(productRequest, productId))
                .thenThrow(new NotFoundException("Product not found"));

        // Act & Assert
        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> cartController.addProductToCartItem(productRequest, productId)
        );
        assertEquals("Product not found", exception.getMessage());
        verify(cartService, times(1)).addProductToCartItem(productRequest, productId);
    }

    @Test
    void addConsoleToCartItem_ValidRequest_ReturnsCreatedResponse() {
        // Arrange
        String consoleId = "console1";
        ConsoleRequestModel consoleRequest = ConsoleRequestModel.builder()

                .consoleName("Console A")
                .price(299.99)
                .company("Company A")
                .build();

        CartResponseModel responseModel = CartResponseModel.builder()
                .cartId("1")
                .items(List.of(new CartItem(consoleId, "Console A", 299.99, "Company A")))
                .total(299.99)
                .build();

        when(cartService.addConsoleToCartItem(consoleRequest, consoleId)).thenReturn(responseModel);

        // Act
        ResponseEntity<CartResponseModel> response = cartController.addConsoleToCartItem(consoleRequest, consoleId);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(responseModel, response.getBody());
        verify(cartService, times(1)).addConsoleToCartItem(consoleRequest, consoleId);
    }

    @Test
    void addConsoleToCartItem_ConsoleNotFound_ThrowsNotFoundException() {
        // Arrange
        String consoleId = "console1";
        ConsoleRequestModel consoleRequest = ConsoleRequestModel.builder().build();

        when(cartService.addConsoleToCartItem(consoleRequest, consoleId))
                .thenThrow(new NotFoundException("Console not found"));

        // Act & Assert
        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> cartController.addConsoleToCartItem(consoleRequest, consoleId)
        );
        assertEquals("Console not found", exception.getMessage());
        verify(cartService, times(1)).addConsoleToCartItem(consoleRequest, consoleId);
    }
    @Test
    void deleteCartItemByCartItemId_ValidRequest_ReturnsNoContent() {
        // Arrange
        String cartItemId = "item123";
        doNothing().when(cartService).deleteCartItemByCartItemId(cartItemId);

        // Act
        ResponseEntity<Void> response = cartController.deleteCartItemByCartItemId(cartItemId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(cartService, times(1)).deleteCartItemByCartItemId(cartItemId);
    }

    @Test
    void deleteCartItemByCartItemId_ItemNotFound_ThrowsNotFoundException() {
        // Arrange
        String cartItemId = "item123";
        doThrow(new NotFoundException("Product with ID " + cartItemId + " not found"))
                .when(cartService).deleteCartItemByCartItemId(cartItemId);

        // Act & Assert
        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> cartController.deleteCartItemByCartItemId(cartItemId)
        );

        assertEquals("Product with ID item123 not found", exception.getMessage());
        verify(cartService, times(1)).deleteCartItemByCartItemId(cartItemId);
    }

    @Test
    void deleteCartItemByCartItemId_CartNotFound_ThrowsNotFoundException() {
        // Arrange
        String cartItemId = "item123";
        doThrow(new NotFoundException("Cart not found"))
                .when(cartService).deleteCartItemByCartItemId(cartItemId);

        // Act & Assert
        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> cartController.deleteCartItemByCartItemId(cartItemId)
        );

        assertEquals("Cart not found", exception.getMessage());
        verify(cartService, times(1)).deleteCartItemByCartItemId(cartItemId);
    }

}
