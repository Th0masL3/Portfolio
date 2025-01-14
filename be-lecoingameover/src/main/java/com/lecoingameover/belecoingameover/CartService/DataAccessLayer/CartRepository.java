package com.lecoingameover.belecoingameover.CartService.DataAccessLayer;

import com.lecoingameover.belecoingameover.dataaccess.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    Cart findCartByCartId(String cartId);


}
