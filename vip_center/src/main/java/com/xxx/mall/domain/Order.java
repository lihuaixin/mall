package com.xxx.mall.domain;

import com.xxx.mall.base.BaseEntity;
import java.time.LocalDateTime;
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
public class Order extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String custId;

    private LocalDateTime orderDate;


}
