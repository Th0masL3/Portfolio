package com.lecoingameover.belecoingameover.DataMapperLayer;

import com.lecoingameover.belecoingameover.dataaccess.Console;
import com.lecoingameover.belecoingameover.dataaccess.ConsoleIdentifier;
import com.lecoingameover.belecoingameover.presentationlayer.ConsoleRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ConsoleRequestMapper {
    @Mappings({
            @Mapping(target = "consoleId", ignore = true),
    })
    Console requestModelToEntity(ConsoleRequestModel consoleRequestModel, ConsoleIdentifier consoleIdentifier);
}
