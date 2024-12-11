package com.lecoingameover.belecoingameover.dataaccess;

import lombok.Getter;
import java.util.UUID;

@Getter
public class ProductIdentifier
{
    private final String productId;
    public ProductIdentifier(){ this.productId = UUID.randomUUID().toString();
    }
}
