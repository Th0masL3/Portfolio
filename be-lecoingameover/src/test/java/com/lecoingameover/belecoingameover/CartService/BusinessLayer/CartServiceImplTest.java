package com.lecoingameover.belecoingameover.CartService.BusinessLayer;

import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.Cart;
import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.CartItem;
import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.CartItemRepository;
import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.CartRepository;
import com.lecoingameover.belecoingameover.CartService.DataMapperLayer.CartResponseMapper;
import com.lecoingameover.belecoingameover.CartService.PresentationLayer.CartResponseModel;
import com.lecoingameover.belecoingameover.presentationlayer.ConsoleRequestModel;
import com.lecoingameover.belecoingameover.presentationlayer.ProductRequestModel;
import com.lecoingameover.belecoingameover.utils.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CartServiceImplTest {

    @Mock
    private CartRepository cartRepository;
    @Mock
    private CartItemRepository cartItemRepository;

    @Mock
    private CartResponseMapper cartResponseMapper;

    @InjectMocks
    private CartServiceImpl cartService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCartById_CartExists_ReturnsCartResponse() {
        // Arrange
        String cartId = "1";
        Cart cart = Cart.builder()
                .cartId(cartId)
                .items(List.of(new CartItem("item1", "Product A", 10.0, "Description A")))
                .build();
        cart.setTotal(10.0);

        CartResponseModel responseModel = CartResponseModel.builder()
                .cartId(cartId)
                .items(cart.getItems())
                .total(10.0)
                .build();

        when(cartRepository.findCartByCartId(cartId)).thenReturn(cart);
        when(cartResponseMapper.entityToResponseModel(cart)).thenReturn(responseModel);

        // Act
        CartResponseModel result = cartService.getCartById(cartId);

        // Assert
        assertNotNull(result);
        assertEquals(cartId, result.getCartId());
        assertEquals(10.0, result.getTotal());
        verify(cartRepository, times(1)).findCartByCartId(cartId);
        verify(cartResponseMapper, times(1)).entityToResponseModel(cart);
    }

    @Test
    void getCartById_CartNotFound_ThrowsNotFoundException() {
        // Arrange
        String cartId = "1";
        when(cartRepository.findCartByCartId(cartId)).thenReturn(null);

        // Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class, () -> cartService.getCartById(cartId));
        assertEquals("cart not found", exception.getMessage());
        verify(cartRepository, times(1)).findCartByCartId(cartId);
    }

    @Test
    void getCartById_CartEmpty_ThrowsNotFoundException() {
        // Arrange
        String cartId = "1";
        Cart cart = Cart.builder().cartId(cartId).items(List.of()).build();
        when(cartRepository.findCartByCartId(cartId)).thenReturn(cart);

        // Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class, () -> cartService.getCartById(cartId));
        assertEquals("cart is empty", exception.getMessage());
        verify(cartRepository, times(1)).findCartByCartId(cartId);
    }
 /*   @Test
    void addProductToCartItem_ValidRequest_AddsProductSuccessfully() {
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

        Cart cart = Cart.builder()
                .cartId("1")
                .items(List.of())
                .total(0.0)
                .build();

        Cart updatedCart = Cart.builder()
                .cartId("1")
                .items(List.of(new CartItem(productId, "Product A", 20.0, "Description A")))
                .total(20.0)
                .build();

        CartResponseModel responseModel = CartResponseModel.builder()
                .cartId("1")
                .items(updatedCart.getItems())
                .total(20.0)
                .build();

        when(cartRepository.findCartByCartId("1")).thenReturn(cart);
        when(cartRepository.save(any(Cart.class))).thenReturn(updatedCart);
        when(cartResponseMapper.entityToResponseModel(updatedCart)).thenReturn(responseModel);

        // Act
        CartResponseModel result = cartService.addProductToCartItem(productRequest, productId);

        // Assert
        assertNotNull(result);
        assertEquals("1", result.getCartId());
        assertEquals(20.0, result.getTotal());
        verify(cartRepository, times(1)).findCartByCartId("1");
        verify(cartRepository, times(1)).save(any(Cart.class));
        verify(cartResponseMapper, times(1)).entityToResponseModel(updatedCart);
    }

    @Test
    void addProductToCartItem_ProductNotFound_ThrowsNotFoundException() {
        // Arrange
        String productId = "product1";
        ProductRequestModel productRequest = ProductRequestModel.builder().build();

        when(cartRepository.findCartByCartId("1")).thenReturn(null);

        // Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> cartService.addProductToCartItem(productRequest, productId));
        assertEquals("Cart with ID 1 not found", exception.getMessage());
        verify(cartRepository, times(1)).findCartByCartId("1");
    }

    @Test
    void addConsoleToCartItem_ValidRequest_AddsConsoleSuccessfully() {
        // Arrange
        String consoleId = "console1";
        ConsoleRequestModel consoleRequest = ConsoleRequestModel.builder()

                .consoleName("Console A")
                .price(299.99)
                .company("Company A")
                .build();

        Cart cart = Cart.builder()
                .cartId("1")
                .items(List.of())
                .total(0.0)
                .build();

        Cart updatedCart = Cart.builder()
                .cartId("1")
                .items(List.of(new CartItem(consoleId, "Console A", 299.99, "Company A")))
                .total(299.99)
                .build();

        CartResponseModel responseModel = CartResponseModel.builder()
                .cartId("1")
                .items(updatedCart.getItems())
                .total(299.99)
                .build();

        when(cartRepository.findCartByCartId("1")).thenReturn(cart);
        when(cartRepository.save(any(Cart.class))).thenReturn(updatedCart);
        when(cartResponseMapper.entityToResponseModel(updatedCart)).thenReturn(responseModel);

        // Act
        CartResponseModel result = cartService.addConsoleToCartItem(consoleRequest, consoleId);

        // Assert
        assertNotNull(result);
        assertEquals("1", result.getCartId());
        assertEquals(299.99, result.getTotal());
        verify(cartRepository, times(1)).findCartByCartId("1");
        verify(cartRepository, times(1)).save(any(Cart.class));
        verify(cartResponseMapper, times(1)).entityToResponseModel(updatedCart);
    }

    @Test
    void addConsoleToCartItem_ConsoleNotFound_ThrowsNotFoundException() {
        // Arrange
        String consoleId = "console1";
        ConsoleRequestModel consoleRequest = ConsoleRequestModel.builder().build();

        when(cartRepository.findCartByCartId("1")).thenReturn(null);

        // Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> cartService.addConsoleToCartItem(consoleRequest, consoleId));
        assertEquals("Cart with ID 1 not found", exception.getMessage());
        verify(cartRepository, times(1)).findCartByCartId("1");
    }
    */
    /*
 @Test
 void deleteCartItemByCartItemId_ValidRequest_DeletesCartItemSuccessfully() {
     // Arrange
     String cartItemId = "item123";
     CartItem cartItem = new CartItem(cartItemId, "Product A", 10.0, "Description A");
     Cart cart = Cart.builder()
             .cartId("1")
             .items(List.of(cartItem))
             .total(10.0)
             .build();

     when(cartItemRepository.findCartItemByCartItemId(cartItemId)).thenReturn(cartItem);
     when(cartRepository.findCartByCartId("1")).thenReturn(cart);

     // Act
     cartService.deleteCartItemByCartItemId(cartItemId);

     // Assert
     verify(cartItemRepository, times(1)).delete(cartItem);
     verify(cartRepository, times(1)).save(cart);
     assertEquals(0, cart.getItems().size(), "Cart should have no items left");
     assertEquals(0.0, cart.getTotal(), "Cart total should be updated to 0.0");
 }
*/
    @Test
    void deleteCartItemByCartItemId_ItemNotFound_ThrowsNotFoundException() {
        // Arrange
        String cartItemId = "item123";
        when(cartItemRepository.findCartItemByCartItemId(cartItemId)).thenReturn(null);

        // Act & Assert
        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> cartService.deleteCartItemByCartItemId(cartItemId)
        );

        assertEquals("Product with ID item123 not found", exception.getMessage());
        verify(cartItemRepository, times(1)).findCartItemByCartItemId(cartItemId);
        verify(cartRepository, never()).save(any());
    }

  /*  @Test
    void deleteCartItemByCartItemId_CartNotFound_ThrowsNotFoundException() {
        // Arrange
        String cartItemId = "item123";
        CartItem cartItem = new CartItem(cartItemId, "Product A", 10.0, "Description A");
        when(cartItemRepository.findCartItemByCartItemId(cartItemId)).thenReturn(cartItem);
        when(cartRepository.findCartByCartId("1")).thenReturn(null);

        // Act & Assert
        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> cartService.deleteCartItemByCartItemId(cartItemId)
        );

        assertEquals("Cart not found", exception.getMessage());
        verify(cartItemRepository, times(1)).findCartItemByCartItemId(cartItemId);
        verify(cartRepository, never()).save(any());
    }
*/

}
