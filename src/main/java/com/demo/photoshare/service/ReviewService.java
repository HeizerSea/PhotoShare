package com.demo.photoshare.service;

import com.demo.photoshare.vo.ReviewVo;

import java.util.List;

public interface ReviewService {

    /**
     *  根据图片id查询出相关的评论信息
     * @return
     */
    public List<ReviewVo> findByPid(Integer pid);

    /**
     * 根据图片Id查询出它的评论总数
     * @param pid
     * @return
     */
    public Integer findCountByPid(Integer pid);

    /**
     * 添加评论
     */
    public void addReview(Integer uid, Integer pid, String content);

    /**
     *  删除用户自己的评论
     * @param uid
     * @param pid
     */
    public void delReview(Integer uid,Integer pid);
}
