package com.lecoingameover.belecoingameover.CartService.BusinessLayer;

import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.Cart;
import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.CartItem;
import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.CartRepository;
import com.lecoingameover.belecoingameover.CartService.DataMapperLayer.CartRequestMapper;
import com.lecoingameover.belecoingameover.CartService.DataMapperLayer.CartResponseMapper;
import com.lecoingameover.belecoingameover.CartService.PresentationLayer.CartRequestModel;
import com.lecoingameover.belecoingameover.CartService.PresentationLayer.CartResponseModel;
import com.lecoingameover.belecoingameover.dataaccess.Console;
import com.lecoingameover.belecoingameover.dataaccess.ConsoleRepository;
import com.lecoingameover.belecoingameover.dataaccess.Product;
import com.lecoingameover.belecoingameover.dataaccess.ProductRepository;
import com.lecoingameover.belecoingameover.presentationlayer.ConsoleResponseModel;
import com.lecoingameover.belecoingameover.presentationlayer.ProductRequestModel;
import com.lecoingameover.belecoingameover.utils.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    public CartRepository cartRepository;
    public final CartRequestMapper cartRequestMapper;
    public final CartResponseMapper cartResponseMapper;
    public ProductRepository productRepository;
    public ConsoleRepository consoleRepository;

    public CartServiceImpl(CartRepository cartRepository, CartRequestMapper cartRequestMapper, CartResponseMapper cartResponseMapper,ConsoleRepository consoleRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.cartRequestMapper = cartRequestMapper;
        this.cartResponseMapper = cartResponseMapper;
        this.consoleRepository = consoleRepository;
        this.productRepository = productRepository;
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

    @Override
    public CartResponseModel addProductToCartItem(ProductRequestModel productRequestModel, String productId) {
        Cart onlyCart =cartRepository.findCartByCartId("1");
        Product product =productRepository.findProductByProductId(productId);
        CartItem cartItem = new CartItem();
        cartItem.setCartItemId(product.getProductId());
        cartItem.setName(product.getProductName());
        cartItem.setPrice(product.getProductSalePrice());
        cartItem.setDescription(product.getProductDescription());
        onlyCart.getItems().add(cartItem);
        onlyCart.setTotal(onlyCart.getItems().stream().mapToDouble(CartItem::getPrice).sum());
        cartRepository.save(onlyCart);
        return cartResponseMapper.entityToResponseModel(onlyCart);
    }

    @Override
    public CartResponseModel addConsoleToCartItem(String consoleId, CartRequestModel cartRequestModel) {
        return null;
    }


}
