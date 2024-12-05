package com.example.gameoverstore.backend.Products.dataacesslayer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ConsoleRepository extends MongoRepository<Console, String> {
    List<Console> getConsoleByConsoleId(String consoleId);
}
