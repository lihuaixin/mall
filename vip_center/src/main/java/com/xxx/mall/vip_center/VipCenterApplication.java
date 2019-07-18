package com.xxx.mall.vip_center;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.xxx.mall.mapper")
@ComponentScan("com.xxx.mall")
@EnableEurekaClient
public class VipCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(VipCenterApplication.class, args);
    }

}
