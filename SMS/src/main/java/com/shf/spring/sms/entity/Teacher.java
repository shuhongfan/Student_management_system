package com.shf.spring.sms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("teacher")
public class Teacher implements Serializable {
    @TableId
    private Integer teacherID; // 教工编号
    private String name;  // 姓名
    private Integer facultyNO; // 院系

    @TableField(exist = false)
    private String facultyName;  //#院系名称
    private String speciality; // 专业方向
    private String title; // 职称
}
