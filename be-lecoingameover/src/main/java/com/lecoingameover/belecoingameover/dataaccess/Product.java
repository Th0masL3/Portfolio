package com.lecoingameover.belecoingameover.dataaccess;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Document(collection = "products")
public class Product {
    @Id
    private String productId;

    @Indexed(unique = true)
    private String productName;
    private double productSalePrice;
    private String productDescription;
    private String genre;
    private int productQuantity;
    private Console console;
    private String image;

    @Field("hot")
    private boolean isHot = false;
}
