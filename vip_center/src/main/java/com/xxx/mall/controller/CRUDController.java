package com.xxx.mall.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xxx.mall.base.BaseResponse;
import com.xxx.mall.base.BaseService;
import com.xxx.mall.base.Constants;
import com.xxx.mall.base.PageQueryWrapper;
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

    protected BaseService service;

    abstract void initService();

    @PostMapping("/insert")
    @Transactional
    public BaseResponse<T> insert(T record) {
        try {
            initService();
            if (service.save(record))
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
            if (service.saveBatch(list))
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
            if (service.updateById(record))
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
    public BaseResponse updateByIdSelective(Wrapper<T> record) {
        try {
            initService();
            if ( service.update(record))
                return new BaseResponse(Constants.SUCCEED_CODE_VALUE, Constants.SUCCEED_CODE_VALUE_MSG);
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
            T record = (T) service.getById(id);
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
            if (service.removeById(id) )
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
    public BaseResponse<ID> delete(Wrapper<T> record) {
        try {
            initService();
            if (service.remove(record))
                return new BaseResponse<>(Constants.SUCCEED_CODE_VALUE, Constants.SUCCEED_CODE_VALUE_MSG, null);
            else
                throw new Exception();
        } catch (Exception e) {
            return BaseResponse.fail("操作失败!");
        }
    }


    @GetMapping("/selectOne")
    public BaseResponse<T> selectOne(Wrapper<T> record) {
        try {
            initService();
            T select = (T) service.getOne( record);
            return new BaseResponse<>(Constants.SUCCEED_CODE_VALUE, Constants.SUCCEED_CODE_VALUE_MSG, select);
        } catch (Exception e) {
            return BaseResponse.fail("操作失败!");
        }
    }

    @GetMapping("/selectList")
    public BaseResponse<Object> selectList(PageQueryWrapper<T> record) {
        try {
            initService();
            IPage list = service.pageQuery(record);
            return new BaseResponse<>(Constants.SUCCEED_CODE_VALUE, Constants.SUCCEED_CODE_VALUE_MSG, list);
        } catch (Exception e) {
            return BaseResponse.fail("操作失败!");
        }
    }

    @GetMapping("/selectAll")
    public BaseResponse<List<T>> selectAll() {
        try {
            initService();
            List<T> list = service.list();
            return new BaseResponse<>(Constants.SUCCEED_CODE_VALUE, Constants.SUCCEED_CODE_VALUE_MSG, list);
        } catch (Exception e) {
            return BaseResponse.fail("操作失败!");
        }
    }


}
