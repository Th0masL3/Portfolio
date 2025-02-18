package com.lecoingameover.belecoingameover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class BeLecoingameoverApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        String mongoUri = dotenv.get("MONGO_URI");

        if (mongoUri != null) {
            System.setProperty("MONGO_URI", mongoUri);
        } else {
            System.err.println("❌ MONGO_URI is missing from .env file!");
        }

        SpringApplication.run(BeLecoingameoverApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
