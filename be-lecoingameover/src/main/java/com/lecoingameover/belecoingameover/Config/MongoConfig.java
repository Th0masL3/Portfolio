package com.lecoingameover.belecoingameover.Config;

import io.github.cdimascio.dotenv.Dotenv;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {
    @Bean
    public MongoClient mongoClient() {
        Dotenv dotenv = Dotenv.load();
        String mongoUri = dotenv.get("MONGO_URI");
        return MongoClients.create(mongoUri);
    }
}
