package com.shf.spring.sms.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.shf.spring.sms.entity.Location;
import com.shf.spring.sms.entity.Location;
import com.shf.spring.sms.mapper.LocationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
public class LocationController {
    @Autowired
    private LocationMapper locationMapper;

    @ResponseBody
    @GetMapping("/location/isAvailableLocationNO")
    public HashMap<String, Object> isAvailableLocationNO(Location location){
        Location room = locationMapper.selectById(location.getLocationNo());
        HashMap<String, Object> map = new HashMap<>();
        if (room == null){
            map.put("code","100");
            map.put("id",location.getLocationNo());
        } else {
            map.put("code","500");
            map.put("id",location.getLocationNo());
        }
        return map;
    }
    
    public Location getLocationById(Integer id){
        return locationMapper.selectById(id);
    }
    public List<Location> locationList(){
        return locationMapper.selectList(null);
    }

    @GetMapping("/location/locationListPage")
    public String toLocationList(Model model){
        List<Location> locationList = locationMapper.selectList(null);
        model.addAttribute("locationList",locationList);
        return "location/admin-list";
    }

    @ResponseBody
    @PostMapping("/location/deleteLocationById")
    public HashMap<String, Object> deleteLocationById(Location location){
        log.info(location.toString());

        int count = locationMapper.deleteById(location.getLocationNo());
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",location.getLocationNo());
        } else {
            map.put("code","500");
            map.put("id",location.getLocationNo());
        }
        return map;
    }

    @ResponseBody
    @PostMapping("/location/deleteBatchIds")
    public HashMap<String, Object> deleteBatchIds(String ids){
        System.out.println(ids);

        JSON parse = JSONUtil.parse(ids);
        int count = locationMapper.deleteBatchIds((Collection<? extends Serializable>) parse);
        log.info(String.valueOf(count));
        HashMap<String, Object> map = new HashMap<>();
        if (count>=1){
            map.put("code","100");
            map.put("ids",ids);
        } else {
            map.put("code","500");
            map.put("ids",ids);
        }
        return map;
    }

    @GetMapping("/location/locationAdd")
    public String toUserAdd(){
        return "location/admin-add";
    }

    @ResponseBody
    @PostMapping("/location/locationAdd")
    public HashMap<String, Object> locationAdd(Location location){
        log.info(location.toString());

        int count = locationMapper.insert(location);
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",location.getLocationNo());
        } else {
            map.put("code","500");
            map.put("id",location.getLocationNo());
        }
        return map;
    }

    @GetMapping("/location/locationUpdate/{id}")
    public String toLocationUpdate(@PathVariable("id") Integer id,Model model){
        Location t = locationMapper.selectById(id);
        model.addAttribute("location",t);
        return "location/admin-update";
    }

    @ResponseBody
    @PostMapping("/location/locationUpdate")
    public HashMap<String, Object> locationUpdate(Location location){
        log.info(location.toString());

        int count = locationMapper.updateById(location);
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",location.getLocationNo());
        } else {
            map.put("code","500");
            map.put("id",location.getLocationNo());
        }
        return map;
    }

}
