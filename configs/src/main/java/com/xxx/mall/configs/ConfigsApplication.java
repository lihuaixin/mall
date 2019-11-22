package com.xxx.mall.configs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * @EnableConfigServer config 服务
 * @EnableEurekaClient 连接注册中心配置
 * @RefreshScope 当远程仓库配置文件发生变化会动态刷新配置，通过调用/actuator/refresh接口(post请求)，config-server会再次从git仓库拉取配置文件信息
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
@RefreshScope
@RestController
public class ConfigsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigsApplication.class, args);
    }

}
