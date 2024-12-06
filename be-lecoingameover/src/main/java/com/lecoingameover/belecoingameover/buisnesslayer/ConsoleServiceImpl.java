package com.lecoingameover.belecoingameover.buisnesslayer;

import com.lecoingameover.belecoingameover.DataMapperLayer.ConsoleResponseMapper;
import com.lecoingameover.belecoingameover.dataaccess.Console;
import com.lecoingameover.belecoingameover.dataaccess.ConsoleRepository;
import com.lecoingameover.belecoingameover.presentationlayer.ConsoleResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsoleServiceImpl implements ConsoleService {

public ConsoleRepository consoleRepository;
private final ConsoleResponseMapper consoleResponseMapper;

    public ConsoleServiceImpl(ConsoleRepository consoleRepository, ConsoleResponseMapper consoleResponseMapper) {
        this.consoleRepository = consoleRepository;
        this.consoleResponseMapper = consoleResponseMapper;
    }

    @Override
    public List<ConsoleResponseModel> getAllConsoles() {
    List <Console> consoleList = consoleRepository.findAll();


        return consoleResponseMapper.entityListToResponseModelList(consoleList);
    }
}
