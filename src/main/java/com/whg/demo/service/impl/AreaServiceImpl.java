package com.whg.demo.service.impl;

import com.sun.org.apache.regexp.internal.RE;
import com.whg.demo.dao.AreaDao;
import com.whg.demo.entity.Area;
import org.omg.SendingContext.RunTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.HTMLDocument;
import javax.swing.text.rtf.RTFEditorKit;
import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService{
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Override
    public boolean modifyArea(Area area) {
        if(area.getAreaId()!=null && area.getAreaId()>0){
            area.setLastEditTime(new Date());
            try {
                int num = areaDao.updateArea(area);
                if(num > 0){
                    return true;
                }else{
                    throw new RuntimeException("更新区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("更新区域信息失败"+e.getMessage());
            }
        }else{
            throw new RuntimeException("更新区域不能为空");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if(areaId>0){
            try {
                int num = areaDao.deleteArea(areaId);
                if(num > 0 ){
                    return true;
                }else {
                    throw new RuntimeException("删除区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("删除区域信息失败"+e.getMessage());
            }
        }else {
            throw new RuntimeException("区域Id不能为空");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addArea(Area area) {
        if(area.getAreaName()!=null && !"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int num = areaDao.insertArea(area);
                if(num>0){
                    return true;
                }else{
                    throw new RuntimeException("插入区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败:"+e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空");
        }
    }
}
