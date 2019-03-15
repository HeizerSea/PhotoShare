package com.demo.photoshare.entity;

/**
 * 图片收藏信息
 */
public class ImgKeep {
    private Integer keepId;

    private Integer keepPicId;

    private Integer keepUserId;

    private Integer keepFlag;

    public Integer getKeepId() {
        return keepId;
    }

    public void setKeepId(Integer keepId) {
        this.keepId = keepId;
    }

    public Integer getKeepPicId() {
        return keepPicId;
    }

    public void setKeepPicId(Integer keepPicId) {
        this.keepPicId = keepPicId;
    }

    public Integer getKeepUserId() {
        return keepUserId;
    }

    public void setKeepUserId(Integer keepUserId) {
        this.keepUserId = keepUserId;
    }

    public Integer getKeepFlag() {
        return keepFlag;
    }

    public void setKeepFlag(Integer keepFlag) {
        this.keepFlag = keepFlag;
    }
}