package com.demo.photoshare.controller;

import com.demo.photoshare.common.JsonBean;
import com.demo.photoshare.service.UserImgService;
import com.demo.photoshare.utils.FileUtils;
import com.demo.photoshare.utils.JsonBeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Api(value = "图片",tags = "用户图片上传相关")
@Controller
@CrossOrigin
public class FileUploadController {

    @Autowired
    private UserImgService userImgService;

    @Value("${web.upload-path}")
    private String path;

    @ApiOperation(value = "用户分享图片",notes = "用户图片分享")
    @PostMapping("/img/fileUpload.do")
    @ResponseBody
    public JsonBean upload(@RequestParam("fileName") MultipartFile file, String pictitle, String desc, Integer userid){
        JsonBean bean = null;

        // 要上传的目标文件存放路径
        String localPath = "/www/photo";
        //String localPath = "D:/photo";

        try {
            String name = FileUtils.upload(file, localPath, file.getOriginalFilename());
            System.out.println(name);
            userImgService.saveUploadFile(name,pictitle,desc,userid);
            // 上传成功，给出页面提示
            bean = JsonBeanUtils.createJsonBean(1,"上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonBeanUtils.createJsonBean(0,"上传失败");
        }

        return bean;
    }
}
