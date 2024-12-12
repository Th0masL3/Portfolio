//package com.lecoingameover.belecoingameover.presentationlayer;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import com.lecoingameover.belecoingameover.dataaccess.Console;
//import com.lecoingameover.belecoingameover.dataaccess.ProductRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("test")
//class ProductControllerIntegrationTest {
//
//    @LocalServerPort
//    private int port = 8080;
//
//    private WebClient webClient;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @BeforeEach
//    void setUp() {
//        webClient = WebClient.builder()
//                .baseUrl("http://localhost:" + port + "/api/v1/products")
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//        productRepository.deleteAll();
//    }
//
//    @Test
//    void testAddProductByConsoleId() {
//        // Arrange
//        String consoleId = "console123";
//
//        Console consoletest = Console.builder().consoleName("Cname")
//                .consoleId(consoleId).company("ni").price(19.99).quantityInStock(1).releaseDate(LocalDate.MAX)
//                .build();
//
//        ProductRequestModel productRequest = ProductRequestModel.builder()
//                .productName("Test Product")
//                .productSalePrice(99.99)
//                .productDescription("Test Description")
//                .genre("Action")
//                .console(consoletest)
//                .productQuantity(10)
//                .build();
//
//        // Act
//        ProductResponseModel response = webClient.post()
//                .uri("/console/{consoleId}", consoleId)
//                .bodyValue(productRequest)
//                .retrieve()
//                .bodyToMono(ProductResponseModel.class)
//                .block();
//
//        // Assert
//        assertNotNull(response);
//        assertEquals("Test Product", response.getProductName());
//        assertEquals(99.99, response.getProductSalePrice());
//        assertEquals("Action", response.getGenre());
//        assertEquals(10, response.getProductQuantity());
//    }
//}