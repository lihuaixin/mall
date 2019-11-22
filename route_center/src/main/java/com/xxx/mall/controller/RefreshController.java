package com.xxx.mall.controller;

import com.xxx.mall.comment.domain.BaseResponse;
import com.xxx.mall.service.RefreshRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by lihuaixin on 2019/2/28 10:26
 */
@RestController
@RequestMapping("/route")
public class RefreshController {
    @Autowired
    RefreshRouteService refreshRouteService;
    @Autowired
    ZuulHandlerMapping zuulHandlerMapping;


    @GetMapping("/refresh")
    public BaseResponse<Object> refresh() {
        refreshRouteService.refreshRoute();
        return  new BaseResponse<>("200","success",null);
    }

    @RequestMapping("/watch")
    public BaseResponse<Object> watchNowRoute() {
        //可以用debug模式看里面具体是什么
        Map<String, Object> handlerMap = zuulHandlerMapping.getHandlerMap();
        return new BaseResponse<>("200","success",null);
    }

}
