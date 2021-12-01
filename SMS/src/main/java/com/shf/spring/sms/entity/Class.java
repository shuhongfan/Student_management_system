package com.shf.spring.sms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("class")
public class Class implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer classNO; //班号
    private Integer facultyNO; //院系
    private Integer classSize; // 班级人数
    private Date year;  // 入学年份
    private Integer counsellorNO;  // 辅导员
}
