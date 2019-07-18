package com.xxx.mall.route_center;

import com.xxx.mall.filter.CheckFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.xxx.mall")
@EnableEurekaClient
@SpringBootApplication
public class RouteCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RouteCenterApplication.class, args);
    }

    @Bean
    public CheckFilter checkFilter() {
        return new CheckFilter();
    }
}
