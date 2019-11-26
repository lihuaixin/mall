package com.xxx.mall.web.controller;

import com.xxx.mall.comment.domain.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.xxx.mall.dao.domain.Orders;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxx.mall.base.PageQueryWrapper;

import org.springframework.web.bind.annotation.RestController;
import com.xxx.mall.base.BaseController;
import com.xxx.mall.api.service.OrdersService;

import java.util.List;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lihuaixin
 * @since 2019-11-26
 */
@RestController
@RequestMapping("/vip/order")
public class OrdersController extends BaseController {

    @Autowired
    private OrdersService ordersService;


    /**
     * 保存或新增
     *
     * @param orders
     * @return
     */
    @PostMapping("/saveOrUpdate")
    public BaseResponse saveOrUpdate(@RequestBody Orders orders) throws Exception {
        if (ordersService.saveOrUpdate(orders)) {
            return  BaseResponse.success(orders);
        }
        throw new Exception();
    }
    /**
     * 分页查询
     *
     * @param query 默认使用实体作为查询参数，可根据业务需要替换为查询对象，如若替换为查询对象，请修改相应mapper文件的sql查询
     * @return 分页结果集
     */
    @PostMapping("/list")
    public BaseResponse list(@RequestBody PageQueryWrapper<Orders> query) {

        query.setQueryClazz(Orders.class);
        Page pageList = (Page) ordersService.pageQuery(query);

        return  BaseResponse.success(pageList);
    }
    /**
     * 批量删除
     *
     * @param idList
     * @return
     */
    @PostMapping("/remove")
    public BaseResponse remove(@RequestBody List<Long> idList) throws Exception {
        if (ordersService.removeByIds(idList)) {
             return  BaseResponse.success(null);
        }
        throw new Exception();
    }

    /**
     * 单条记录查询
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public BaseResponse getById(@PathVariable Long id) {
        Orders orders = ordersService.getById(id);
        return  BaseResponse.success(orders);
    }
    /**
     * 分页查询
     *
     * @return 分页结果集
     */
    @GetMapping("/selectAll")
    public BaseResponse list() {
        List<Orders> list = ordersService.list();
        return  BaseResponse.success(list);
    }
}

