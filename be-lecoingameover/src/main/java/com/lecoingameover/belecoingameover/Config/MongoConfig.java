package com.lecoingameover.belecoingameover.Config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {
    @Bean
    public MongoClient mongoClient() {
        String mongoUri = System.getenv("MONGO_URI");

        if (mongoUri == null || mongoUri.isEmpty()) {
            throw new IllegalStateException("❌ MONGO_URI is missing! Make sure it's set in Render.");
        }

        return MongoClients.create(mongoUri);
    }
}
