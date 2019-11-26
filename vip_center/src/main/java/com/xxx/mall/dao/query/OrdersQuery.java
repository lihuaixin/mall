package com.xxx.mall.dao.query;

import java.util.Date;
import lombok.Data;

/**
 * <p>
 * 查询对象
 * </p>
 *
 * @author lihuaixin
 * @since 2019-11-26
 */
@Data
public class OrdersQuery {

    private String custId;

    private Date orderDateBegin;

    private Date orderDateEnd;


}
