package com.lecoingameover.belecoingameover.businesslayer;


import com.lecoingameover.belecoingameover.DataMapperLayer.ProductRequestMapper;
import com.lecoingameover.belecoingameover.DataMapperLayer.ProductResponseMapper;
import com.lecoingameover.belecoingameover.dataaccess.Product;
import com.lecoingameover.belecoingameover.dataaccess.ProductRepository;
import com.lecoingameover.belecoingameover.presentationlayer.ProductRequestModel;
import com.lecoingameover.belecoingameover.presentationlayer.ProductResponseModel;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
}