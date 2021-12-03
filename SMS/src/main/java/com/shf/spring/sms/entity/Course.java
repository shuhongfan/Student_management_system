package com.shf.spring.sms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("course")
public class Course implements Serializable {
    @TableId
    private Integer courseID; //#课程ID
    private String courseName;  //#课程名
    private Integer hour; //# 学时
    private Double credit;//# 学分
}
