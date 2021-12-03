package com.shf.spring.sms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("class")
public class Class implements Serializable {
    @TableId
    private Integer classNO; //班号
    private Integer facultyNO; //院系

    @TableField(exist = false)
    private String facultyName; //院系名称
    private Integer classSize; // 班级人数
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date year;  // 入学年份
    private Integer counsellorNO;  // 辅导员

    @TableField(exist = false)
    private String counsellorName; //辅导员名称
}
