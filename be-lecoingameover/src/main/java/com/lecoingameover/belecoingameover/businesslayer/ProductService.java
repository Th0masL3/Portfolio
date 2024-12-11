package com.lecoingameover.belecoingameover.businesslayer;

import com.lecoingameover.belecoingameover.presentationlayer.ProductResponseModel;

import java.util.List;

public interface ProductService {
    List<ProductResponseModel> getProductsByConsoleId(String consoleId);
}
