package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.example.core.dao.api")
public class CurrencyApplication {
    public static void main(String[] args) {
        SpringApplication.run(CurrencyApplication.class, args);
    }
}
