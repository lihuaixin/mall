package com.xxx.mall.gateway.config;


import com.xxx.mall.gateway.constant.ServiceConstant;
import com.xxx.mall.gateway.enums.RouteIdEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @desc: vip服务路由，将网关的对应的请求转发到订单模块
 * @date: 2019/1/3 15:42
 * @author: lihuaixin
 */
@EnableAutoConfiguration
@Configuration
public class VipServiceRouter {

    private Logger logger = LoggerFactory.getLogger(VipServiceRouter.class);

    @Autowired
    private KeyResolver keyResolver;
    /**
     * 自定义 apiRedisRateLimiter,针对api限流
     *
     * @return
     */
    /** 每秒最大访问次数 */
    @Value("${spring.cloud.gateway.redis-rate-limiter.apiReplenishRate}")
    private int apiReplenishRate;

    /** 令牌桶最大容量,用户允许在一秒钟内完成的最大请求数，这是令牌桶可以容纳的令牌的数量，将此值设置为零将阻止所有请求 */
    @Value("${spring.cloud.gateway.redis-rate-limiter.apiBurstCapacity}")
    private int apiBurstCapacity;

    @Bean
    public RedisRateLimiter redisRateLimiter() {
        return new RedisRateLimiter(apiReplenishRate, apiBurstCapacity);
    }

    @Bean
    public RouteLocator orderRouter(RouteLocatorBuilder builder,RedisRateLimiter redisRateLimiter) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        RouteLocatorBuilder.Builder serviceProvider = routes

                /**
                 * 拦截 订单模块 站内H5 访问 /gateway/order/inner/** 的所有请求，lb:// 代表将请求通过负载均衡路由到ishangjie-order-service服务上面
                 */
                .route(RouteIdEnum.ORDER_VIP_ROUTE_ID.getCode(),
                        r -> r.path("/vip/**")
                                .filters(f -> f.stripPrefix(1)
                                        .requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter).setKeyResolver(keyResolver))
                                        .hystrix(h -> h.setName("orderInnerHystrixCommand").setFallbackUri("forward:/orderInner/hystrixFallback")))
                                .uri("lb://".concat(ServiceConstant.VIP_SERVICE))
                )

                ;
        RouteLocator routeLocator = serviceProvider.build();
        logger.info("OrderServiceRouter is loading ... {}", routeLocator);
        return routeLocator;
    }


}
