package com.demo.photoshare.service.impl;

import com.demo.photoshare.dao.ImgReviewMapper;
import com.demo.photoshare.entity.ImgReview;
import com.demo.photoshare.service.ReviewService;
import com.demo.photoshare.vo.ReviewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ImgReviewMapper reviewDao;

    @Override
    public List<ReviewVo> findByPid(Integer pid) {
        List<ReviewVo> list = reviewDao.selectByPid(pid);
        return list;
    }

    @Override
    public Integer findCountByPid(Integer pid) {

        return reviewDao.findCountByPid(pid).getCountNum();
    }

    @Override
    public void addReview(Integer uid, Integer pid, String content) {

        ImgReview review = new ImgReview();
        review.setReUserId(uid);
        review.setRePicId(pid);
        review.setContent(content);

        reviewDao.insertSelective(review);
    }

    @Override
    public void delReview(Integer uid, Integer pid) {
        ImgReview review = new ImgReview();
        review.setReUserId(uid);
        review.setRePicId(pid);

        reviewDao.delReview(review);
    }
}
