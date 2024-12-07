package com.lecoingameover.belecoingameover.dataaccess;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsoleRepository extends MongoRepository<Console, String> {
    List<Console> findAllByConsoleIdentifier_ConsoleId(String consoleId);
    Optional<Console> findByConsoleId(String consoleId);

}