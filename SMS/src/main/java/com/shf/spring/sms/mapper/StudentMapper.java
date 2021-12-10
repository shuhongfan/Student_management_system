package com.shf.spring.sms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shf.spring.sms.entity.Location;
import com.shf.spring.sms.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper extends BaseMapper<Student> {
}
