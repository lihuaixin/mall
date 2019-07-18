package com.xxx.mall.service.impl;

import com.xxx.mall.service.BaseService;
import com.xxx.mall.vip_center.config.MyMapper;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class BaseServiceImpl<T, ID extends Serializable> implements
        BaseService<T, ID> {

    @Override
    public int insert(T record) {
        return getMapper().insert(record);
    }

    @Override
    public int insertSelective(T record) {
        return getMapper().insertSelective(record);
    }

    @Override
    public int updateById(T record) {
        return getMapper().updateByPrimaryKey(record);
    }

    @Override
    public int updateByIdSelective(T record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    @Override
    public T getById(ID id) {
        return getMapper().selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(ID id) {
        return getMapper().deleteByPrimaryKey(id);
    }

    @Override
    public int insertList(List<T> list) {
        return getMapper().insertList(list);
    }

    @Override
    public T selectOne(T record) {
        return getMapper().selectOne(record);
    }

    @Override
    public List<T> selectList(T record) {
        return getMapper().select(record);
    }

    @Override
    public List<T> selectAll() {
        return getMapper().selectAll();
    }

    @Override
    public int delete(T record) {
        return getMapper().delete(record);
    }

    @Override
    public List<T> selectByExample(Object condition) {
        return getMapper().selectByExample(condition);
    }

    public abstract MyMapper<T> getMapper();

}
