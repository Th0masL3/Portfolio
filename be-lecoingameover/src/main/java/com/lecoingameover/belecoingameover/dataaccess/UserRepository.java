package com.lecoingameover.belecoingameover.dataaccess;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Long> {
    Optional<User> findByUserId(String userId);
}
