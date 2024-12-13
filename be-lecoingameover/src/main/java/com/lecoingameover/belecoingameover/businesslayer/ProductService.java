package com.lecoingameover.belecoingameover.businesslayer;

import com.lecoingameover.belecoingameover.presentationlayer.ConsoleRequestModel;
import com.lecoingameover.belecoingameover.presentationlayer.ConsoleResponseModel;
import com.lecoingameover.belecoingameover.presentationlayer.ProductRequestModel;
import com.lecoingameover.belecoingameover.presentationlayer.ProductResponseModel;

import java.util.List;

public interface ProductService {

    ProductResponseModel getProductByProductId(String productId);
    List<ProductResponseModel> getProductsByConsoleId(String consoleId);
    ProductResponseModel addProductByConsoleId(String consoleId, ProductRequestModel productRequestModel);
    ProductResponseModel updateProduct(String productId, ProductRequestModel productRequestModel );

}
