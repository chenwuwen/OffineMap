package cn.kanyun.offinemap.service.impl;

import cn.kanyun.offinemap.mapper.PoiMapper;
import cn.kanyun.offinemap.model.Poi;
import cn.kanyun.offinemap.service.PoiService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by root on 2018/3/13 0013.
 */
@Service
public class PoiServiceImpl extends BaseServiceImpl<Poi, Long> implements PoiService {

    @Autowired
    private PoiMapper poiMapper;


    @Override
    public List<Poi> getAll(Poi poi) {
        if (poi.getPage() != null && poi.getRows() != null) {
            PageHelper.startPage(poi.getPage(), poi.getRows());
        }
        return poiMapper.selectAll();
    }

    @Override
    public List<Poi> getByCondition(Poi poi) {
        if (poi.getPage() != null && poi.getRows() != null) {
            PageHelper.startPage(poi.getPage(), poi.getRows());
        }
        return poiMapper.select(poi);
    }

    @Override
    public List<Poi> getMapByName(String name) {
        List<Poi> list = poiMapper.getMapByName(name);
        return list;
    }
}
