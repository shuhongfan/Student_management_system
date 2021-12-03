package com.shf.spring.sms.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.shf.spring.sms.entity.*;
import com.shf.spring.sms.entity.Class;
import com.shf.spring.sms.mapper.ClassMapper;
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
public class ClassController {
    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private FacultyController facultyController;

    @Autowired
    private TeacherController teacherController;

    @ResponseBody
    @GetMapping("/class/isAvailableClassNO")
    public HashMap<String, Object> isAvailableID(Class classes){
        Class aClass = classMapper.selectById(classes.getClassNO());
        HashMap<String, Object> map = new HashMap<>();
        if (aClass == null){
            map.put("code","100");
            map.put("id",classes.getClassNO());
        } else {
            map.put("code","500");
            map.put("id",classes.getClassNO());
        }
        return map;
    }

    @ResponseBody
    @GetMapping("/class/classList")
    public List<Class> toClassList(){
        return classMapper.selectList(null);
    }

    public Class getClassById(Integer id){
        return classMapper.selectById(id);
    }

    @GetMapping("/class/classListPage")
    public String toClassList(Model model){
        List<Class> classList = classMapper.selectList(null);
        for (Class classes : classList) {
            classes.setFacultyName(facultyController.getFacultyById(classes.getFacultyNO()).getFacultyName());
            classes.setCounsellorName(teacherController.getTeacherById(classes.getCounsellorNO()).getName());
        }
        model.addAttribute("classList",classList);
        return "class/admin-list";
    }

    @ResponseBody
    @PostMapping("/class/deleteClassById")
    public HashMap<String, Object> deleteClassById(Class classes){
        log.info(classes.toString());

        int count = classMapper.deleteById(classes.getClassNO());
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",classes.getClassNO());
        } else {
            map.put("code","500");
            map.put("id",classes.getClassNO());
        }
        return map;
    }

    @ResponseBody
    @PostMapping("/class/deleteBatchIds")
    public HashMap<String, Object> deleteBatchIds(String ids){
        System.out.println(ids);

        JSON parse = JSONUtil.parse(ids);
        int count = classMapper.deleteBatchIds((Collection<? extends Serializable>) parse);
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

    @GetMapping("/class/classAdd")
    public String toUserAdd(Model model){
        List<Teacher> teachers = teacherController.teacherList();
        model.addAttribute("teacherList",teachers);
        List<Faculty> facultyList = facultyController.toFacultyList();
        model.addAttribute("facultyList",facultyList);
        return "class/admin-add";
    }

    @ResponseBody
    @PostMapping("/class/classAdd")
    public HashMap<String, Object> classAdd(Class classes){
        log.info(classes.toString());

        int count = classMapper.insert(classes);
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",classes.getClassNO());
        } else {
            map.put("code","500");
            map.put("id",classes.getClassNO());
        }
        return map;
    }

    @GetMapping("/class/classUpdate/{id}")
    public String toClassUpdate(@PathVariable("id") Integer id, Model model){
        List<Teacher> teachers = teacherController.teacherList();
        model.addAttribute("teacherList",teachers);
        List<Faculty> facultyList = facultyController.toFacultyList();
        model.addAttribute("facultyList",facultyList);
        Class t = classMapper.selectById(id);
        model.addAttribute("class",t);
        return "class/admin-update";
    }

    @ResponseBody
    @PostMapping("/class/classUpdate")
    public HashMap<String, Object> classUpdate(Class classes){
        log.info(classes.toString());

        int count = classMapper.updateById(classes);
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",classes.getClassNO());
        } else {
            map.put("code","500");
            map.put("id",classes.getClassNO());
        }
        return map;
    }
}
