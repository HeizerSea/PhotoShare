package com.demo.photoshare.controller;

import com.demo.photoshare.common.JsonBean;
import com.demo.photoshare.entity.User;
import com.demo.photoshare.service.ReviewService;
import com.demo.photoshare.utils.JsonBeanUtils;
import com.demo.photoshare.vo.ReviewVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(value = "图片评论",tags = "图片评论相关")
@Controller
@CrossOrigin
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @ApiOperation(value = "图片评论",notes = "图片评论相关数据，返回评论详情与用户名")
    @PostMapping("/re/reviewAll.do")
    @ResponseBody
    public JsonBean reviewAll(Integer pid) {
        JsonBean bean = null;

        try {
            List<ReviewVo> list = reviewService.findByPid(pid);
            bean = JsonBeanUtils.createJsonBean(1,list);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }

    @ApiOperation(value = "图片评论",notes = "图片评论总数")
    @PostMapping("/re/count.do")
    @ResponseBody
    public JsonBean Count(Integer pid) {
        JsonBean bean = null;

        try {
            int num = reviewService.findCountByPid(pid);
            bean = JsonBeanUtils.createJsonBean(1,num);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }

    @ApiOperation(value = "图片评论",notes = "添加评论")
    @PostMapping("/re/add.do")
    @ResponseBody
    public JsonBean Add(Integer uid, Integer pid, String content) {
        JsonBean bean = null;

        try {
            reviewService.addReview(uid,pid,content);
            bean = JsonBeanUtils.createJsonBean(1,"添加评论成功");
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }

    @ApiOperation(value = "图片评论",notes = "删除评论,只能删除用户自己的评论信息")
    @PostMapping("/re/del.do")
    @ResponseBody
    public JsonBean Delete(Integer uid, Integer pid) {
        JsonBean bean = null;

        try {
            reviewService.delReview(uid,pid);
            bean = JsonBeanUtils.createJsonBean(1,"删除评论成功");
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }
}
