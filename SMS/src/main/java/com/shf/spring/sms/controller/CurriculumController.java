package com.shf.spring.sms.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shf.spring.sms.entity.*;
import com.shf.spring.sms.entity.Class;
import com.shf.spring.sms.mapper.CurriculumMapper;
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
public class CurriculumController {
    @Autowired
    private CurriculumMapper curriculumMapper;

    @Autowired
    private CourseController courseController;

    @Autowired
    private ClassController classController;

    @Autowired
    private TeacherController teacherController;

    @Autowired
    private LocationController locationController;

    @Autowired
    private ClassRoomController classRoomController;

    @ResponseBody
    @GetMapping("/curriculum/curriculumList")
    public List<Curriculum> toCurriculumList(){
        return curriculumMapper.selectList(null);
    }

    public Curriculum getCurriculumById(Integer id){
        return curriculumMapper.selectById(id);
    }
    
    
    @GetMapping("/curriculum/curriculumListPage")
    public String toCurriculumList(Model model){
        List<Curriculum> curriculumList = curriculumMapper.selectList(null);
        for (Curriculum curriculum : curriculumList) {
            curriculum.setCourseName(courseController.getCourseById(curriculum.getCourseNO()).getCourseName());
            curriculum.setName(teacherController.getTeacherById(curriculum.getTeacherID()).getName());
            curriculum.setLocationName(locationController.getLocationById(curriculum.getLocationNo()).getLocationName());
        }
        model.addAttribute("curriculumList",curriculumList);
        return "curriculum/admin-list";
    }

    @ResponseBody
    @PostMapping("/curriculum/deleteCurriculumById")
    public HashMap<String, Object> deleteCurriculumById(Curriculum curriculum){
        log.info(curriculum.toString());

        int count = curriculumMapper.deleteById(curriculum.getID());
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",curriculum.getID());
        } else {
            map.put("code","500");
            map.put("id",curriculum.getID());
        }
        return map;
    }

    @ResponseBody
    @PostMapping("/curriculum/deleteBatchIds")
    public HashMap<String, Object> deleteBatchIds(String ids){
        System.out.println(ids);

        JSON parse = JSONUtil.parse(ids);
        int count = curriculumMapper.deleteBatchIds((Collection<? extends Serializable>) parse);
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


    @GetMapping("/curriculum/curriculumAdd")
    public String toUserAdd(Model model){
        List<Course> courses = courseController.toCourseList();
        model.addAttribute("courseList",courses);
        List<Class> classes = classController.toClassList();
        model.addAttribute("classList",classes);
        List<Teacher> teachers = teacherController.teacherList();
        model.addAttribute("teacherList",teachers);
        List<Location> locations = locationController.locationList();
        model.addAttribute("locationList",locations);
        List<ClassRoom> classRooms = classRoomController.toClassRoomList();
        model.addAttribute("classRoomList",classRooms);
        return "curriculum/admin-add";
    }

    @ResponseBody
    @PostMapping("/curriculum/curriculumAdd")
    public HashMap<String, Object> curriculumAdd(Curriculum curriculum){
        log.info(curriculum.toString());

        int count = curriculumMapper.insert(curriculum);
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",curriculum.getID());
        } else {
            map.put("code","500");
            map.put("id",curriculum.getID());
        }
        return map;
    }

    @GetMapping("/curriculum/curriculumUpdate/{id}")
    public String toCurriculumUpdate(@PathVariable("id") Integer id, Model model){
        List<Course> courses = courseController.toCourseList();
        model.addAttribute("courseList",courses);
        List<Class> classes = classController.toClassList();
        model.addAttribute("classList",classes);
        List<Teacher> teachers = teacherController.teacherList();
        model.addAttribute("teacherList",teachers);
        List<Location> locations = locationController.locationList();
        model.addAttribute("locationList",locations);
        List<ClassRoom> classRooms = classRoomController.toClassRoomList();
        model.addAttribute("classRoomList",classRooms);
        Curriculum t = curriculumMapper.selectById(id);
        model.addAttribute("curriculum",t);
        return "curriculum/admin-update";
    }

    @ResponseBody
    @PostMapping("/curriculum/curriculumUpdate")
    public HashMap<String, Object> curriculumUpdate(Curriculum curriculum){
        log.info(curriculum.toString());

        int count = curriculumMapper.updateById(curriculum);
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",curriculum.getID());
        } else {
            map.put("code","500");
            map.put("id",curriculum.getID());
        }
        return map;
    }

    @ResponseBody
    @GetMapping("/curriculum/isAvailableID")
    public HashMap<String, Object> isAvailableID(Curriculum curriculum){
        Curriculum byId = curriculumMapper.selectById(curriculum.getID());
        HashMap<String, Object> map = new HashMap<>();
        if (byId == null){
            map.put("code","100");
            map.put("id",curriculum.getID());
        } else {
            map.put("code","500");
            map.put("id",curriculum.getID());
        }
        return map;
    }
    @GetMapping("/curriculum/myCurriculumPage")
    public String myCurriculumPage(Model model){
        List<Curriculum> distinct_teacherID = curriculumMapper.selectList(
                new QueryWrapper<Curriculum>()
                        .select("distinct teacherID")
                        .orderByAsc("teacherID")
        );
        for (Curriculum curriculum : distinct_teacherID) {
            curriculum.setName(teacherController.getTeacherById(curriculum.getTeacherID()).getName());
        }
        model.addAttribute("distinctTeacherID",distinct_teacherID);
        List<Curriculum> distinct_schoolYear = curriculumMapper.selectList(
                new QueryWrapper<Curriculum>()
                        .select("distinct schoolYear")
                        .orderByAsc("schoolYear")
        );
        model.addAttribute("distinctSchoolYear",distinct_schoolYear);
        List<Curriculum> distinct_classNO = curriculumMapper.selectList(
                new QueryWrapper<Curriculum>()
                        .select("distinct classNO")
                        .orderByAsc("classNO")
        );
        model.addAttribute("distinctClassNO",distinct_classNO);
        return "curriculum/curriculum";
    }

    @ResponseBody
    @GetMapping("/curriculum/myCurriculum")
    public HashMap<String, Object> myCurriculum(Curriculum curriculum){
        log.info(String.valueOf(curriculum));
        List<Curriculum> curriculumList = null;
        if (curriculum.getClassNO()==404 && curriculum.getTeacherID()==404){
            curriculumList = curriculumMapper.selectList(
                    new QueryWrapper<Curriculum>()
                            .eq("schoolYear",curriculum.getSchoolYear())
                            .eq("term",curriculum.getTerm())
            );
        } else if (curriculum.getClassNO()==404){
            curriculumList = curriculumMapper.selectList(
                    new QueryWrapper<Curriculum>()
                            .eq("teacherID",curriculum.getTeacherID())
                            .eq("schoolYear",curriculum.getSchoolYear())
                            .eq("term",curriculum.getTerm())
            );
        } else if(curriculum.getTeacherID()==404){
            curriculumList = curriculumMapper.selectList(
                    new QueryWrapper<Curriculum>()
                            .eq("schoolYear",curriculum.getSchoolYear())
                            .eq("term",curriculum.getTerm())
                            .eq("classNO",curriculum.getClassNO())
            );
        } else {
            curriculumList = curriculumMapper.selectList(
                    new QueryWrapper<Curriculum>()
                            .eq("teacherID",curriculum.getTeacherID())
                            .eq("schoolYear",curriculum.getSchoolYear())
                            .eq("term",curriculum.getTerm())
                            .eq("classNO",curriculum.getClassNO())
            );
        }

        HashMap<String, Object> map = new HashMap<>();
        if (curriculumList.size() > 0){
            map.put("code","100");
            for (Curriculum c : curriculumList) {
                c.setCourseName(courseController.getCourseById(c.getCourseNO()).getCourseName());
                c.setName(teacherController.getTeacherById(c.getTeacherID()).getName());
                c.setLocationName(locationController.getLocationById(c.getLocationNo()).getLocationName());
            }
            map.put("curriculumList",curriculumList);
        } else {
            map.put("code","500");
            map.put("id",curriculum.getID());
        }
        return map;
    }
}
