package com.lecoingameover.belecoingameover.businesslayer;


import com.lecoingameover.belecoingameover.DataMapperLayer.ProductRequestMapper;
import com.lecoingameover.belecoingameover.DataMapperLayer.ProductResponseMapper;
import com.lecoingameover.belecoingameover.dataaccess.Product;
import com.lecoingameover.belecoingameover.dataaccess.ProductRepository;
import com.lecoingameover.belecoingameover.presentationlayer.ProductRequestModel;
import com.lecoingameover.belecoingameover.presentationlayer.ProductResponseModel;
import com.lecoingameover.belecoingameover.utils.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductRequestMapper productRequestMapper;

    @Mock
    private ProductResponseMapper productResponseMapper;

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    public ProductServiceImplTest() {
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

        Product productEntity = Product.builder()
                .productId("product123")
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

        when(productRequestMapper.requestModelToEntity(eq(productRequest), any())).thenReturn(productEntity);
        when(productRepository.save(productEntity)).thenReturn(productEntity);
        when(productResponseMapper.entityToResponseModel(productEntity)).thenReturn(productResponse);

        // Act
        ProductResponseModel result = productServiceImpl.addProductByConsoleId(consoleId, productRequest);

        // Assert
        assertEquals(productResponse, result);
        verify(productRequestMapper, times(1)).requestModelToEntity(eq(productRequest), any());
        verify(productRepository, times(1)).save(productEntity);
        verify(productResponseMapper, times(1)).entityToResponseModel(productEntity);
    }

    @Test
    void testGetProductsByConsoleId_Positive() {
        // Arrange
        String consoleId = "123";

        Product product1 = Product.builder()
                .productId("product1234")
                .productName("Sample Product")
                .productSalePrice(111.99)
                .productDescription("Test Description")
                .genre("Racing")
                .productQuantity(20)
                .build();

        Product product2 = Product.builder()
                .productId("product123")
                .productName("Test Product")
                .productSalePrice(99.99)
                .productDescription("Test Description")
                .genre("Action")
                .productQuantity(10)
                .build();

        ProductResponseModel productResponse1 = ProductResponseModel.builder()
                .productId("product1234")
                .productName("Sample Product")
                .productSalePrice(111.99)
                .productDescription("Test Description")
                .genre("Racing")
                .productQuantity(20)
                .build();

        ProductResponseModel productResponse2 = ProductResponseModel.builder()
                .productId("product123")
                .productName("Test Product")
                .productSalePrice(99.99)
                .productDescription("Test Description")
                .genre("Action")
                .productQuantity(10)
                .build();

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        List<ProductResponseModel> responseModels = new ArrayList<>();
        responseModels.add(productResponse1);
        responseModels.add(productResponse2);

        when(productRepository.findByConsole_ConsoleId(consoleId)).thenReturn(products);
        when(productResponseMapper.entityListToResponseModelList(products)).thenReturn(responseModels);

        // Act
        List<ProductResponseModel> result = productServiceImpl.getProductsByConsoleId(consoleId);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Sample Product", result.get(0).getProductName());
        assertEquals("Test Product", result.get(1).getProductName());
        verify(productRepository, times(1)).findByConsole_ConsoleId(consoleId);
        verify(productResponseMapper, times(1)).entityListToResponseModelList(products);
    }

    @Test
    void testGetProductsByConsoleId_EmptyProducts() {
        // Arrange
        String consoleId = "123";
        when(productRepository.findByConsole_ConsoleId(consoleId)).thenReturn(Collections.emptyList());

        // Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> productServiceImpl.getProductsByConsoleId(consoleId));

        assertEquals("Products not found in console with ID 123", exception.getMessage());
        verify(productRepository, times(1)).findByConsole_ConsoleId(consoleId);
        verify(productResponseMapper, never()).entityListToResponseModelList(any());
    }

    @Test
    void testGetProductsByConsoleId_RepositoryException() {
        // Arrange
        String consoleId = "123";
        when(productRepository.findByConsole_ConsoleId(consoleId)).thenThrow(new RuntimeException("Database error"));

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> productServiceImpl.getProductsByConsoleId(consoleId));

        assertEquals("Database error", exception.getMessage());
        verify(productRepository, times(1)).findByConsole_ConsoleId(consoleId);
        verify(productResponseMapper, never()).entityListToResponseModelList(any());
    }

    @Test
    void testGetProductsByConsoleId_MultipleProducts() {
        // Arrange
        String consoleId = "456";

        Product product1 = Product.builder()
                .productId("product1")
                .productName("Product A")
                .productSalePrice(20.00)
                .productDescription("Description A")
                .genre("Genre A")
                .productQuantity(5)
                .build();

        Product product2 = Product.builder()
                .productId("product2")
                .productName("Product B")
                .productSalePrice(30.00)
                .productDescription("Description B")
                .genre("Genre B")
                .productQuantity(10)
                .build();

        Product product3 = Product.builder()
                .productId("product3")
                .productName("Product C")
                .productSalePrice(40.00)
                .productDescription("Description C")
                .genre("Genre C")
                .productQuantity(15)
                .build();

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        ProductResponseModel response1 = ProductResponseModel.builder()
                .productId("product1")
                .productName("Product A")
                .productSalePrice(20.00)
                .productDescription("Description A")
                .genre("Genre A")
                .productQuantity(5)
                .build();

        ProductResponseModel response2 = ProductResponseModel.builder()
                .productId("product2")
                .productName("Product B")
                .productSalePrice(30.00)
                .productDescription("Description B")
                .genre("Genre B")
                .productQuantity(10)
                .build();

        ProductResponseModel response3 = ProductResponseModel.builder()
                .productId("product3")
                .productName("Product C")
                .productSalePrice(40.00)
                .productDescription("Description C")
                .genre("Genre C")
                .productQuantity(15)
                .build();

        List<ProductResponseModel> responseModels = new ArrayList<>();
        responseModels.add(response1);
        responseModels.add(response2);
        responseModels.add(response3);

        when(productRepository.findByConsole_ConsoleId(consoleId)).thenReturn(products);
        when(productResponseMapper.entityListToResponseModelList(products)).thenReturn(responseModels);

        // Act
        List<ProductResponseModel> result = productServiceImpl.getProductsByConsoleId(consoleId);

        // Assert
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("Product A", result.get(0).getProductName());
        assertEquals("Product C", result.get(2).getProductName());
        verify(productRepository, times(1)).findByConsole_ConsoleId(consoleId);
        verify(productResponseMapper, times(1)).entityListToResponseModelList(products);
    }

}