package com.xxx.mall.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.xxx.mall.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liqiang
 * @since 2019-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Order extends BaseEntity {

    private static final long serialVersionUID=1L;

    @TableId(value = "order_num", type = IdType.AUTO)
    private Integer orderNum;

    private String custId;

    private LocalDateTime orderDate;


}
