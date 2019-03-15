package com.demo.photoshare.service.impl;

import com.demo.photoshare.dao.ImgKeepMapper;
import com.demo.photoshare.dao.ImgLikeMapper;
import com.demo.photoshare.entity.ImgKeep;
import com.demo.photoshare.entity.User;
import com.demo.photoshare.entity.UserImg;
import com.demo.photoshare.service.KeepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeepServiceImpl implements KeepService {

    @Autowired
    private ImgKeepMapper keepDao;

    @Override
    public void add(Integer uid, Integer pid) {
        ImgKeep keep = new ImgKeep();
        keep.setKeepUserId(uid);
        keep.setKeepPicId(pid);

        keepDao.insertSelective(keep);
    }

    @Override
    public void delete(Integer uid, Integer pid) {
        ImgKeep keep = new ImgKeep();
        keep.setKeepUserId(uid);
        keep.setKeepPicId(pid);

        keepDao.delKeep(keep);
    }

    @Override
    public List<User> findNameByPid(Integer pid) {
        return keepDao.selectByPid(pid);
    }

    @Override
    public int findCount(Integer pid) {
        return keepDao.selectCountByPid(pid);
    }

    @Override
    public List<UserImg> findUrlByUid(Integer uid) {
        return keepDao.selectUrlByUid(uid);
    }
}
