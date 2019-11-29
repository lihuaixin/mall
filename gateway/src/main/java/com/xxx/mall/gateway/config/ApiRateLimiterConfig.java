package com.xxx.mall.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * Created by lihuaixin on 2019/11/29 10:57
 */
@Configuration
public class ApiRateLimiterConfig {

    /** 令牌桶每秒填充平均速率 */
    @Value("${spring.cloud.gateway.redis-rate-limiter.apiReplenishRate}")
    private int apiReplenishRate;

    /** 令牌桶最大容量,用户允许在一秒钟内完成的最大请求数，这是令牌桶可以容纳的令牌的数量，将此值设置为零将阻止所有请求 */
    @Value("${spring.cloud.gateway.redis-rate-limiter.apiBurstCapacity}")
    private int apiBurstCapacity;

    /**
     * 自定义 apiRedisRateLimiter,针对api限流
     * @return
     */
    @Bean
    public RedisRateLimiter apiRedisRateLimiter() {
        System.out.println(apiReplenishRate+":"+apiBurstCapacity);
        return new RedisRateLimiter(apiReplenishRate, apiBurstCapacity);
    }

    /**
     * 根据api接口来限流 根据路径exchange.getRequest().getPath()
     * 接口举例：/gateway/vip/order/1
     * @return
     */
    @Bean(name="apiKeyResolver")
    public KeyResolver apiKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getPath().value());
    }
}
