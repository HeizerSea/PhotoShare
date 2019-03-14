package com.demo.photoshare.service.impl;

import com.demo.photoshare.dao.UserFansMapper;
import com.demo.photoshare.entity.User;
import com.demo.photoshare.entity.UserFans;
import com.demo.photoshare.service.FansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FansServiceImpl implements FansService {

    @Autowired
    private UserFansMapper fansDao;

    @Override
    public void add(Integer fanUid, Integer starUid) {
        UserFans fans = new UserFans();
        fans.setFanUserId(fanUid);
        fans.setStarUserId(starUid);

        fansDao.insertSelective(fans);
    }

    @Override
    public void delete(Integer fanUid, Integer starUid) {
        UserFans fans = new UserFans();
        fans.setFanUserId(fanUid);
        fans.setStarUserId(starUid);

        fansDao.delFans(fans);
    }

    @Override
    public List<User> findFName(Integer uid) {
        return fansDao.selectFnameByUid(uid);
    }

    @Override
    public List<User> findSName(Integer uid) {
        return fansDao.selectSnameByUid(uid);
    }

    @Override
    public int findFCount(Integer uid) {
        return fansDao.selectFcountByUid(uid);
    }

    @Override
    public int findSCount(Integer uid) {
        return fansDao.selectScountByUid(uid);
    }
}
