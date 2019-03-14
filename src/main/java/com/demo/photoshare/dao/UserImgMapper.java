package com.demo.photoshare.dao;

import com.demo.photoshare.entity.UserImg;

import java.util.List;

public interface UserImgMapper {
    int deleteByPrimaryKey(Integer picid);

    int insert(UserImg record);

    int insertSelective(UserImg record);

    UserImg selectByPrimaryKey(Integer picid);

    int updateByPrimaryKeySelective(UserImg record);

    int updateByPrimaryKey(UserImg record);

    /**
     *  根据用户Id查询出其所上传的所有图片
     * @param uid
     * @return
     */
    List<UserImg> selectByUid(Integer uid);

    /**
     *  用户删除上传的图片
     * @param record
     */
    void delImg(UserImg record);
}