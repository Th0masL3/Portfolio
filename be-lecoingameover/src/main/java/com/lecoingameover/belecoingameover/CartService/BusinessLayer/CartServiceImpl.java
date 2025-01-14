package com.lecoingameover.belecoingameover.CartService.BusinessLayer;

import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.Cart;
import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.CartItem;
import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.CartRepository;
import com.lecoingameover.belecoingameover.CartService.DataMapperLayer.CartRequestMapper;
import com.lecoingameover.belecoingameover.CartService.DataMapperLayer.CartResponseMapper;
import com.lecoingameover.belecoingameover.CartService.PresentationLayer.CartRequestModel;
import com.lecoingameover.belecoingameover.CartService.PresentationLayer.CartResponseModel;
import com.lecoingameover.belecoingameover.dataaccess.Console;
import com.lecoingameover.belecoingameover.utils.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    public CartRepository cartRepository;
    public final CartRequestMapper cartRequestMapper;
    public final CartResponseMapper cartResponseMapper;

    public CartServiceImpl(CartRepository cartRepository, CartRequestMapper cartRequestMapper, CartResponseMapper cartResponseMapper) {
        this.cartRepository = cartRepository;
        this.cartRequestMapper = cartRequestMapper;
        this.cartResponseMapper = cartResponseMapper;
    }


    @Override
    public CartResponseModel getCartById(String cartId) {
        Cart cart = cartRepository.findCartByCartId(cartId);
        if (cart == null) {
            throw new NotFoundException("cart not found");
        }
        if (cart.getItems().isEmpty()) {
            throw new NotFoundException("cart is empty");
        }

        cart.setTotal(cart.getItems().stream().mapToDouble(CartItem::getPrice).sum());
        return cartResponseMapper.entityToResponseModel(cart);
    }


}
