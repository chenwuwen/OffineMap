package cn.kanyun.offinemap.mapper;

/**
 * Created by root on 2018/3/13 0013.
 */

import java.io.Serializable;

public interface BaseMapper<T, ID extends Serializable> {
    int deleteByPrimaryKey(ID id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(ID id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(T record);
}