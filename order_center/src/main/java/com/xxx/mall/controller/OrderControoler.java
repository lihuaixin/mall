package com.xxx.mall.controller;

import com.xxx.mall.comment.domain.BaseResponse;
import com.xxx.mall.innerService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lihuaixin on 2019/2/27 11:17
 */
@RequestMapping(value = "/order/order")
@RestController
public class OrderControoler {
    @Autowired
    OrderService orderService;
    @GetMapping("selectAll")
    public BaseResponse list(){
        BaseResponse<Object> baseResponse = orderService.orderList();
        return baseResponse;
    }
}
