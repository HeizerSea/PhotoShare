package com.demo.photoshare.service;

import com.demo.photoshare.entity.User;

public interface UserService {
    /**
     *  用户注册时调用的方法
     * @param name
     * @param pwd
     */
    public void register(String name,String pwd);

    /**
     *  用户登录时调用的方法
     * @param name
     * @param pwd
     * @return
     */
    public User login(String name, String pwd);
}
