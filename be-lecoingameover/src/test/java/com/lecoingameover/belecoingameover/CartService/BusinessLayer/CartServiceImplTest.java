package com.lecoingameover.belecoingameover.CartService.BusinessLayer;

import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.Cart;
import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.CartItem;
import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.CartRepository;
import com.lecoingameover.belecoingameover.CartService.DataMapperLayer.CartResponseMapper;
import com.lecoingameover.belecoingameover.CartService.PresentationLayer.CartResponseModel;
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
}
