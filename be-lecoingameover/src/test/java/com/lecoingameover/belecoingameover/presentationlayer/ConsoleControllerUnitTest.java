package com.lecoingameover.belecoingameover.presentationlayer;

import static org.junit.jupiter.api.Assertions.*;


import com.lecoingameover.belecoingameover.buisnesslayer.ConsoleService;
import com.lecoingameover.belecoingameover.utils.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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

    @Test
    void testUpdateConsole_ValidRequest_ReturnsUpdatedConsole() {
        // Arrange
        String consoleId = "1";
        ConsoleRequestModel requestModel = ConsoleRequestModel.builder()
                .consoleName("Updated PlayStation 5")
                .releaseDate(LocalDate.of(2020, 11, 12))
                .price(499.99)
                .quantityInStock(120)
                .company("Sony")
                .build();

        ConsoleResponseModel updatedConsole = ConsoleResponseModel.builder()
                .consoleId(consoleId)
                .consoleName("Updated PlayStation 5")
                .releaseDate(LocalDate.of(2020, 11, 12))
                .price(499.99)
                .quantityInStock(120)
                .company("Sony")
                .build();

        when(consoleService.updateConsole(consoleId, requestModel)).thenReturn(updatedConsole);

        // Act
        ResponseEntity<ConsoleResponseModel> response = consoleController.updateConsole(consoleId, requestModel);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(updatedConsole, response.getBody());
        verify(consoleService, times(1)).updateConsole(consoleId, requestModel);
    }

    @Test
    void testUpdateConsole_ConsoleNotFound_ThrowsNotFoundException() {
        // Arrange
        String consoleId = "1";
        ConsoleRequestModel requestModel = ConsoleRequestModel.builder()
                .consoleName("Updated Console")
                .releaseDate(LocalDate.of(2020, 11, 12))
                .price(499.99)
                .quantityInStock(100)
                .company("Sony")
                .build();

        when(consoleService.updateConsole(consoleId, requestModel))
                .thenThrow(new NotFoundException("Console with ID " + consoleId + " not found"));

        // Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> consoleController.updateConsole(consoleId, requestModel));
        assertEquals("Console with ID 1 not found", exception.getMessage());
        verify(consoleService, times(1)).updateConsole(consoleId, requestModel);
    }

    @Test
    void testGetConsoleById_ValidId_ReturnsConsole() {
        // Arrange
        String consoleId = "1";
        ConsoleResponseModel expectedConsole = ConsoleResponseModel.builder()
                .consoleId(consoleId)
                .consoleName("PlayStation 5")
                .releaseDate(LocalDate.of(2020, 11, 12))
                .price(499.99)
                .quantityInStock(100)
                .company("Sony")
                .build();

        when(consoleService.getConsoleById(consoleId)).thenReturn(expectedConsole);

        // Act
        ResponseEntity<ConsoleResponseModel> response = consoleController.getConsoleById(consoleId);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedConsole, response.getBody());
        verify(consoleService, times(1)).getConsoleById(consoleId);
    }

    @Test
    void testGetConsoleById_ConsoleNotFound_ThrowsNotFoundException() {
        // Arrange
        String consoleId = "1";
        when(consoleService.getConsoleById(consoleId))
                .thenThrow(new NotFoundException("Console with ID " + consoleId + " not found"));

        // Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> consoleController.getConsoleById(consoleId));
        assertEquals("Console with ID 1 not found", exception.getMessage());
        verify(consoleService, times(1)).getConsoleById(consoleId);
    }

    @Test
    void testAddConsole_ValidRequest_ReturnsAddedConsole() {
        // Arrange
        ConsoleRequestModel requestModel = ConsoleRequestModel.builder()
                .consoleName("PlayStation 5")
                .releaseDate(LocalDate.of(2020, 11, 12))
                .price(499.99)
                .quantityInStock(100)
                .company("Sony")
                .build();

        ConsoleResponseModel addedConsole = ConsoleResponseModel.builder()
                .consoleId("1")
                .consoleName("PlayStation 5")
                .releaseDate(LocalDate.of(2020, 11, 12))
                .price(499.99)
                .quantityInStock(100)
                .company("Sony")
                .build();

        when(consoleService.addConsole(requestModel)).thenReturn(addedConsole);

        // Act
        ResponseEntity<ConsoleResponseModel> response = consoleController.addConsole(requestModel);

        // Assert
        assertEquals(201, response.getStatusCodeValue());
        assertEquals(addedConsole, response.getBody());
        verify(consoleService, times(1)).addConsole(requestModel);
    }
  
    @Test
    void testDeleteConsoleById_ValidId_ReturnsNoContent() {
        // Arrange
        String consoleId = "1";

        // Mock the service method to do nothing
        doNothing().when(consoleService).deleteConsoleByConsoleId(consoleId);

        // Act
        ResponseEntity<Void> response = consoleController.deleteConsoleById(consoleId);

        // Assert
        assertEquals(204, response.getStatusCodeValue());
        verify(consoleService, times(1)).deleteConsoleByConsoleId(consoleId);
    }

    @Test
    void testDeleteConsoleById_ConsoleNotFound_ThrowsNotFoundException() {
        // Arrange
        String consoleId = "1";

        // Mock the service method to throw NotFoundException
        doThrow(new NotFoundException("Console with ID " + consoleId + " not found"))
                .when(consoleService).deleteConsoleByConsoleId(consoleId);

        // Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> consoleController.deleteConsoleById(consoleId));
        assertEquals("Console with ID 1 not found", exception.getMessage());
        verify(consoleService, times(1)).deleteConsoleByConsoleId(consoleId);
    }
    

    @Test
    void testDeleteConsoleById_ServiceThrowsRuntimeException() {
        // Arrange
        String consoleId = "1";

        // Mock service to throw a runtime exception
        doThrow(new RuntimeException("Unexpected error")).when(consoleService).deleteConsoleByConsoleId(consoleId);

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> consoleController.deleteConsoleById(consoleId));
        assertEquals("Unexpected error", exception.getMessage());
        verify(consoleService, times(1)).deleteConsoleByConsoleId(consoleId);
    }


}


