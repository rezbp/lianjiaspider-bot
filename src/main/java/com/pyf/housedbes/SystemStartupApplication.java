package com.pyf.housedbes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author ADMIN
 */
@SpringBootApplication
@EnableJpaRepositories
public class SystemStartupApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SystemStartupApplication.class);
        app.run(args);
    }
}
