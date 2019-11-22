package com.xxx.mall.configs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * @EnableConfigServer config 服务
 * @EnableEurekaClient 连接注册中心配置
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
@RestController
public class ConfigsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigsApplication.class, args);
    }

}
