package com.lecoingameover.belecoingameover.CartService.BusinessLayer;

import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.Cart;
import com.lecoingameover.belecoingameover.CartService.DataAccessLayer.CartItem;
import com.lecoingameover.belecoingameover.CartService.PresentationLayer.CartRequestModel;
import com.lecoingameover.belecoingameover.CartService.PresentationLayer.CartResponseModel;
import com.lecoingameover.belecoingameover.dataaccess.Product;
import com.lecoingameover.belecoingameover.presentationlayer.ConsoleRequestModel;
import com.lecoingameover.belecoingameover.presentationlayer.ConsoleResponseModel;
import com.lecoingameover.belecoingameover.presentationlayer.ProductRequestModel;

public interface CartService {
    CartResponseModel getCartById(String cartId);
    CartResponseModel addProductToCartItem(ProductRequestModel productRequestModel, String productId);
    CartResponseModel addConsoleToCartItem(ConsoleRequestModel consoleRequestModel, String consoleId);
}
