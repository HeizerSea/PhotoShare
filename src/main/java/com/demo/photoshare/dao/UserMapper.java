package com.demo.photoshare.dao;


import com.demo.photoshare.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     *  根据用户名查询用户信息
     * @param name
     * @return
     */
    User selectByName(String name);
}