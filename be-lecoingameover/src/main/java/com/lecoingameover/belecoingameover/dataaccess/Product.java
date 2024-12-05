package com.lecoingameover.belecoingameover.dataaccess;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String productId;
    private String productName;
    private double productSalePrice;
    private int productQuantity;
    private Console console;
}
