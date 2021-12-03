package com.shf.spring.sms.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.shf.spring.sms.entity.Faculty;
import com.shf.spring.sms.entity.Faculty;
import com.shf.spring.sms.entity.Faculty;
import com.shf.spring.sms.mapper.FacultyMapper;
import com.shf.spring.sms.mapper.FacultyMapper;
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
public class FacultyController {
    @Autowired
    private FacultyMapper facultyMapper;

    @ResponseBody
    @GetMapping("/faculty/isAvailableFacultyNO")
    public HashMap<String, Object> isAvailableFacultyNO(Faculty faculty){
        Faculty room = facultyMapper.selectById(faculty.getFacultyNO());
        HashMap<String, Object> map = new HashMap<>();
        if (room == null){
            map.put("code","100");
            map.put("id",faculty.getFacultyNO());
        } else {
            map.put("code","500");
            map.put("id",faculty.getFacultyNO());
        }
        return map;
    }
    
    @ResponseBody
    @GetMapping("/faculty/facultyList")
    public List<Faculty> toFacultyList(){
        return facultyMapper.selectList(null);
    }

    public Faculty getFacultyById(Integer id){
        return facultyMapper.selectById(id);
    }
    
    
    @GetMapping("/faculty/facultyListPage")
    public String toFacultyList(Model model){
        List<Faculty> facultyList = facultyMapper.selectList(null);
        model.addAttribute("facultyList",facultyList);
        return "faculty/admin-list";
    }

    @ResponseBody
    @PostMapping("/faculty/deleteFacultyById")
    public HashMap<String, Object> deleteFacultyById(Faculty faculty){
        log.info(faculty.toString());

        int count = facultyMapper.deleteById(faculty.getFacultyNO());
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",faculty.getFacultyNO());
        } else {
            map.put("code","500");
            map.put("id",faculty.getFacultyNO());
        }
        return map;
    }

    @ResponseBody
    @PostMapping("/faculty/deleteBatchIds")
    public HashMap<String, Object> deleteBatchIds(String ids){
        System.out.println(ids);

        JSON parse = JSONUtil.parse(ids);
        int count = facultyMapper.deleteBatchIds((Collection<? extends Serializable>) parse);
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

    @GetMapping("/faculty/facultyAdd")
    public String toUserAdd(){
        return "faculty/admin-add";
    }

    @ResponseBody
    @PostMapping("/faculty/facultyAdd")
    public HashMap<String, Object> facultyAdd(Faculty faculty){
        log.info(faculty.toString());

        int count = facultyMapper.insert(faculty);
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",faculty.getFacultyNO());
        } else {
            map.put("code","500");
            map.put("id",faculty.getFacultyNO());
        }
        return map;
    }

    @GetMapping("/faculty/facultyUpdate/{id}")
    public String toFacultyUpdate(@PathVariable("id") Integer id, Model model){
        Faculty t = facultyMapper.selectById(id);
        model.addAttribute("faculty",t);
        return "faculty/admin-update";
    }

    @ResponseBody
    @PostMapping("/faculty/facultyUpdate")
    public HashMap<String, Object> facultyUpdate(Faculty faculty){
        log.info(faculty.toString());

        int count = facultyMapper.updateById(faculty);
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",faculty.getFacultyNO());
        } else {
            map.put("code","500");
            map.put("id",faculty.getFacultyNO());
        }
        return map;
    }
}
