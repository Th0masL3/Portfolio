package com.lecoingameover.belecoingameover.presentationlayer;

import static org.junit.jupiter.api.Assertions.*;

// Controller Unit Test


import com.lecoingameover.belecoingameover.businesslayer.ProductService;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductControllerUnitTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    public ProductControllerUnitTest() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testAddProductByConsoleId() {
        // Arrange
        String consoleId = "console123";
        ProductRequestModel productRequest = ProductRequestModel.builder()
                .productName("Test Product")
                .productSalePrice(99.99)
                .productDescription("Test Description")
                .genre("Action")
                .productQuantity(10)
                .build();

        ProductResponseModel productResponse = ProductResponseModel.builder()
                .productId("product123")
                .productName("Test Product")
                .productSalePrice(99.99)
                .productDescription("Test Description")
                .genre("Action")
                .productQuantity(10)
                .build();

        when(productService.addProductByConsoleId(consoleId, productRequest)).thenReturn(productResponse);

        // Act
        ResponseEntity<ProductResponseModel> response = productController.addProduct(consoleId, productRequest);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(productResponse, response.getBody());
        verify(productService, times(1)).addProductByConsoleId(consoleId, productRequest);
    }
}

