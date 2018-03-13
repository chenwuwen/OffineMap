package cn.kanyun.offinemap.service;

import cn.kanyun.offinemap.model.Poi;

import java.util.List;

/**
 * Created by root on 2018/3/13 0013.
 */
public interface PoiService extends BaseService<Poi, Long> {

    List<Poi> getAll(Poi poi);

    List<Poi> getByCondition(Poi poi);
}
