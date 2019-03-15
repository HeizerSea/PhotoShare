package com.demo.photoshare.service.impl;

import com.demo.photoshare.dao.UserImgMapper;
import com.demo.photoshare.entity.UserImg;
import com.demo.photoshare.service.UserImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImgServiceImpl implements UserImgService {

    @Autowired
    private UserImgMapper userImgDao;

    @Override
    public void saveUploadFile(String fileName,String pictitle,String desc,Integer userid) {

       /* //获取本机IP
        String host = null;
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e.getMessage());
        }*/
        UserImg userImg = new UserImg();
        userImg.setImgUid(userid);
        userImg.setUrl("/photo/" + fileName);
        userImg.setPictitle(pictitle);
        userImg.setImgdesc(desc);

        userImgDao.insertSelective(userImg);

        System.out.println("filePhotoUrl:" + userImg.getUrl());
    }

    @Override
    public List<UserImg> findByUid(Integer uid) {
        List<UserImg> list = userImgDao.selectByUid(uid);
        return list;
    }

    @Override
    public UserImg findByPid(Integer pid) {

        UserImg userImg = userImgDao.selectByPrimaryKey(pid);
        return userImg;
    }

    @Override
    public void delImg(Integer uid, Integer pid) {
        UserImg img = new UserImg();
        img.setImgUid(uid);
        img.setPicid(pid);

        userImgDao.delImg(img);
    }
}
