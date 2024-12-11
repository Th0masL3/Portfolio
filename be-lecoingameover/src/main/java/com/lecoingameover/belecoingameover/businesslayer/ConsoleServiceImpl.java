package com.lecoingameover.belecoingameover.businesslayer;

import com.lecoingameover.belecoingameover.DataMapperLayer.ConsoleRequestMapper;
import com.lecoingameover.belecoingameover.DataMapperLayer.ConsoleResponseMapper;
import com.lecoingameover.belecoingameover.dataaccess.*;
import com.lecoingameover.belecoingameover.presentationlayer.ConsoleRequestModel;
import com.lecoingameover.belecoingameover.presentationlayer.ConsoleResponseModel;
import com.lecoingameover.belecoingameover.utils.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsoleServiceImpl implements ConsoleService {

    public ConsoleRepository consoleRepository;
    private final ConsoleResponseMapper consoleResponseMapper;
    private final ConsoleRequestMapper consoleRequestMapper;


    public ConsoleServiceImpl(ConsoleRepository consoleRepository, ConsoleResponseMapper consoleResponseMapper, ConsoleRequestMapper consoleRequestMapper) {
        this.consoleRepository = consoleRepository;
        this.consoleResponseMapper = consoleResponseMapper;
        this.consoleRequestMapper = consoleRequestMapper;
    }

    @Override
    public List<ConsoleResponseModel> getAllConsoles() {
    List <Console> consoleList = consoleRepository.findAll();


        return consoleResponseMapper.entityListToResponseModelList(consoleList);
    }

    @Override
    public ConsoleResponseModel updateConsole(String consoleId, ConsoleRequestModel consoleRequestModel) {
        // Find the console by its ID or throw NotFoundException if it doesn't exist
        Console existingConsole = consoleRepository.findById(consoleId)
                .orElseThrow(() -> new NotFoundException("Console with ID " + consoleId + " not found"));

        // Update the existing fields with the new values from the request model
        if (consoleRequestModel.getConsoleName() != null) {
            existingConsole.setConsoleName(consoleRequestModel.getConsoleName());
        }
        if (consoleRequestModel.getReleaseDate() != null) {
            existingConsole.setReleaseDate(consoleRequestModel.getReleaseDate());
        }
        if (consoleRequestModel.getPrice() > 0) { // Avoid updating price with invalid value
            existingConsole.setPrice(consoleRequestModel.getPrice());
        }
        if (consoleRequestModel.getQuantityInStock() >= 0) { // Avoid negative stock
            existingConsole.setQuantityInStock(consoleRequestModel.getQuantityInStock());
        }
        if (consoleRequestModel.getCompany() != null) {
            existingConsole.setCompany(consoleRequestModel.getCompany());
        }

        // Save the updated console to the repository
        Console updatedConsole = consoleRepository.save(existingConsole);

        // Map the updated entity to a response model and return it
        return consoleResponseMapper.entityToResponseModel(updatedConsole);
    }


    @Override
    public ConsoleResponseModel getConsoleById(String consoleId) {
        Console console = consoleRepository.findById(consoleId)
                .orElseThrow(() -> new NotFoundException("Console with ID " + consoleId + " not found"));
        return consoleResponseMapper.entityToResponseModel(console);
    }

    @Override
    public ConsoleResponseModel addConsole(ConsoleRequestModel consoleRequestModel) {
        Console console = consoleRequestMapper.requestModelToEntity(consoleRequestModel, new ConsoleIdentifier());
        Console savedConsole = consoleRepository.save(console);
        return consoleResponseMapper.entityToResponseModel(savedConsole);
    }

    public void deleteConsoleByConsoleId(String consoleId) {
       Console console = consoleRepository.findById(consoleId)
               .orElseThrow(() -> new NotFoundException("Console with ID " + consoleId + " not found"));

       consoleRepository.delete(console);
    }
}
