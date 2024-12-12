package com.lecoingameover.belecoingameover.DataMapperLayer;

import com.lecoingameover.belecoingameover.dataaccess.Product;
import com.lecoingameover.belecoingameover.dataaccess.ProductIdentifier;
import com.lecoingameover.belecoingameover.presentationlayer.ProductRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper {
    @Mappings({
            @Mapping(target = "productId", ignore = true),
            
            @Mapping(target = "console.consoleId", source = "productRequestModel.console.consoleId")
    })
    Product requestModelToEntity(ProductRequestModel productRequestModel, ProductIdentifier productIdentifier);
}
