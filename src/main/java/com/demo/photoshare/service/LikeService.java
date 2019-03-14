package com.demo.photoshare.service;

import com.demo.photoshare.vo.LikeVo;

import java.util.List;

public interface LikeService {

    /**
     *  添加点赞
     * @param uid
     * @param pid
     */
    public void add(Integer uid,Integer pid);

    /**
     *  取消点赞
     * @param uid
     * @param pid
     */
    public void delete(Integer uid,Integer pid);

    /**
     * 根据图片Id查询出点赞的用户名
     * @param pid
     * @return
     */
    public List<LikeVo> findNameByPid(Integer pid);

    /**
     * 根据图片Id查询出点赞总数
     * @param pid
     * @return
     */
    public LikeVo findCountByPid(Integer pid);
}
