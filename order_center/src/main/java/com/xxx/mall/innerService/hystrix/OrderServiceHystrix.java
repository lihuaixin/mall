package com.xxx.mall.innerService.hystrix;

import com.xxx.mall.comment.domain.BaseResponse;
import com.xxx.mall.innerService.BaseHystrix;
import com.xxx.mall.innerService.OrderService;
import org.springframework.stereotype.Component;

/**
 * Created by lihuaixin on 2019/2/27 11:20
 */
@Component
public class OrderServiceHystrix extends BaseHystrix implements OrderService {
    @Override
    public BaseResponse<Object> orderList() {
        return failResponse();
    }
}
