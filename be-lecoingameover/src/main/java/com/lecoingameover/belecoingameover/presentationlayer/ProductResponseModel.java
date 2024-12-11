package com.lecoingameover.belecoingameover.presentationlayer;

import com.lecoingameover.belecoingameover.dataaccess.Console;
import lombok.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Builder
@AllArgsConstructor
@Getter
@Setter
public class ProductResponseModel {
    private String productId;
    private String productName;
    private double productSalePrice;
    private String productDescription;
    private String genre;
    private int productQuantity;
    private Console console;
}
