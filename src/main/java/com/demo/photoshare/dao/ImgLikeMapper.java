package com.demo.photoshare.dao;

import com.demo.photoshare.entity.ImgLike;
import com.demo.photoshare.vo.LikeVo;

import java.util.List;

public interface ImgLikeMapper {
    int deleteByPrimaryKey(Integer liId);

    int insert(ImgLike record);

    /**
     * 添加点赞
     * @param record
     * @return
     */
    int insertSelective(ImgLike record);

    ImgLike selectByPrimaryKey(Integer liId);

    int updateByPrimaryKeySelective(ImgLike record);

    int updateByPrimaryKey(ImgLike record);

    /**
     * 取消点赞
     * @param record
     */
    void delLike(ImgLike record);

    /**
     * 根据图片id查询出所有的点赞的用户名
     * @return
     */
    List<LikeVo> selectByPid(Integer pid);

    /**
     * 根据图片Id查询出点赞总数
     * @param pid
     * @return
     */
    LikeVo findCountByPid(Integer pid);
}