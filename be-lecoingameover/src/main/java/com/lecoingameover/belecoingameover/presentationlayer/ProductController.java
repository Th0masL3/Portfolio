package com.lecoingameover.belecoingameover.presentationlayer;

import com.lecoingameover.belecoingameover.businesslayer.ProductService;
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

    @GetMapping("/console/{consoleId}")
    public ResponseEntity<List<ProductResponseModel>> getProductsByConsoleId(@PathVariable String consoleId) {
        List<ProductResponseModel> products = productService.getProductsByConsoleId(consoleId);
        return ResponseEntity.ok(products);
    }
    @PostMapping("/console/{consoleId}")
    public ResponseEntity<ProductResponseModel> addProduct(@PathVariable String consoleId,@RequestBody ProductRequestModel productRequestModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProductByConsoleId(consoleId,productRequestModel));

    }

}
