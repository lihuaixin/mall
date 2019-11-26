package com.xxx.mall.api.service.impl;

import com.xxx.mall.dao.domain.Orders;
import com.xxx.mall.dao.mapper.OrdersMapper;
import com.xxx.mall.api.service.OrdersService;
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
public class OrdersServiceImpl extends BaseServiceImpl<OrdersMapper, Orders> implements OrdersService {

}
