package com.xxx.mall.mapper;


import com.xxx.mall.base.BaseDao;
import com.xxx.mall.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liqiang
 * @since 2019-11-22
 */
@Mapper
public interface OrderMapper extends BaseDao<Order> {

}
