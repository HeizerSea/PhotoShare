package com.demo.photoshare.controller;

import com.demo.photoshare.common.JsonBean;
import com.demo.photoshare.service.LikeService;
import com.demo.photoshare.utils.JsonBeanUtils;
import com.demo.photoshare.vo.LikeVo;
import com.demo.photoshare.vo.ReviewVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(value = "图片点赞",tags = "图片点赞相关")
@Controller
@CrossOrigin
public class LikeController {

    @Autowired
    private LikeService likeService;

    @ApiOperation(value = "图片点赞",notes = "图片点赞相关数据，返回点赞该图片的用户名")
    @PostMapping("/like/likeAll.do")
    @ResponseBody
    public JsonBean likeAll(Integer pid) {
        JsonBean bean = null;

        try {
            List<LikeVo> list = likeService.findNameByPid(pid);
            bean = JsonBeanUtils.createJsonBean(1,list);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }

    @ApiOperation(value = "图片点赞",notes = "图片点赞总数")
    @PostMapping("/like/count.do")
    @ResponseBody
    public JsonBean Count(Integer pid) {
        JsonBean bean = null;

        try {
            LikeVo likeVo = likeService.findCountByPid(pid);
            bean = JsonBeanUtils.createJsonBean(1,likeVo.getCount());
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }

    @ApiOperation(value = "图片点赞",notes = "添加图片点赞")
    @PostMapping("/like/add.do")
    @ResponseBody
    public JsonBean add(Integer uid, Integer pid) {
        JsonBean bean = null;

        try {
            likeService.add(uid,pid);
            bean = JsonBeanUtils.createJsonBean(1,"点赞成功");
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }

    @ApiOperation(value = "图片点赞",notes = "取消图片点赞")
    @PostMapping("/like/delete.do")
    @ResponseBody
    public JsonBean Delete(Integer uid, Integer pid) {
        JsonBean bean = null;

        try {
            likeService.delete(uid,pid);
            bean = JsonBeanUtils.createJsonBean(1,"取消点赞成功");
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }
}
