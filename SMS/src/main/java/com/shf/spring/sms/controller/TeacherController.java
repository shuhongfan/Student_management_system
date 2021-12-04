package com.shf.spring.sms.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shf.spring.sms.entity.*;
import com.shf.spring.sms.entity.Class;
import com.shf.spring.sms.mapper.FacultyMapper;
import com.shf.spring.sms.mapper.TeacherMapper;
import com.shf.spring.sms.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
public class TeacherController {
    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private FacultyController facultyController;

    @ResponseBody
    @GetMapping("/teacher/isAvailableTeacherNO")
    public HashMap<String, Object> isAvailableTeacherNO(Teacher teacher){
        Teacher room = teacherMapper.selectById(teacher.getTeacherID());
        HashMap<String, Object> map = new HashMap<>();
        if (room == null){
            map.put("code","100");
            map.put("id",teacher.getTeacherID());
        } else {
            map.put("code","500");
            map.put("id",teacher.getTeacherID());
        }
        return map;
    }

    public Teacher getTeacherById(Integer id){
        return teacherMapper.selectById(id);
    }

    public List<Teacher> teacherList(){
        return teacherMapper.selectList(null);
    }

    @GetMapping("/teacher/teacherPage")
    public String teacherPage(Teacher teacher,Model model){
        ArrayList<Teacher> teachers = new ArrayList<>();
        Teacher s = teacherMapper.selectById(teacher.getTeacherID());
        s.setFacultyName(facultyController.getFacultyById(s.getFacultyNO()).getFacultyName());
        teachers.add(s);
        model.addAttribute("teacherList",teachers);
        return "teacher/admin-list-public";
    }

    @GetMapping("/teacher/teacherListPage")
    public String toTeacherList(Model model){
        List<Teacher> teacherList = teacherMapper.selectList(null);
        for (Teacher teacher : teacherList) {
            teacher.setFacultyName(facultyController.getFacultyById(teacher.getFacultyNO()).getFacultyName());
        }
        model.addAttribute("teacherList",teacherList);
        return "teacher/admin-list";
    }

    @ResponseBody
    @PostMapping("/teacher/deleteTeacherById")
    public HashMap<String, Object> deleteTeacherById(Teacher teacher){
        log.info(teacher.toString());

        int count = teacherMapper.deleteById(teacher.getTeacherID());
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",teacher.getTeacherID());
        } else {
            map.put("code","500");
            map.put("id",teacher.getTeacherID());
        }
        return map;
    }

    @ResponseBody
    @PostMapping("/teacher/deleteBatchIds")
    public HashMap<String, Object> deleteBatchIds(String ids){
        System.out.println(ids);

        JSON parse = JSONUtil.parse(ids);
        int count = teacherMapper.deleteBatchIds((Collection<? extends Serializable>) parse);
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

    @GetMapping("/teacher/teacherAdd")
    public String totTeacherAdd(Model model){
        List<Faculty> facultyList = facultyController.toFacultyList();
        model.addAttribute("facultyList",facultyList);
        return "teacher/admin-add";
    }

    @ResponseBody
    @PostMapping("/teacher/teacherAdd")
    public HashMap<String, Object> teacherAdd(Teacher teacher){
        log.info(teacher.toString());

        int count = teacherMapper.insert(teacher);
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",teacher.getTeacherID());
        } else {
            map.put("code","500");
            map.put("id",teacher.getTeacherID());
        }
        return map;
    }

    @GetMapping("/teacher/teacherUpdate/{id}")
    public String toTeacherUpdate(@PathVariable("id") Integer id,Model model){
        List<Faculty> facultyList = facultyController.toFacultyList();
        model.addAttribute("facultyList",facultyList);
        Teacher t = teacherMapper.selectById(id);
        model.addAttribute("teacher",t);
        return "teacher/admin-update";
    }

    @ResponseBody
    @PostMapping("/teacher/teacherUpdate")
    public HashMap<String, Object> teacherUpdate(Teacher teacher){
        log.info(teacher.toString());

        int count = teacherMapper.updateById(teacher);
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",teacher.getTeacherID());
        } else {
            map.put("code","500");
            map.put("id",teacher.getTeacherID());
        }
        return map;
    }

}
