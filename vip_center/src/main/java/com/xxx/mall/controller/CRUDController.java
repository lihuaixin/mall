package com.xxx.mall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxx.mall.domain.BaseResponse;
import com.xxx.mall.domain.Constants;
import com.xxx.mall.service.BaseService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lihuaixin on 2019/2/28 14:10
 */
@RestController
public abstract class CRUDController<T, ID extends Serializable> {

    protected BaseService<T, ID> service;

    abstract void initService();

    @PostMapping("/insert")
    @Transactional
    public BaseResponse<T> insert(T record) {
        try {
            initService();
            int insert = service.insert(record);
            if (insert > 0)
                return new BaseResponse<>(Constants.SUCCEED_CODE_VALUE, Constants.SUCCEED_CODE_VALUE_MSG, record);
            else
                throw new Exception();
        } catch (Exception e) {
            return BaseResponse.fail("添加失败!");
        }
    }

    @PostMapping("/insertList")
    @Transactional
    BaseResponse<List<T>> insertList(List<T> list) {
        try {
            initService();
            int insert = service.insertList(list);
            if (insert > 0)
                return new BaseResponse<>(Constants.SUCCEED_CODE_VALUE, Constants.SUCCEED_CODE_VALUE_MSG, list);
            else
                throw new Exception();
        } catch (Exception e) {
            return BaseResponse.fail("添加失败!");
        }
    }


    @PostMapping("/updateById")
    @Transactional
    public BaseResponse<T> updateById(T record) {
        try {
            initService();
            int insert = service.updateById(record);
            if (insert > 0)
                return new BaseResponse<>(Constants.SUCCEED_CODE_VALUE, Constants.SUCCEED_CODE_VALUE_MSG, record);
            else
                throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.fail("更新失败!");
        }
    }

    @PostMapping("/updateByIdSelective")
    @Transactional
    public BaseResponse<T> updateByIdSelective(T record) {
        try {
            initService();
            int insert = service.updateByIdSelective(record);
            if (insert > 0)
                return new BaseResponse<>(Constants.SUCCEED_CODE_VALUE, Constants.SUCCEED_CODE_VALUE_MSG, record);
            else
                throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.fail("更新失败!");
        }
    }

    @GetMapping("/getById")
    public BaseResponse<T> getById(ID id) {
        try {
            initService();
            T record = service.getById(id);
            return new BaseResponse<>(Constants.SUCCEED_CODE_VALUE, Constants.SUCCEED_CODE_VALUE_MSG, record);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.fail("操作失败!");
        }
    }

    @PostMapping("/deleteById")
    @Transactional
    public BaseResponse<ID> deleteById(ID id) {
        try {
            initService();
            int delete = service.deleteById(id);
            if (delete > 0)
                return new BaseResponse<>(Constants.SUCCEED_CODE_VALUE, Constants.SUCCEED_CODE_VALUE_MSG, null);
            else
                throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.fail("操作失败!");
        }
    }

    @PostMapping("/delete")
    @Transactional
    public BaseResponse<ID> delete(T record) {
        try {
            initService();
            int delete = service.delete(record);
            if (delete > 0)
                return new BaseResponse<>(Constants.SUCCEED_CODE_VALUE, Constants.SUCCEED_CODE_VALUE_MSG, null);
            else
                throw new Exception();
        } catch (Exception e) {
            return BaseResponse.fail("操作失败!");
        }
    }


    @GetMapping("/selectOne")
    public BaseResponse<T> selectOne(T record) {
        try {
            initService();
            T select = service.selectOne(record);
            return new BaseResponse<>(Constants.SUCCEED_CODE_VALUE, Constants.SUCCEED_CODE_VALUE_MSG, select);
        } catch (Exception e) {
            return BaseResponse.fail("操作失败!");
        }
    }

    @GetMapping("/selectList")
    public BaseResponse<PageInfo<T>> selectList(T record, Integer pageNum, Integer pageSize) {
        try {
            initService();
            PageHelper.startPage(pageNum, pageSize);
            List<T> list = service.selectList(record);
            PageInfo<T> pageInfo = new PageInfo<>(list);
            return new BaseResponse<>(Constants.SUCCEED_CODE_VALUE, Constants.SUCCEED_CODE_VALUE_MSG, pageInfo);
        } catch (Exception e) {
            return BaseResponse.fail("操作失败!");
        }
    }

    @GetMapping("/selectAll")
    public BaseResponse<List<T>> selectAll() {
        try {
            initService();
            List<T> list = service.selectAll();
            return new BaseResponse<>(Constants.SUCCEED_CODE_VALUE, Constants.SUCCEED_CODE_VALUE_MSG, list);
        } catch (Exception e) {
            return BaseResponse.fail("操作失败!");
        }
    }


}
