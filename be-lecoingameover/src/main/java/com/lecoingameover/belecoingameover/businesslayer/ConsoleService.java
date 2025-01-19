package com.lecoingameover.belecoingameover.businesslayer;

import com.lecoingameover.belecoingameover.presentationlayer.ConsoleRequestModel;
import com.lecoingameover.belecoingameover.presentationlayer.ConsoleResponseModel;

import java.util.List;

public interface ConsoleService {
    List<ConsoleResponseModel> getAllConsoles();
    ConsoleResponseModel updateConsole(String consoleId, ConsoleRequestModel consoleRequestModel);
    ConsoleResponseModel getConsoleById(String consoleId);
    ConsoleResponseModel addConsole(ConsoleRequestModel consoleRequestModel);
    void deleteConsoleByConsoleId(String consoleId);
//    ConsoleResponseModel setHotConsole(String productId, boolean isHot);
//    List<ConsoleResponseModel> getHotConsoles();
}