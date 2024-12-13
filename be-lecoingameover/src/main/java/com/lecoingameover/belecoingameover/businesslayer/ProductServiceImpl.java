package com.lecoingameover.belecoingameover.businesslayer;

import com.lecoingameover.belecoingameover.DataMapperLayer.ProductRequestMapper;
import com.lecoingameover.belecoingameover.DataMapperLayer.ProductResponseMapper;
import com.lecoingameover.belecoingameover.dataaccess.Product;
import com.lecoingameover.belecoingameover.dataaccess.ProductIdentifier;
import com.lecoingameover.belecoingameover.dataaccess.ProductRepository;
import com.lecoingameover.belecoingameover.presentationlayer.ProductRequestModel;
import com.lecoingameover.belecoingameover.presentationlayer.ProductResponseModel;
import com.lecoingameover.belecoingameover.utils.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    public ProductRepository productRepository;
    private final ProductResponseMapper productResponseMapper;
    private final ProductRequestMapper productRequestMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductResponseMapper productResponseMapper, ProductRequestMapper productRequestMapper) {

        this.productResponseMapper = productResponseMapper;
        this.productRequestMapper = productRequestMapper;
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseModel getProductByProductId(String productId) {
        Product product = productRepository.findProductByProductId(productId);
        if (product == null) {
            throw new NotFoundException("Product with Id: " + productId + " not found");
        }

        return productResponseMapper.entityToResponseModel(product);
    }

    @Override
    public List<ProductResponseModel> getProductsByConsoleId(String consoleId) {
        List<Product> products = productRepository.findByConsole_ConsoleId(consoleId);
        if(products.isEmpty()) {
            throw new NotFoundException("Products not found in console with ID " + consoleId);
        }
        return productResponseMapper.entityListToResponseModelList(products);
    }

    @Override
    public ProductResponseModel addProductByConsoleId(String consoleId, ProductRequestModel productRequestModel) {
        Product product = productRequestMapper.requestModelToEntity(productRequestModel, new ProductIdentifier());
        Product savedProduct = productRepository.save(product);
        return productResponseMapper.entityToResponseModel(savedProduct);
    }
}
