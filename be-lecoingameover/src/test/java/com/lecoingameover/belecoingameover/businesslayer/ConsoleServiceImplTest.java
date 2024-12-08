package com.lecoingameover.belecoingameover.businesslayer;


import com.lecoingameover.belecoingameover.DataMapperLayer.ConsoleRequestMapper;
import com.lecoingameover.belecoingameover.DataMapperLayer.ConsoleResponseMapper;
import com.lecoingameover.belecoingameover.buisnesslayer.ConsoleServiceImpl;
import com.lecoingameover.belecoingameover.dataaccess.Console;
import com.lecoingameover.belecoingameover.dataaccess.ConsoleIdentifier;
import com.lecoingameover.belecoingameover.dataaccess.ConsoleRepository;
import com.lecoingameover.belecoingameover.presentationlayer.ConsoleRequestModel;
import com.lecoingameover.belecoingameover.presentationlayer.ConsoleResponseModel;
import com.lecoingameover.belecoingameover.utils.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ConsoleServiceImplTest {

    @Mock
    private ConsoleRepository consoleRepository;

    @Mock
    private ConsoleResponseMapper consoleResponseMapper;

    @Mock
    private ConsoleRequestMapper consoleRequestMapper;

    @InjectMocks
    private ConsoleServiceImpl consoleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUpdateConsole() {
        // Arrange
        String consoleId = "123";
        Console existingConsole = new Console();
        existingConsole.setConsoleName("Old Name");
        existingConsole.setPrice(100);

        when(consoleRepository.findById(consoleId)).thenReturn(Optional.of(existingConsole));

        ConsoleRequestModel requestModel = ConsoleRequestModel.builder()
                .consoleName("New Name")
                .price(200)
                .build();

        Console updatedConsole = new Console();
        updatedConsole.setConsoleName("New Name");
        updatedConsole.setPrice(200);
        when(consoleRepository.save(existingConsole)).thenReturn(updatedConsole);

        ConsoleResponseModel responseModel = new ConsoleResponseModel();
        responseModel.setConsoleName("New Name");
        responseModel.setPrice(200);
        when(consoleResponseMapper.entityToResponseModel(updatedConsole)).thenReturn(responseModel);

        // Act
        ConsoleResponseModel result = consoleService.updateConsole(consoleId, requestModel);

        // Assert
        assertNotNull(result);
        assertEquals("New Name", result.getConsoleName());
        assertEquals(200, result.getPrice());
        verify(consoleRepository, times(1)).findById(consoleId);
        verify(consoleRepository, times(1)).save(existingConsole);
        verify(consoleResponseMapper, times(1)).entityToResponseModel(updatedConsole);
    }

    @Test
    void testUpdateConsole_NotFound() {
        // Arrange
        String consoleId = "123";
        when(consoleRepository.findById(consoleId)).thenReturn(Optional.empty());

        ConsoleRequestModel requestModel = ConsoleRequestModel.builder()
                .consoleName("New Name")
                .price(200)
                .build();

        // Act & Assert
        assertThrows(NotFoundException.class, () -> consoleService.updateConsole(consoleId, requestModel));
        verify(consoleRepository, times(1)).findById(consoleId);
        verify(consoleRepository, never()).save(any());
    }

    @Test
    void testGetConsoleById() {
        // Arrange
        String consoleId = "123";
        Console console = new Console();
        console.setConsoleName("Test Console");
        when(consoleRepository.findById(consoleId)).thenReturn(Optional.of(console));

        ConsoleResponseModel responseModel = new ConsoleResponseModel();
        responseModel.setConsoleName("Test Console");
        when(consoleResponseMapper.entityToResponseModel(console)).thenReturn(responseModel);

        // Act
        ConsoleResponseModel result = consoleService.getConsoleById(consoleId);

        // Assert
        assertNotNull(result);
        assertEquals("Test Console", result.getConsoleName());
        verify(consoleRepository, times(1)).findById(consoleId);
        verify(consoleResponseMapper, times(1)).entityToResponseModel(console);
    }

    @Test
    void testGetConsoleById_NotFound() {
        // Arrange
        String consoleId = "123";
        when(consoleRepository.findById(consoleId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> consoleService.getConsoleById(consoleId));
        verify(consoleRepository, times(1)).findById(consoleId);
    }

}
