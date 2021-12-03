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
@TableName("student")
public class Student implements Serializable {
    @TableId
    private Integer studentID; // 学号
    private String name; // 姓名
    private Integer sex; // 性别

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date birthday; //  出生日期
    private Integer facultyNO; // 院系

    @TableField(exist = false)
    private String facultyName;  //#院系名称
    private Integer classNO; // 班级
    private String address; //  家庭地址
    private String phone; //  联系电话
    private String remark; // 备注
}
