package com.whg.demo.service.impl;

import com.whg.demo.entity.Area;

import java.util.List;

public interface AreaService {

    List<Area> getAreaList();

    Area getAreaById(int areaId);

    boolean modifyArea(Area area);

    boolean deleteArea(int areaId);
    /**
     * 添加区域信息
     * @param area
     * @return
     */
    boolean addArea(Area area);
}
