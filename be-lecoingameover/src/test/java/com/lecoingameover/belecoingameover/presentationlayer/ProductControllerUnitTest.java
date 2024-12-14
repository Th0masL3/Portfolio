package com.lecoingameover.belecoingameover.presentationlayer;

import static org.junit.jupiter.api.Assertions.*;

// Controller Unit Test


import com.lecoingameover.belecoingameover.businesslayer.ProductService;

import com.lecoingameover.belecoingameover.utils.exceptions.NotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void testGetProductsByConsoleId_Positive() {
        // Arrange
        String consoleId = "123";

        ProductResponseModel product1 = ProductResponseModel.builder()
                .productId("product1234")
                .productName("Sample Product")
                .productSalePrice(111.99)
                .productDescription("Test Description")
                .genre("Racing")
                .productQuantity(20)
                .build();

        ProductResponseModel product2 = ProductResponseModel.builder()
                .productId("product123")
                .productName("Test Product")
                .productSalePrice(99.99)
                .productDescription("Test Description")
                .genre("Action")
                .productQuantity(10)
                .build();

        List<ProductResponseModel> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        when(productService.getProductsByConsoleId(consoleId)).thenReturn(products);

        // Act
        ResponseEntity<List<ProductResponseModel>> response = productController.getProductsByConsoleId(consoleId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
        assertEquals("Sample Product", response.getBody().get(0).getProductName());
        assertEquals("Test Product", response.getBody().get(1).getProductName());
        verify(productService, times(1)).getProductsByConsoleId(consoleId);
    }

    @Test
    void testGetProductsByConsoleId_EmptyList() {
        // Arrange
        String consoleId = "123";
        when(productService.getProductsByConsoleId(consoleId)).thenReturn(new ArrayList<>());

        // Act
        ResponseEntity<List<ProductResponseModel>> response = productController.getProductsByConsoleId(consoleId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().isEmpty());
        verify(productService, times(1)).getProductsByConsoleId(consoleId);
    }

    @Test
    void testGetProductsByConsoleId_NotFound() {
        // Arrange
        String consoleId = "123";
        when(productService.getProductsByConsoleId(consoleId)).thenThrow(new NotFoundException("Products not found"));

        // Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> productController.getProductsByConsoleId(consoleId));

        assertEquals("Products not found", exception.getMessage());
        verify(productService, times(1)).getProductsByConsoleId(consoleId);
    }

    @Test
    void testGetProductsByConsoleId_ServiceException() {
        // Arrange
        String consoleId = "123";
        when(productService.getProductsByConsoleId(consoleId)).thenThrow(new RuntimeException("Service error"));

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> productController.getProductsByConsoleId(consoleId));

        assertEquals("Service error", exception.getMessage());
        verify(productService, times(1)).getProductsByConsoleId(consoleId);
    }

    // Controller Unit Tests




        @Test
        void testUpdateProduct_Positive() {
            // Arrange
            String productId = "12345";
            ProductRequestModel productRequestModel = ProductRequestModel.builder()
                    .productName("Updated Name")
                    .productDescription("Updated Description")
                    .productSalePrice(100.00)
                    .productQuantity(10)
                    .build();

            ProductResponseModel expectedResponse = ProductResponseModel.builder()
                    .productId(productId)
                    .productName("Updated Name")
                    .productDescription("Updated Description")
                    .productSalePrice(100.00)
                    .productQuantity(10)
                    .build();

            when(productService.updateProduct(productId, productRequestModel)).thenReturn(expectedResponse);

            // Act
            ResponseEntity<ProductResponseModel> response = productController.updateProduct(productId, productRequestModel);

            // Assert
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(expectedResponse, response.getBody());
            verify(productService, times(1)).updateProduct(productId, productRequestModel);
        }

        @Test
        void testUpdateProduct_Negative_ProductNotFound() {
            // Arrange
            String productId = "12345";
            ProductRequestModel productRequestModel = ProductRequestModel.builder()
                    .productName("Updated Name")
                    .build();

            when(productService.updateProduct(productId, productRequestModel))
                    .thenThrow(new NotFoundException("Product with Id: " + productId + " not found"));

            // Act & Assert
            NotFoundException exception = assertThrows(NotFoundException.class, () -> {
                productController.updateProduct(productId, productRequestModel);
            });

            assertEquals("Product with Id: 12345 not found", exception.getMessage());
            verify(productService, times(1)).updateProduct(productId, productRequestModel);
        }

        @Test
        void testUpdateProduct_Negative_InvalidRequest() {
            // Arrange
            String productId = "12345";
            ProductRequestModel productRequestModel = new ProductRequestModel(); // Invalid request

            when(productService.updateProduct(productId, productRequestModel))
                    .thenThrow(new ConstraintViolationException(null));

            // Act & Assert
            ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> {
                productController.updateProduct(productId, productRequestModel);
            });

            verify(productService, times(1)).updateProduct(productId, productRequestModel);
        }

    @Test
    void GetProductByProductId_ValidId() {
        // Arrange
        String productId = "product123";
        ProductResponseModel productResponse = ProductResponseModel.builder()
                .productId(productId)
                .productName("Test Product")
                .productSalePrice(99.99)
                .productDescription("Test Description")
                .genre("Action")
                .productQuantity(10)
                .build();

        when(productService.getProductByProductId(productId)).thenReturn(productResponse);

        // Act
        ResponseEntity<ProductResponseModel> response = productController.getProductByProductId(productId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Test Product", response.getBody().getProductName());
        verify(productService, times(1)).getProductByProductId(productId);
    }

    @Test
    void GetProductByProductId_NotFound() {
        // Arrange
        String productId = "invalidProduct123";
        when(productService.getProductByProductId(productId)).thenThrow(new NotFoundException("Product with Id: " + productId + " not found"));

        // Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> productController.getProductByProductId(productId));

        assertEquals("Product with Id: invalidProduct123 not found", exception.getMessage());
        verify(productService, times(1)).getProductByProductId(productId);
    }

    @Test
    void GetProductByProductId_RuntimeException() {
        // Arrange
        String productId = "product123";
        when(productService.getProductByProductId(productId)).thenThrow(new RuntimeException("Unexpected error occurred"));

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> productController.getProductByProductId(productId));

        assertEquals("Unexpected error occurred", exception.getMessage());
        verify(productService, times(1)).getProductByProductId(productId);
    }
}




