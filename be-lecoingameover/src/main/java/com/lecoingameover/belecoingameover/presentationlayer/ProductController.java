package com.lecoingameover.belecoingameover.presentationlayer;

import com.lecoingameover.belecoingameover.businesslayer.ProductService;
import com.lecoingameover.belecoingameover.dataaccess.Product;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService) {this.productService = productService;}

    @GetMapping
    public ResponseEntity<List<ProductResponseModel>> getAllProducts() {
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseModel> getProductByProductId(@PathVariable("productId") String productId) {
        ProductResponseModel product = productService.getProductByProductId(productId);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping("/console/{consoleId}")
    public ResponseEntity<List<ProductResponseModel>> getProductsByConsoleId(@PathVariable String consoleId) {
        List<ProductResponseModel> products = productService.getProductsByConsoleId(consoleId);
        return ResponseEntity.ok(products);
    }
    @PostMapping("/console/{consoleId}")
    public ResponseEntity<ProductResponseModel> addProduct(@PathVariable String consoleId,@RequestBody ProductRequestModel productRequestModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProductByConsoleId(consoleId,productRequestModel));

    }
    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponseModel> updateProduct(
            @PathVariable String productId,
            @Valid @RequestBody ProductRequestModel productRequestModel) {
        return ResponseEntity.ok(productService.updateProduct(productId, productRequestModel));
    }
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProductById(@PathVariable String productId) {
        productService.deleteProductByProductId(productId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{productId}/hot")
    public ResponseEntity<ProductResponseModel> setHotProduct(@PathVariable String productId) {
        productService.setHotProduct(productId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/hot")
    public ResponseEntity<List<ProductResponseModel>> getHotProducts() {
        return ResponseEntity.ok(productService.getHotProducts());
    }

}
