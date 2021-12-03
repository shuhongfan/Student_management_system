package com.shf.spring.sms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("curriculum")
public class Curriculum implements Serializable { // 课程
    @TableId
    private Integer ID; // 排课ID
    private Integer courseNO;  // 课程号

    @TableField(exist = false)
    private String courseName;  //#课程名

    private Integer classNO;  // 班级号
    private Integer teacherID;  // 授课教师编号

    @TableField(exist = false)
    private String name;  // 姓名

    private Integer schoolYear; // 学年
    private Integer term; // 学期
    private Integer startWeek;  // 第几周开始
    private Integer endWeek;  // 第几周结束
    private Integer weekday; // 星期几
    private Integer section; // 第几节
    private Integer locationNo; // 地点

    @TableField(exist = false)
    private String locationName;  // 地点名称
    private Integer classRoomNO; // 教室
}
