package com.xxx.mall.gateway.config.command;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xxx.mall.comment.domain.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 */
@RestController
public class OrderHystrixCommand {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/orderCenter/hystrixFallback")
    public BaseResponse hystrixFallback() {
        logger.warn("/orderCenter/hystrixFallback");
        return BaseResponse.fail("/orderCenter/hystrixFallback");
    }

    @HystrixCommand(commandKey = "orderHystrixCommand")
    public BaseResponse orderHystrixCommand() {
        logger.warn("route id=order-center,order HystrixCommand");
        return BaseResponse.fail("route id=order-center,order HystrixCommand");
    }
}
