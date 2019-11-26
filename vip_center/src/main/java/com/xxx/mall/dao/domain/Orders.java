package com.xxx.mall.dao.domain;

import com.xxx.mall.base.BaseEntity;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lihuaixin
 * @since 2019-11-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Orders extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String custId;

    private Date orderDate;


}
