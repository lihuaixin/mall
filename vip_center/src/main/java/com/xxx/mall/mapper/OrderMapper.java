package com.xxx.mall.mapper;

import com.xxx.mall.model.Orders;
import com.xxx.mall.vip_center.config.MyMapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface OrderMapper extends MyMapper<Orders> {

}