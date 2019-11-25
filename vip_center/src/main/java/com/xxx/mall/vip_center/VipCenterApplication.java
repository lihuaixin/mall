package com.xxx.mall.vip_center;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.xxx.mall")
@MapperScan("com.xxx.mall")
@EnableEurekaClient
public class VipCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(VipCenterApplication.class, args);
    }

}
