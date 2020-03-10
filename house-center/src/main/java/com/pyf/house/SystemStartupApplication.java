package com.pyf.house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author ADMIN
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableJpaRepositories
public class SystemStartupApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SystemStartupApplication.class);
        app.run(args);
    }
}
