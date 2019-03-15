package com.demo.photoshare.service;

import com.demo.photoshare.entity.User;

import java.util.List;

public interface FansService {

    /**
     *  添加关注
     * @param fanUid 当前用户的id
     * @param starUid 被关注用户的id
     */
    public void add(Integer fanUid,Integer starUid);

    /**
     *  取消关注
     * @param fanUid 当前用户的id
     * @param starUid 被取消关注的用户的id
     */
    public void delete(Integer fanUid,Integer starUid);

    /**
     *  查询出当前用户的粉丝的用户名
     * @param uid
     * @return
     */
    public List<User> findFName(Integer uid);

    /**
     * 查询出当前用户关注的用户名
     * @param uid
     * @return
     */
    public List<User> findSName(Integer uid);

    /**
     *  查询出当前用户的粉丝总数
     * @param uid
     * @return
     */
    public int findFCount(Integer uid);

    /**
     * 查询出当前用户的关注总数
     * @param uid
     * @return
     */
    public int findSCount(Integer uid);
}
