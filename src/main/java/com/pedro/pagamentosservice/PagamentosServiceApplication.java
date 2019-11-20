package com.pedro.pagamentosservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient    // Enable eureka client. It inherits from @EnableDiscoveryClient.n
public class PagamentosServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PagamentosServiceApplication.class, args);
    }

}
