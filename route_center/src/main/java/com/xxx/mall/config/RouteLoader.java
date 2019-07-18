package com.xxx.mall.config;


import com.xxx.mall.domain.RouteDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RouteLoader extends SimpleRouteLocator implements RefreshableRouteLocator {

    public final static Logger logger = LoggerFactory.getLogger(RouteLoader.class);

    private ZuulProperties properties;

    public RouteLoader(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
        this.properties = properties;
    }

    @Override
    public void refresh() {
        doRefresh();
    }

    @Override
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {
        LinkedHashMap<String, ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap<>();
        routesMap.putAll(super.locateRoutes());
        routesMap.putAll(loadRoutesFromMysql());
        LinkedHashMap<String, ZuulProperties.ZuulRoute> values = new LinkedHashMap<>();
        for (Map.Entry<String, ZuulProperties.ZuulRoute> entry : routesMap.entrySet()) {
            String path = entry.getKey();

            if (!path.startsWith("/")) {
                path = "/" + path;
            }
            if (StringUtils.hasText(this.properties.getPrefix())) {
                path = this.properties.getPrefix() + path;
                if (!path.startsWith("/")) {
                    path = "/" + path;
                }
            }
            values.put(path, entry.getValue());
        }
        return values;
    }

    /**
     * 加载路由信息
     * @return
     */
    private Map<String, ZuulProperties.ZuulRoute> loadRoutesFromMysql(){
        Map<String, ZuulProperties.ZuulRoute> routes = new LinkedHashMap<>();
        //获取配置
        List<RouteDo> results = initRoute();
        for (RouteDo result : results) {
            if (StringUtils.isEmpty(result.getPath()) ) {
                continue;
            }
            if (StringUtils.isEmpty(result.getServiceId()) && StringUtils.isEmpty(result.getUrl())) {
                continue;
            }

            ZuulProperties.ZuulRoute zuulRoute = new ZuulProperties.ZuulRoute();
            try {
                BeanUtils.copyProperties(result, zuulRoute);
                logger.info("--------load route info !--------------");
            } catch (Exception e) {
                logger.error("load route info error!", e);
            }
            routes.put(zuulRoute.getPath(), zuulRoute);
        }
        return routes;
    }

    private List<RouteDo> initRoute() {
        ArrayList<RouteDo> routeDos = new ArrayList<>();
        RouteDo vipRouteDo = new RouteDo();
        vipRouteDo.setId("vip");
        vipRouteDo.setPath("/vip/**");
        vipRouteDo.setServiceId("vip-center");
        vipRouteDo.setStripPrefix(false);
        vipRouteDo.setRetryable(true);

        RouteDo orderRouteDo = new RouteDo();
        orderRouteDo.setId("order");
        orderRouteDo.setPath("/order/**");
        orderRouteDo.setServiceId("order-center");
        orderRouteDo.setStripPrefix(false);
        orderRouteDo.setRetryable(true);

        routeDos.add(vipRouteDo);
        routeDos.add(orderRouteDo);
        return routeDos;
    }

}
