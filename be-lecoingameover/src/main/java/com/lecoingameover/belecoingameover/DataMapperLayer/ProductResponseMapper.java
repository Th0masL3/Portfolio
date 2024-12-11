package com.lecoingameover.belecoingameover.DataMapperLayer;

import com.lecoingameover.belecoingameover.dataaccess.Product;
import com.lecoingameover.belecoingameover.presentationlayer.ProductResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductResponseMapper {
    @Mapping(source = "console.consoleId", target = "console.consoleId")
    ProductResponseModel entityToResponseModel(Product product);

    List<ProductResponseModel> entityListToResponseModelList(List<Product> productList);
}
