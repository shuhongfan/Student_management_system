package com.shf.spring.sms.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.shf.spring.sms.entity.Course;
import com.shf.spring.sms.entity.Course;
import com.shf.spring.sms.mapper.CourseMapper;
import com.shf.spring.sms.mapper.CourseMapper;
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
public class CourseController {
    @Autowired
    private CourseMapper courseMapper;

    @ResponseBody
    @GetMapping("/course/isAvailableCourseNO")
    public HashMap<String, Object> isAvailableCourseNO(Course course){
        Course room = courseMapper.selectById(course.getCourseID());
        HashMap<String, Object> map = new HashMap<>();
        if (room == null){
            map.put("code","100");
            map.put("id",course.getCourseID());
        } else {
            map.put("code","500");
            map.put("id",course.getCourseID());
        }
        return map;
    }
    
    @ResponseBody
    @GetMapping("/course/courseList")
    public List<Course> toCourseList(){
        return courseMapper.selectList(null);
    }

    public Course getCourseById(Integer id){
        return courseMapper.selectById(id);
    }
    
    @GetMapping("/course/courseListPage")
    public String toCourseList(Model model){
        List<Course> courseList = courseMapper.selectList(null);
        model.addAttribute("courseList",courseList);
        return "course/admin-list";
    }

    @ResponseBody
    @PostMapping("/course/deleteCourseById")
    public HashMap<String, Object> deleteCourseById(Course course){
        log.info(course.toString());

        int count = courseMapper.deleteById(course.getCourseID());
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",course.getCourseID());
        } else {
            map.put("code","500");
            map.put("id",course.getCourseID());
        }
        return map;
    }

    @ResponseBody
    @PostMapping("/course/deleteBatchIds")
    public HashMap<String, Object> deleteBatchIds(String ids){
        System.out.println(ids);

        JSON parse = JSONUtil.parse(ids);
        int count = courseMapper.deleteBatchIds((Collection<? extends Serializable>) parse);
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

    @GetMapping("/course/courseAdd")
    public String toUserAdd(){
        return "course/admin-add";
    }

    @ResponseBody
    @PostMapping("/course/courseAdd")
    public HashMap<String, Object> courseAdd(Course course){
        log.info(course.toString());

        int count = courseMapper.insert(course);
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",course.getCourseID());
        } else {
            map.put("code","500");
            map.put("id",course.getCourseID());
        }
        return map;
    }

    @GetMapping("/course/courseUpdate/{id}")
    public String toCourseUpdate(@PathVariable("id") Integer id, Model model){
        Course c = courseMapper.selectById(id);
        model.addAttribute("course",c);
        return "course/admin-update";
    }

    @ResponseBody
    @PostMapping("/course/courseUpdate")
    public HashMap<String, Object> courseUpdate(Course course){
        log.info(course.toString());

        int count = courseMapper.updateById(course);
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",course.getCourseID());
        } else {
            map.put("code","500");
            map.put("id",course.getCourseID());
        }
        return map;
    }
}
