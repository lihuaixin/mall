package com.xxx.mall.gateway.config.router;


import com.xxx.mall.gateway.constant.ServiceConstant;
import com.xxx.mall.gateway.enums.RouteIdEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @desc: order服务路由，将网关的对应的请求转发到订单模块
 * @date: 2019/1/3 15:42
 * @author: lihuaixin
 */
@EnableAutoConfiguration
@Configuration
public class OrderServiceRouter {

    private Logger logger = LoggerFactory.getLogger(OrderServiceRouter.class);

    @Autowired
    private KeyResolver apiKeyResolver;
    @Autowired
    private RedisRateLimiter apiRedisRateLimiter;

    @Bean
    public RouteLocator orderRouter(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        RouteLocatorBuilder.Builder serviceProvider = routes
                /**
                 * 拦截 订单模块 站内H5 访问 /gateway/order/** 的所有请求，lb:// 代表将请求通过负载均衡路由到order-center服务上面
                 */
                .route(RouteIdEnum.VIP_ROUTE_ID.getCode(),
                        r -> r.path("/order/**")
                                .filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(apiRedisRateLimiter).setKeyResolver(apiKeyResolver))
                                        .hystrix(h -> h.setName("orderHystrixCommand").setFallbackUri("forward:/orderCenter/hystrixFallback"))
                                )
                                .uri("lb://".concat(ServiceConstant.ORDER_SERVICE))
                )
                ;
        RouteLocator routeLocator = serviceProvider.build();
        logger.info("OrderServiceRouter is loading ... {}", routeLocator);
        return routeLocator;
    }


}
