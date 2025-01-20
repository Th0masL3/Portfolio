package com.lecoingameover.belecoingameover.businesslayer;

import com.lecoingameover.belecoingameover.DataMapperLayer.ProductRequestMapper;
import com.lecoingameover.belecoingameover.DataMapperLayer.ProductResponseMapper;
import com.lecoingameover.belecoingameover.dataaccess.Console;
import com.lecoingameover.belecoingameover.dataaccess.Product;
import com.lecoingameover.belecoingameover.dataaccess.ProductIdentifier;
import com.lecoingameover.belecoingameover.dataaccess.ProductRepository;
import com.lecoingameover.belecoingameover.presentationlayer.ConsoleResponseModel;
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
    public List<ProductResponseModel> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new NotFoundException("No products found");
        }
        return productResponseMapper.entityListToResponseModelList(products);
    }

    @Override
    public ProductResponseModel getProductByProductId(String productId) {
        Product product = productRepository.findProductByProductId(productId);
        if (product == null) {
            throw new NotFoundException("Product with Id: " + productId +" not found");
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

    @Override
    public ProductResponseModel updateProduct(String productId, ProductRequestModel productRequestModel) {
        // Find the console by its ID or throw NotFoundException if it doesn't exist
        Product existingProduct = productRepository.findProductByProductId(productId);

        if (existingProduct == null) {
            throw new NotFoundException("Product with Id: " + productId + " not found");
        }

        // Update the existing fields with the new values from the request model
        if (productRequestModel.getProductName() != null) {
            existingProduct.setProductName(productRequestModel.getProductName());
        }
        if (productRequestModel.getProductDescription() != null) {
            existingProduct.setProductDescription(productRequestModel.getProductDescription());
        }
        if (productRequestModel.getProductSalePrice() > 0) { // Avoid updating price with invalid value
            existingProduct.setProductSalePrice(productRequestModel.getProductSalePrice());
        }
        if (productRequestModel.getProductQuantity() >= 0) { // Avoid negative stock
            existingProduct.setProductQuantity(productRequestModel.getProductQuantity());
        }
        if (productRequestModel.getConsole() != null) { // Avoid negative stock
            existingProduct.setConsole(productRequestModel.getConsole());
        }


        // Save the updated console to the repository
        Product updatedProduct = productRepository.save(existingProduct);

        // Map the updated entity to a response model and return it
        return productResponseMapper.entityToResponseModel(updatedProduct);
    }

    @Override
    public void deleteProductByProductId(String productId) {
        Product product = productRepository.findProductByProductId(productId);
        if (product == null) {
            throw new NotFoundException("Product with ID " + productId + " not found");
        }
        productRepository.delete(product);
    }

    @Override
    public ProductResponseModel setHotProduct(String productId) {
        Product product = productRepository.findProductByProductId(productId);
        if (product == null) {
            throw new NotFoundException("Product with ID " + productId + " not found");
        }
        product.setHot(!product.isHot());
        Product updatedProduct = productRepository.save(product);
        return productResponseMapper.entityToResponseModel(updatedProduct);
    }

    @Override
    public List<ProductResponseModel> getHotProducts() {
        List<Product> products = productRepository.findByIsHotTrue();
        if (products.isEmpty()) {
            throw new NotFoundException("No hot products found");
        }
        return productResponseMapper.entityListToResponseModelList(products);
    }
}
