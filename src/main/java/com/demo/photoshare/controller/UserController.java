package com.demo.photoshare.controller;


import com.demo.photoshare.common.JsonBean;
import com.demo.photoshare.entity.User;
import com.demo.photoshare.service.UserService;
import com.demo.photoshare.utils.JsonBeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Random;

@Api(value = "用户",tags = "用户相关操作")
@Controller
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "新增用户",notes = "用户注册,记得验空")
    @PostMapping("/usr/register.do")
    @ResponseBody
    public JsonBean Register(String uname, String pwd) {
        JsonBean bean = null;

        try {
            userService.register(uname,pwd);
            bean = JsonBeanUtils.createJsonBean(1,null);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }

    @ApiOperation(value = "登录",notes = "实现用户的登录，记得验空")
    @PostMapping("/usr/login.do")
    @ResponseBody
    public JsonBean Login(String uname, String pwd) {
        JsonBean bean = null;

        /*Integer randomNum = (int)(Math.random()*900)+100;
        String token = String.valueOf(System.currentTimeMillis()) + randomNum;*/


        try {
            User user = userService.login(uname,pwd);
            bean = JsonBeanUtils.createJsonBean(1,user);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }

    /*@ApiOperation(value = "退出登录",notes = "用户退出登录")
    @GetMapping("/usr/out.do")
    @ResponseBody
    public JsonBean LoginOut() {
        JsonBean bean = null;
        if (user != null) {
            session.removeAttribute("user");
            bean = JsonBeanUtils.createJsonBean(1, null);
        } else {
            bean = JsonBeanUtils.createJsonBean(0, "尚未登录");
        }
        return bean;
    }*/

}
