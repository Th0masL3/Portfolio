package com.lecoingameover.belecoingameover.presentationlayer;

import com.lecoingameover.belecoingameover.dataaccess.Console;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestModel {
    private String productName;
    private double productSalePrice;
    private String productDescription;
    private String genre;
    private int productQuantity;
    private Console console;
}
