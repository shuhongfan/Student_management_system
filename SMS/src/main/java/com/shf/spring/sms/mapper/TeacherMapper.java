package com.shf.spring.sms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shf.spring.sms.entity.Student;
import com.shf.spring.sms.entity.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherMapper extends BaseMapper<Teacher> {
}
