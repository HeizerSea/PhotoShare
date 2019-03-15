package com.demo.photoshare.service;

import com.demo.photoshare.entity.User;
import com.demo.photoshare.entity.UserImg;
import org.omg.CORBA.INTERNAL;

import java.util.List;

public interface KeepService {

    /**
     *  添加收藏
     */
    public void add(Integer uid, Integer pid);

    /**
     *  取消收藏
     * @param uid
     * @param pid
     */
    public void delete(Integer uid,Integer pid);

    /**
     * 根据图片id查询出所有收藏该图片的用户名
     * @param pid
     * @return
     */
    public List<User> findNameByPid(Integer pid);

    /**
     * 根据图片id查询出所有收藏该图片的用户总数
     * @return
     */
    public int findCount(Integer pid);

    /**
     * 根据用户Id查询出该用户收藏的所有图片
     * @param uid
     * @return
     */
    public List<UserImg> findUrlByUid(Integer uid);
}
