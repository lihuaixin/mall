package com.xxx.mall.innerService;


import com.xxx.mall.comment.domain.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseHystrix {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public BaseResponse failResponse(){
        logger.info("Hystrix fail 999");
        return BaseResponse.fail("访问失败断路器");
    }
}
