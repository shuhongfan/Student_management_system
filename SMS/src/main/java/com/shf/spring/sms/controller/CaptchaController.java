package com.shf.spring.sms.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@Slf4j
public class CaptchaController {
    public final static String SESSION_KEY_IMAGE_CODE = "SESSION_KEY_IMAGE_CODE";

    @GetMapping("/captcha")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置response响应
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //定义图形验证码的长、宽、验证码字符数、干扰元素个数
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(100, 38, 4, 20);
        System.out.println(captcha.getCode());
        //将验证码放到HttpSession里面
        request.getSession().setAttribute(SESSION_KEY_IMAGE_CODE, captcha.getCode());
        log.info("本次生成的验证码为：" + captcha.getCode() + ",已存放到HttpSession中");

        //图形验证码写出，可以写出到文件，也可以写出到流
        //输出浏览器
        OutputStream out = response.getOutputStream();
        captcha.write(out);
        out.flush();
        out.close();
    }
}
