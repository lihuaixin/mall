package com.xxx.mall.gateway.enums;

/**
 * @desc:  路由id枚举
 * @author:  weiqingeng
 * @date:  2018/8/11 16:52
 */
public enum RouteIdEnum {

    // vip服务
    ORDER_VIP_ROUTE_ID("vip_route", "vip服务路由id"),
    ;

    private String code;
    private String description;

    RouteIdEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
