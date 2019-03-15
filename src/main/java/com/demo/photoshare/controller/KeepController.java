package com.demo.photoshare.controller;

import com.demo.photoshare.common.JsonBean;
import com.demo.photoshare.entity.User;
import com.demo.photoshare.entity.UserImg;
import com.demo.photoshare.service.KeepService;
import com.demo.photoshare.utils.JsonBeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(value = "收藏",tags = "用户图片收藏相关")
@Controller
@CrossOrigin
public class KeepController {

    @Autowired
    private KeepService keepService;

    @ApiOperation(value = "图片收藏",notes = "图片收藏相关数据，返回收藏该图片的用户名")
    @PostMapping("/keep/findAll.do")
    @ResponseBody
    public JsonBean findAll(Integer pid){
        JsonBean bean = null;

        try {
            List<User> list = keepService.findNameByPid(pid);
            bean = JsonBeanUtils.createJsonBean(1,list);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,null);
        }

        return bean;
    }

    @ApiOperation(value = "图片收藏",notes = "图片收藏总数")
    @PostMapping("/keep/count.do")
    @ResponseBody
    public JsonBean Count(Integer pid){
        JsonBean bean = null;

        try {
            int num = keepService.findCount(pid);
            bean = JsonBeanUtils.createJsonBean(1,num);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,null);
        }

        return bean;
    }

    @ApiOperation(value = "图片收藏",notes = "返回用户收藏的图片的url")
    @PostMapping("/keep/findKeep.do")
    @ResponseBody
    public JsonBean findKeep(Integer uid){
        JsonBean bean = null;

        try {
            List<UserImg> list = keepService.findUrlByUid(uid);
            bean = JsonBeanUtils.createJsonBean(1,list);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,null);
        }

        return bean;
    }

    @ApiOperation(value = "图片收藏",notes = "取消图片收藏")
    @PostMapping("/keep/delete.do")
    @ResponseBody
    public JsonBean Delete(Integer uid,Integer pid){
        JsonBean bean = null;

        try {
            keepService.delete(uid,pid);
            bean = JsonBeanUtils.createJsonBean(1,"取消收藏成功");
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,null);
        }

        return bean;
    }

    @ApiOperation(value = "图片收藏",notes = "添加图片收藏")
    @PostMapping("/keep/add.do")
    @ResponseBody
    public JsonBean add(Integer uid,Integer pid){
        JsonBean bean = null;

        try {
            keepService.add(uid,pid);
            bean = JsonBeanUtils.createJsonBean(1,"收藏成功");
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,null);
        }

        return bean;
    }
}
