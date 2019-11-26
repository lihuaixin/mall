package com.xxx.mall.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.ReactiveRedisConnection;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;


/**
 *@desc: redis cashe配置类
 *@author:  weiqingeng
 *@date:  2018/7/13 20:10
 */
@Configuration
public class ReactiveRedisCacheConfig {

    @Bean
    @Primary
    public ReactiveRedisTemplate<String, String> reactiveRedisTemplate(ReactiveRedisConnectionFactory connectionFactory){
        return new ReactiveRedisTemplate<>(connectionFactory, RedisSerializationContext.string());
    }

    @Bean
    public ReactiveRedisConnection connection(ReactiveRedisConnectionFactory connectionFactory){
        return connectionFactory.getReactiveConnection();
    }

}