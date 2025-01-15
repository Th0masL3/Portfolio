/*package com.lecoingameover.belecoingameover.CartService.PresentationLayer;

import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.Cart;
import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.CartItem;
import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CartControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CartRepository cartRepository;

    @BeforeEach
    void setUp() {
        cartRepository.deleteAll();
    }

    @Test
    void getCartById_ValidCartId_ReturnsCartResponse() throws Exception {
        // Arrange
        Cart cart = Cart.builder()
                .cartId("1")
                .items(List.of(new CartItem("item1", "Product A", 10.0, "Description A")))
                .total(10.0)
                .build();
        cartRepository.save(cart);

        // Act & Assert
        mockMvc.perform(get("/api/v1/cart/1"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.cartId").value("1"))
                .andExpect((ResultMatcher) jsonPath("$.total").value(10.0))
                .andExpect((ResultMatcher) jsonPath("$.items[0].name").value("Product A"));
    }

    @Test
    void getCartById_CartNotFound_Returns404() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/api/v1/cart/1"))
                .andExpect(status().isNotFound());
    }
}
*/
