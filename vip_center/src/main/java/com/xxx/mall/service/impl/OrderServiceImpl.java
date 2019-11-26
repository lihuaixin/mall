package com.xxx.mall.service.impl;

import com.xxx.mall.domain.Order;
import com.xxx.mall.mapper.OrderMapper;
import com.xxx.mall.service.OrderService;
import com.xxx.mall.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihuaixin
 * @since 2019-11-26
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderMapper, Order> implements OrderService {

}
