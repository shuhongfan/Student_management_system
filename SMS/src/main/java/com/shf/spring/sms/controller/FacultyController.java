package com.shf.spring.sms.controller;

import com.shf.spring.sms.entity.Faculty;
import com.shf.spring.sms.mapper.FacultyMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
public class FacultyController {
    @Autowired
    private FacultyMapper facultyMapper;

    @ResponseBody
    @GetMapping("/faculty/facultyList")
    public List<Faculty> toFacultyList(){
        return facultyMapper.selectList(null);
    }

    public Faculty getFacultyById(Integer id){
        return facultyMapper.selectById(id);
    }
}
