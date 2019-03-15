package com.demo.photoshare.service.impl;

import com.demo.photoshare.dao.UserMapper;
import com.demo.photoshare.entity.User;
import com.demo.photoshare.service.UserService;
import com.demo.photoshare.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;

    public void register(String name, String pwd) {

        String md5 = MD5Utils.encode(pwd);

        User user = new User();
        user.setUsername(name);
        user.setUserpwd(md5);

        // 判断是否已存在同名用户
        User user2 = userDao.selectByName(user.getUsername());

        // 不存在同名用户
        if (user2 == null) {
            try {
                userDao.insertSelective(user);
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        } else {
            throw new RuntimeException("该用户名已被占用");
        }
    }

    @Override
    public User login(String name, String pwd) {
        String md5 = MD5Utils.encode(pwd);
        User user = userDao.selectByName(name);
        if (user == null) {
            throw new RuntimeException("用户名错误");
        }
        if (!user.getUserpwd().equals(md5)) {
            throw new RuntimeException("密码错误");
        }

        return user;
    }
}
