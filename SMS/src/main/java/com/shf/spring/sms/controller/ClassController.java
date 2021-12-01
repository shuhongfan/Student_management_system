package com.shf.spring.sms.controller;

import com.shf.spring.sms.entity.Class;
import com.shf.spring.sms.mapper.ClassMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
public class ClassController {
    @Autowired
    private ClassMapper classMapper;

    @ResponseBody
    @GetMapping("/class/classList")
    public List<Class> toClassList(){
        return classMapper.selectList(null);
    }

    public Class getClassById(Integer id){
        return classMapper.selectById(id);
    }
}
