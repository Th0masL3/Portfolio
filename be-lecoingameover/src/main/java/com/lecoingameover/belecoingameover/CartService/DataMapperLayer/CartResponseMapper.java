package com.lecoingameover.belecoingameover.CartService.DataMapperLayer;

import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.Cart;
import com.lecoingameover.belecoingameover.CartService.PresentationLayer.CartResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartResponseMapper {
    @Mapping(source = "cartId", target = "cartId")
    CartResponseModel entityToResponseModel(Cart cart);
}
