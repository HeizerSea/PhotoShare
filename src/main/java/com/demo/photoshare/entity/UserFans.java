package com.demo.photoshare.entity;

/**
 * 用户关注信息
 */
public class UserFans {
    private Integer fanId;

    private Integer fanUserId;

    private Integer starUserId;

    private Integer fanFlag;

    public Integer getFanId() {
        return fanId;
    }

    public void setFanId(Integer fanId) {
        this.fanId = fanId;
    }

    public Integer getFanUserId() {
        return fanUserId;
    }

    public void setFanUserId(Integer fanUserId) {
        this.fanUserId = fanUserId;
    }

    public Integer getStarUserId() {
        return starUserId;
    }

    public void setStarUserId(Integer starUserId) {
        this.starUserId = starUserId;
    }

    public Integer getFanFlag() {
        return fanFlag;
    }

    public void setFanFlag(Integer fanFlag) {
        this.fanFlag = fanFlag;
    }
}