package com.xxx.mall.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, ID extends Serializable> {

    int insert(T record);

    int insertSelective(T record);

    int updateById(T record);

    int updateByIdSelective(T record);

    T getById(ID id);

    int deleteById(ID id);

    int insertList(List<T> list);

    T selectOne(T record);

    List<T> selectList(T record);

    List<T> selectAll();

    int delete(T record);

    /**
     * 按照*example类来查询记录
     * @param condition
     * @return
     */
    List<T> selectByExample(Object condition);


}
