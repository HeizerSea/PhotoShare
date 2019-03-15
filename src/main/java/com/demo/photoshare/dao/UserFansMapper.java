package com.demo.photoshare.dao;

import com.demo.photoshare.entity.User;
import com.demo.photoshare.entity.UserFans;

import java.util.List;

public interface UserFansMapper {
    int deleteByPrimaryKey(Integer fanId);

    int insert(UserFans record);

    /**
     *  添加用户关注
     * @param record
     * @return
     */
    int insertSelective(UserFans record);

    UserFans selectByPrimaryKey(Integer fanId);

    int updateByPrimaryKeySelective(UserFans record);

    int updateByPrimaryKey(UserFans record);

    /**
     *  取消关注
     * @param record
     */
    void delFans(UserFans record);

    /**
     * 查询该用户的粉丝名称
     * @return
     */
    List<User> selectFnameByUid(Integer uid);

    /**
     *  查询该用户的粉丝总数
     * @param uid
     * @return
     */
    int selectFcountByUid(Integer uid);

    /**
     * 查询到该用户关注的其他用户的用户名
     * @param uid
     * @return
     */
    List<User> selectSnameByUid(Integer uid);

    /**
     * 查询到该用户关注的用户数量
     * @param uid
     * @return
     */
    int selectScountByUid(Integer uid);
}