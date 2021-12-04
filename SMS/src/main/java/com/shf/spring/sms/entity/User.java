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
@TableName("user")
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;  //#ID
    private String username; //#用户名
    private String password;  //#密码
    private Integer type;  //#用户类型 0学生 1教师  2管理员
    private Integer disabled;  //#是否可用
    private Integer contrastStudentID; // 对应学生ID
    private Integer contrastTeacherID;  // 对应老师ID
    @TableField(exist = false)
    private String contrastStudentName; //对应学生姓名
    @TableField(exist = false)
    private String contrastTeacherName; //对应老师姓名
    @TableField(exist = false)
    private Integer classNO; //对应学生班级

    @TableField(exist = false)
    private String captcha; //验证码
}
