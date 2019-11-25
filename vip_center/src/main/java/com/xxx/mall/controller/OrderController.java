package com.xxx.mall.controller;

import com.xxx.mall.domain.Order;
import com.xxx.mall.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lihuaixin on 2019/2/26 16:41
 */
@Api(tags = "订单管理接口")
@RestController
@RequestMapping(value = "/vip/order")
public class OrderController extends CRUDController<Order,Integer>{
    @Autowired
    private OrderService orderService;

    @Override
    void initService() {
        super.service = orderService;
    }

}
