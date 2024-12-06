package com.lecoingameover.belecoingameover.presentationlayer;

import static org.junit.jupiter.api.Assertions.*;


import com.lecoingameover.belecoingameover.buisnesslayer.ConsoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ConsoleControllerTest {

    private ConsoleService consoleService;
    private ConsoleController consoleController;

    @BeforeEach
    void setUp() {
        consoleService = mock(ConsoleService.class);
        consoleController = new ConsoleController(consoleService);
    }

    @Test
    void WhenGetAllConsoles_thenReturnAllConsoleResponseModels() {
        // Arrange
        List<ConsoleResponseModel> expectedConsoles = Arrays.asList(
                ConsoleResponseModel.builder()
                        .consoleId("1")
                        .consoleName("PlayStation 5")
                        .releaseDate(LocalDate.of(2020, 11, 12))
                        .price(499.99)
                        .quantityInStock(100)
                        .company("Sony")
                        .build(),
                ConsoleResponseModel.builder()
                        .consoleId("2")
                        .consoleName("Xbox Series X")
                        .releaseDate(LocalDate.of(2020, 11, 10))
                        .price(499.99)
                        .quantityInStock(150)
                        .company("Microsoft")
                        .build()
        );

        when(consoleService.getAllConsoles()).thenReturn(expectedConsoles);

        // Act
        ResponseEntity<List<ConsoleResponseModel>> response = consoleController.getAllConsoles();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedConsoles, response.getBody());
    }
}
