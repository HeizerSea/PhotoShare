package com.demo.photoshare.controller;

import com.demo.photoshare.common.JsonBean;
import com.demo.photoshare.entity.User;
import com.demo.photoshare.entity.UserImg;
import com.demo.photoshare.service.FansService;
import com.demo.photoshare.utils.JsonBeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(value = "用户关注",tags = "用户关注相关")
@Controller
@CrossOrigin
public class FansController {

    @Autowired
    private FansService fansService;

    @ApiOperation(value = "用户关注",notes = "查询到用户的粉丝数据，返回粉丝的用户名")
    @PostMapping("/fan/findFAll.do")
    @ResponseBody
    public JsonBean findFAll(Integer userid){
        JsonBean bean = null;

        try {
            List<User> list = fansService.findFName(userid);
            bean = JsonBeanUtils.createJsonBean(1,list);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,null);
        }

        return bean;
    }

    @ApiOperation(value = "用户关注",notes = "查询到用户的关注数据，返回关注的用户名")
    @PostMapping("/fan/findSAll.do")
    @ResponseBody
    public JsonBean findSAll(Integer userid){
        JsonBean bean = null;

        try {
            List<User> list = fansService.findSName(userid);
            bean = JsonBeanUtils.createJsonBean(1,list);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,null);
        }

        return bean;
    }

    @ApiOperation(value = "用户关注",notes = "查询到用户的粉丝总数")
    @PostMapping("/fan/countF.do")
    @ResponseBody
    public JsonBean countF(Integer userid){
        JsonBean bean = null;

        try {
            int num = fansService.findFCount(userid);
            bean = JsonBeanUtils.createJsonBean(1,num);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,null);
        }

        return bean;
    }

    @ApiOperation(value = "用户关注",notes = "查询到用户的关注总数")
    @PostMapping("/fan/countS.do")
    @ResponseBody
    public JsonBean countS(Integer userid){
        JsonBean bean = null;

        try {
            int num = fansService.findSCount(userid);
            bean = JsonBeanUtils.createJsonBean(1,num);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,null);
        }

        return bean;
    }

    @ApiOperation(value = "用户关注",notes = "添加关注。参数说明：参数1为当前用户id，参数2为被关注用户的id")
    @PostMapping("/fan/add.do")
    @ResponseBody
    public JsonBean add(Integer fanuid,Integer staruid){
        JsonBean bean = null;

        try {
            fansService.add(fanuid,staruid);
            bean = JsonBeanUtils.createJsonBean(1,"关注成功");
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,null);
        }

        return bean;
    }

    @ApiOperation(value = "用户关注",notes = "取消关注。参数说明：参数1为当前用户id，参数2为被取消关注的用户的id")
    @PostMapping("/fan/delete.do")
    @ResponseBody
    public JsonBean Delete(Integer fanuid,Integer staruid){
        JsonBean bean = null;

        try {
            fansService.delete(fanuid,staruid);
            bean = JsonBeanUtils.createJsonBean(1,"取消关注成功");
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,null);
        }

        return bean;
    }
}
