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
@TableName("classroom")
public class ClassRoom implements Serializable {
    @TableId
    private Integer classRoomNO; // 教室编号
    private Integer capacity;  // 容量
    private Integer isMultimedia;  //  是否多媒体教室
    private Integer state;  //  教室状态
    private Integer locationNo; // 地点

    @TableField(exist = false)
    private String locationName; //验证码
}
