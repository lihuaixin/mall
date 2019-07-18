package com.xxx.mall.innerService;

import com.xxx.mall.comment.domain.BaseResponse;
import com.xxx.mall.innerService.hystrix.OrderServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by lihuaixin on 2019/2/27 11:18
 */
@FeignClient(value = "vip-center", fallback = OrderServiceHystrix.class)
public interface OrderService {
    @GetMapping("/vip/order/selectAll")
    BaseResponse<Object> orderList();
}
