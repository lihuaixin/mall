package com.xxx.mall.service.impl;

import com.xxx.mall.mapper.OrderMapper;
import com.xxx.mall.model.Orders;
import com.xxx.mall.service.OrderService;
import com.xxx.mall.vip_center.config.MyMapper;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lihuaixin on 2019/2/26 18:07
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<Orders,Integer> implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Override
    public MyMapper<Orders> getMapper() {
        return orderMapper;
    }
}
