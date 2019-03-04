package com.czxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShopWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopWebServiceApplication.class, args);
    }

}
