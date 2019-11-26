package com.xxx.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.xxx.mall.domain.Order;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxx.mall.base.PageQueryWrapper;

import org.springframework.web.bind.annotation.RestController;
import com.xxx.mall.base.BaseController;
import com.xxx.mall.service.OrderService;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lihuaixin
 * @since 2019-11-26
 */
@RestController
@RequestMapping("/vip/order")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;


    /**
     * 保存或新增
     *
     * @param order
     * @return
     */
    @PostMapping("/saveOrUpdate")
    public Order saveOrUpdate(@RequestBody Order order) throws Exception {
        if (orderService.saveOrUpdate(order)) {
            return order;
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
    public Page list(@RequestBody PageQueryWrapper<Order> query) {

        query.setQueryClazz(Order.class);
        Page pageList = (Page) orderService.pageQuery(query);

        return pageList;
    }


    /**
     * 分页查询
     *
     * @return 分页结果集
     */
    @GetMapping("/selectAll")
    public List<Order> list() {
        List<Order> list = orderService.list();
        return list ;
    }

    /**
     * 批量删除
     *
     * @param idList
     * @return
     */
    @PostMapping("/remove")
    public void remove(@RequestBody List<Long> idList) throws Exception {
        if (orderService.removeByIds(idList)) {
            return;
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
    public Order getById(@PathVariable Long id) {
        Order order = orderService.getById(id);
        return order;
    }
}

