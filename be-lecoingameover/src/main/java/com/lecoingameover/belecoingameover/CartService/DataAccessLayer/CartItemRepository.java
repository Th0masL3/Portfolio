package com.lecoingameover.belecoingameover.CartService.DataAccessLayer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository  extends MongoRepository<CartItem, String> {
    CartItem findCartItemByCartItemId(String cartItemId);
}
