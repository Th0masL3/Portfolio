package com.lecoingameover.belecoingameover.DataMapperLayer;

import com.lecoingameover.belecoingameover.dataaccess.Console;
import com.lecoingameover.belecoingameover.presentationlayer.ConsoleResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConsoleResponseMapper {
    @Mapping(expression= "java(console.getConsoleIdentifier().getConsoleId())", target = "consoleId")
    List<ConsoleResponseModel> entityListToResponseModelList(List<Console> consoleList);
}
