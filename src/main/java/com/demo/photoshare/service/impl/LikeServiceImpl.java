package com.demo.photoshare.service.impl;

import com.demo.photoshare.dao.ImgLikeMapper;
import com.demo.photoshare.entity.ImgLike;
import com.demo.photoshare.service.LikeService;
import com.demo.photoshare.vo.LikeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private ImgLikeMapper likeDao;

    @Override
    public void add(Integer uid, Integer pid) {
        ImgLike like = new ImgLike();
        like.setLiUserId(uid);
        like.setLiPicId(pid);

        likeDao.insertSelective(like);
    }

    @Override
    public void delete(Integer uid, Integer pid) {
        ImgLike like = new ImgLike();
        like.setLiUserId(uid);
        like.setLiPicId(pid);

        likeDao.delLike(like);
    }

    @Override
    public List<LikeVo> findNameByPid(Integer pid) {

        return likeDao.selectByPid(pid);
    }

    @Override
    public LikeVo findCountByPid(Integer pid) {
        return likeDao.findCountByPid(pid);
    }
}
