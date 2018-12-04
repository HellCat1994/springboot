package com.whg.demo.web;

import com.whg.demo.entity.Area;
import com.whg.demo.service.impl.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@RestController
@RequestMapping(value = "/whg")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @GetMapping(value = "/listarea")
    private Map<String,Object> listArea(){
        Map<String,Object> map = new HashMap<>(1);
        List<Area> areaList = areaService.getAreaList();
        map.put("arrayList",areaList);
        return map;
    }

    @GetMapping(value = "/getareabyid")
    private Map<String,Object> getAreaById(Integer areaId){
        Map<String,Object> map = new HashMap<>(1);
        Area area = areaService.getAreaById(areaId);
        map.put("area",area);
        return map;
    }

    @PostMapping(value = "/addarea")
    private Map<String,Object> addArea(@RequestBody Area area){
        Map<String,Object> map = new HashMap<>(1);
        map.put("success",areaService.addArea(area));
        return map;
    }
    @PostMapping(value = "/modifyarea")
    private Map<String,Object> modifyArea(@RequestBody Area area){
        Map<String,Object> map = new HashMap<>(1);
        map.put("success",areaService.modifyArea(area));
        return map;
    }

    @GetMapping(value = "/removearea")
    private Map<String,Object> deleteArea(Integer id){
        Map<String,Object> map = new HashMap<>(1);
        map.put("success",areaService.deleteArea(id));
        return map;
    }
}
