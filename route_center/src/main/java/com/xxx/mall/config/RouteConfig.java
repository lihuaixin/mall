package com.xxx.mall.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@EnableZuulProxy
public class RouteConfig {

    @Resource
    ZuulProperties zuulProperties;

    @Autowired
    ServerProperties serverProperties;

    @Bean
    RouteLoader routeLoader(){
        return new RouteLoader("/", zuulProperties);
    }




}
