package com.pyf.house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

/**
 * @author ADMIN
 */
@EnableFeignClients(basePackages = "com.pyf.house")
@EnableDiscoveryClient
@SpringBootApplication
@EnableJpaRepositories
public class HouseApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(HouseApplication.class);
        app.run(args);
    }
}
