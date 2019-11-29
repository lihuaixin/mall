package com.xxx.mall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.ReactiveRedisConnection;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;


/**
 *  限流算法是通过redis来存储的，需要加入其响应式的依赖,基于 reactive stream 的redis
 *@desc: redis cashe配置类
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