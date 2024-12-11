package com.lecoingameover.belecoingameover.dataaccess;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    // Use dot notation to query nested fields
    List<Product> findByConsole_ConsoleId(String consoleId);
}