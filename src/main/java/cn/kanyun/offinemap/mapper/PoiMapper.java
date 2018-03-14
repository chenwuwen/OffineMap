package cn.kanyun.offinemap.mapper;

import cn.kanyun.offinemap.model.Poi;
import cn.kanyun.offinemap.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PoiMapper extends MyMapper<Poi> {
    List<Poi> getMapByName(@Param("name") String name);
}