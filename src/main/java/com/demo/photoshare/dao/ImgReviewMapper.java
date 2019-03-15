package com.demo.photoshare.dao;

import com.demo.photoshare.entity.ImgReview;
import com.demo.photoshare.vo.ReviewVo;

import java.util.List;

public interface ImgReviewMapper {
    int deleteByPrimaryKey(Integer reId);

    int insert(ImgReview record);

    /**
     *  添加评论
     * @param record
     * @return
     */
    int insertSelective(ImgReview record);

    ImgReview selectByPrimaryKey(Integer reId);

    int updateByPrimaryKeySelective(ImgReview record);

    int updateByPrimaryKey(ImgReview record);

    /**
     *  根据图片id查询出相关的评论人，评论内容
     * @param pid
     * @return
     */
    List<ReviewVo> selectByPid(Integer pid);

    /**
     *  根据图片Id查询出它的评论总数
     * @param pid
     * @return
     */
    ReviewVo findCountByPid(Integer pid);

    /**
     *  删除评论
     * @param record
     */
    void delReview(ImgReview record);

}