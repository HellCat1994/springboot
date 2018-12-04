package com.whg.demo.dao;

import com.whg.demo.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;
    @Test
    public void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        System.out.println(areaList.get(0).getAreaName());
    }
    @Test
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        System.out.println(area);

    }
    @Test
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("科研楼");
        area.setCreateTime(new Date());
        area.setPriority(100);
        areaDao.insertArea(area);
    }

    @Test
    public void updateArea() {
        Area area = new Area();
        area.setAreaName("综合科研大楼");
        area.setAreaId(3);
        areaDao.updateArea(area);
    }

    @Test
    public void deleteArea() {
        areaDao.deleteArea(3);
    }
}