package com.shf.spring.sms.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.shf.spring.sms.entity.Class;
import com.shf.spring.sms.entity.ClassRoom;
import com.shf.spring.sms.entity.Location;
import com.shf.spring.sms.mapper.ClassRoomMapper;
import com.shf.spring.sms.mapper.ClassRoomMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
public class ClassRoomController {
    @Autowired
    private ClassRoomMapper classRoomMapper;

    @Autowired
    private LocationController locationController;

    @ResponseBody
    @GetMapping("/classRoom/isAvailableClassRoomNO")
    public HashMap<String, Object> isAvailableClassRoomNO(ClassRoom classRoom){
        ClassRoom room = classRoomMapper.selectById(classRoom.getClassRoomNO());
        HashMap<String, Object> map = new HashMap<>();
        if (room == null){
            map.put("code","100");
            map.put("id",classRoom.getClassRoomNO());
        } else {
            map.put("code","500");
            map.put("id",classRoom.getClassRoomNO());
        }
        return map;
    }

    @ResponseBody
    @GetMapping("/classRoom/classRoomList")
    public List<ClassRoom> toClassRoomList(){
        return classRoomMapper.selectList(null);
    }

    public ClassRoom getClassRoomById(Integer id){
        return classRoomMapper.selectById(id);
    }
    
    
    @GetMapping("/classRoom/classRoomListPage")
    public String toClassRoomList(Model model){
        List<ClassRoom> classRoomList = classRoomMapper.selectList(null);
        for (ClassRoom classRoom : classRoomList) {
            classRoom.setLocationName(locationController.getLocationById(classRoom.getLocationNo()).getLocationName());
        }
        model.addAttribute("classRoomList",classRoomList);
        return "classRoom/admin-list";
    }

    @ResponseBody
    @PostMapping("/classRoom/deleteClassRoomById")
    public HashMap<String, Object> deleteClassRoomById(ClassRoom classRoom){
        log.info(classRoom.toString());

        int count = classRoomMapper.deleteById(classRoom.getClassRoomNO());
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",classRoom.getClassRoomNO());
        } else {
            map.put("code","500");
            map.put("id",classRoom.getClassRoomNO());
        }
        return map;
    }

    @ResponseBody
    @PostMapping("/classRoom/deleteBatchIds")
    public HashMap<String, Object> deleteBatchIds(String ids){
        System.out.println(ids);

        JSON parse = JSONUtil.parse(ids);
        int count = classRoomMapper.deleteBatchIds((Collection<? extends Serializable>) parse);
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

    @GetMapping("/classRoom/classRoomAdd")
    public String toUserAdd(Model model){
        List<Location> locations = locationController.locationList();
        model.addAttribute("locationList",locations);
        return "classRoom/admin-add";
    }

    @ResponseBody
    @PostMapping("/classRoom/classRoomAdd")
    public HashMap<String, Object> classRoomAdd(ClassRoom classRoom){
        log.info(classRoom.toString());

        int count = classRoomMapper.insert(classRoom);
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",classRoom.getClassRoomNO());
        } else {
            map.put("code","500");
            map.put("id",classRoom.getClassRoomNO());
        }
        return map;
    }

    @GetMapping("/classRoom/classRoomUpdate/{id}")
    public String toClassRoomUpdate(@PathVariable("id") Integer id, Model model){
        List<Location> locations = locationController.locationList();
        model.addAttribute("locationList",locations);
        ClassRoom t = classRoomMapper.selectById(id);
        model.addAttribute("classRoom",t);
        return "classRoom/admin-update";
    }

    @ResponseBody
    @PostMapping("/classRoom/classRoomUpdate")
    public HashMap<String, Object> classRoomUpdate(ClassRoom classRoom){
        log.info(classRoom.toString());

        int count = classRoomMapper.updateById(classRoom);
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",classRoom.getClassRoomNO());
        } else {
            map.put("code","500");
            map.put("id",classRoom.getClassRoomNO());
        }
        return map;
    }
}
