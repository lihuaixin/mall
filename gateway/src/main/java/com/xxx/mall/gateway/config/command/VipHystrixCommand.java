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
public class VipHystrixCommand {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/vipCenter/hystrixFallback")
    public BaseResponse hystrixFallback() {
        logger.warn("/vipCenter/hystrixFallback");
        return BaseResponse.fail("/vip/hystrixFallback");
    }

    @HystrixCommand(commandKey = "vipHystrixCommand")
    public BaseResponse vipHystrixCommand() {
        logger.warn("route id=vip-center,vip HystrixCommand");
        return BaseResponse.fail("");
    }
}
