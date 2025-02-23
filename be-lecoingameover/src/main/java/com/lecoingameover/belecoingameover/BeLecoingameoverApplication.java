package com.lecoingameover.belecoingameover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class BeLecoingameoverApplication {
    public static void main(String[] args) {
        SpringApplication.run(BeLecoingameoverApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
