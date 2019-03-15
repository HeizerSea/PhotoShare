package com.demo.photoshare.controller;

import com.demo.photoshare.common.JsonBean;
import com.demo.photoshare.entity.UserImg;
import com.demo.photoshare.service.UserImgService;
import com.demo.photoshare.utils.JsonBeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(value = "图片",tags = "展示用户图片相关")
@Controller
@CrossOrigin
public class UserImgController {

    @Autowired
    private UserImgService userImgService;

    @ApiOperation(value = "展示用户图片",notes = "查询到用户分享的所有图片")
    @PostMapping("/img/findAll.do")
    @ResponseBody
    public JsonBean findAll(Integer userid){
        JsonBean bean = null;

        try {
            List<UserImg> list = userImgService.findByUid(userid);
            bean = JsonBeanUtils.createJsonBean(1,list);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,null);
        }

        return bean;
    }

    @ApiOperation(value = "查找图片",notes = "根据图片id查找图片")
    @PostMapping("/img/findByPid.do")
    @ResponseBody
    public JsonBean findByPid(Integer pid){
        JsonBean bean = null;

        try {
            UserImg userImg = userImgService.findByPid(pid);
            bean = JsonBeanUtils.createJsonBean(1,userImg);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,null);
        }

        return bean;
    }

    @ApiOperation(value = "删除图片",notes = "根据图片id和用户id删除图片，只能单张删除")
    @PostMapping("/img/del.do")
    @ResponseBody
    public JsonBean Delete(Integer uid, Integer pid){
        JsonBean bean = null;

        try {
            userImgService.delImg(uid,pid);
            bean = JsonBeanUtils.createJsonBean(1,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,null);
        }

        return bean;
    }
}
