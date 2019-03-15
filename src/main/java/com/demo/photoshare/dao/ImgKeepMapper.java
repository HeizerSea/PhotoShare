package com.demo.photoshare.dao;

import com.demo.photoshare.entity.ImgKeep;
import com.demo.photoshare.entity.User;
import com.demo.photoshare.entity.UserImg;

import java.util.List;

public interface ImgKeepMapper {
    int deleteByPrimaryKey(Integer keepId);

    int insert(ImgKeep record);

    /**
     *  添加收藏
     * @param record
     * @return
     */
    int insertSelective(ImgKeep record);

    ImgKeep selectByPrimaryKey(Integer keepId);

    int updateByPrimaryKeySelective(ImgKeep record);

    int updateByPrimaryKey(ImgKeep record);

    /**
     *  取消收藏
     * @param record
     */
    void delKeep(ImgKeep record);

    /**
     * 根据图片id查询出所有收藏该图片的用户名
     * @return
     */
    List<User> selectByPid(Integer pid);

    /**
     *  根据图片id查询出所有收藏该图片的用户总数
     * @param pid
     * @return
     */
    int selectCountByPid(Integer pid);

    /**
     * 根据用户Id查询出该用户收藏的所有图片
     * @param uid
     * @return
     */
    List<UserImg> selectUrlByUid(Integer uid);
}