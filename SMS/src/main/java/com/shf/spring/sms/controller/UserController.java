package com.shf.spring.sms.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shf.spring.sms.entity.Teacher;
import com.shf.spring.sms.entity.User;
import com.shf.spring.sms.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.*;

@Slf4j
@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user/userListPage")
    public String toUserList(Model model){
        List<User> userList = userMapper.selectList(null);
        model.addAttribute("userList",userList);
        return "user/admin-list";
    }

    @GetMapping("/user/userPage")
    public String userPage(User user,Model model){
        User u = userMapper.selectOne(new QueryWrapper<User>().eq("username",user.getUsername()));
        model.addAttribute("user",u);
        return "user/admin-list2";
    }

    @GetMapping("/user/userListPaging/{num}/{size}")
    @ResponseBody
    public Page<User> pagelist(@PathVariable("num") int num, @PathVariable("size") int size){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Page<User> page = new Page<>(num,size);
        System.out.println(page);
        return userMapper.selectPage(page,wrapper);
    }

    @ResponseBody
    @PostMapping("/user/stopUserById")
    public HashMap<String, Object> stopUserById(User user){
        log.info(user.toString());

        User u = new User();
        u.setId(user.getId());
        u.setDisabled(1);
        int count = userMapper.updateById(u);
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",user.getId());
        } else {
            map.put("code","500");
            map.put("id",user.getId());
        }
        return map;
    }

    @ResponseBody
    @PostMapping("/user/startUserById")
    public HashMap<String, Object> startUserById(User user){
        log.info(user.toString());

        User u = new User();
        u.setId(user.getId());
        u.setDisabled(0);
        int count = userMapper.updateById(u);
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",user.getId());
        } else {
            map.put("code","500");
            map.put("id",user.getId());
        }
        return map;
    }

    @ResponseBody
    @PostMapping("/user/deleteUserById")
    public HashMap<String, Object> deleteUserById(User user){
        log.info(user.toString());

        int count = userMapper.deleteById(user.getId());
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",user.getId());
        } else {
            map.put("code","500");
            map.put("id",user.getId());
        }
        return map;
    }

    @ResponseBody
    @PostMapping("/user/deleteBatchIds")
    public HashMap<String, Object> deleteBatchIds(String ids){
        System.out.println(ids);

        JSON parse = JSONUtil.parse(ids);
        int count = userMapper.deleteBatchIds((Collection<? extends Serializable>) parse);
        log.info(String.valueOf(count));
        HashMap<String, Object> map = new HashMap<>();
        if (count>=1){
            map.put("code","100");
            map.put("ids",ids);
        } else {
            map.put("code","500");
            map.put("ids",ids);
        }
        return map;
    }

    @GetMapping("/user/userAdd")
    public String toUserAdd(){
        return "user/admin-add";
    }

    @ResponseBody
    @PostMapping("/user/userAdd")
    public HashMap<String, Object> userAdd(User user){
        log.info(user.toString());

        int count = userMapper.insert(user);
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",user.getId());
        } else {
            map.put("code","500");
            map.put("id",user.getId());
        }
        return map;
    }

    @GetMapping("/user/userUpdate/{id}")
    public String toUserUpdate(@PathVariable("id") Integer id,Model model){
        User u = userMapper.selectById(id);
        model.addAttribute("user",u);
        return "user/admin-update";
    }

    @GetMapping("/user/userUpdatePassword/{id}")
    public String toUserUpdatePassword(@PathVariable("id") Integer id,Model model){
        User u = userMapper.selectById(id);
        model.addAttribute("user",u);
        return "user/admin-update2";
    }

    @ResponseBody
    @PostMapping("/user/userUpdate")
    public HashMap<String, Object> userUpdate(User user){
        log.info(user.toString());

        int count = userMapper.updateById(user);
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",user.getId());
        } else {
            map.put("code","500");
            map.put("id",user.getId());
        }
        return map;
    }

    @ResponseBody
    @PostMapping("/user/userUpdatePassword")
    public HashMap<String, Object> userUpdatePassword(User user){
        log.info(user.toString());

        int count = userMapper.update(user,new UpdateWrapper<User>()
                .set("password",user.getPassword())
                .eq("id",user.getId()));
        log.info(String.valueOf(count));

        HashMap<String, Object> map = new HashMap<>();
        if (count==1){
            map.put("code","100");
            map.put("id",user.getId());
        } else {
            map.put("code","500");
            map.put("id",user.getId());
        }
        return map;
    }

}
