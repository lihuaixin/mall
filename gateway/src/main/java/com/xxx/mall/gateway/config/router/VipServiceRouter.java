package com.xxx.mall.gateway.config.router;


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
import reactor.core.publisher.Mono;


/**
 * @desc: vip服务路由，将网关的对应的请求转发到Vip模块
 * @date: 2019/1/3 15:42
 * @author: lihuaixin
 */
@EnableAutoConfiguration
@Configuration
public class VipServiceRouter {

    private Logger logger = LoggerFactory.getLogger(VipServiceRouter.class);
    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Autowired
    private KeyResolver apiKeyResolver;
    @Autowired
    private RedisRateLimiter apiRedisRateLimiter;

    @Bean
    public RouteLocator vipRouter(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        RouteLocatorBuilder.Builder serviceProvider = routes
                /**
                 * 拦截 订单模块 站内H5 访问 /gateway/vip/** 的所有请求，lb:// 代表将请求通过负载均衡路由到vip-center服务上面
                 */
                .route(RouteIdEnum.VIP_ROUTE_ID.getCode(),
                        r -> r.path(contextPath.concat("/vip/**"))
                                .filters(f -> f.stripPrefix(1).requestRateLimiter(c -> c.setRateLimiter(apiRedisRateLimiter).setKeyResolver(apiKeyResolver))
                                        .hystrix(h -> h.setName("vipHystrixCommand").setFallbackUri("forward:/vipCenter/hystrixFallback"))
                                )
                                .uri("lb://".concat(ServiceConstant.VIP_SERVICE))
                )
                ;
        RouteLocator routeLocator = serviceProvider.build();
        logger.info("VipServiceRouter is loading ... {}", routeLocator);
        return routeLocator;
    }


}
