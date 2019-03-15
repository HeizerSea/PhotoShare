package com.demo.photoshare.entity;

/**
 * 图片点赞/喜欢信息
 */
public class ImgLike {
    private Integer liId;

    private Integer liPicId;

    private Integer liUserId;

    private Integer likeFlag;

    public Integer getLiId() {
        return liId;
    }

    public void setLiId(Integer liId) {
        this.liId = liId;
    }

    public Integer getLiPicId() {
        return liPicId;
    }

    public void setLiPicId(Integer liPicId) {
        this.liPicId = liPicId;
    }

    public Integer getLiUserId() {
        return liUserId;
    }

    public void setLiUserId(Integer liUserId) {
        this.liUserId = liUserId;
    }

    public Integer getLikeFlag() {
        return likeFlag;
    }

    public void setLikeFlag(Integer likeFlag) {
        this.likeFlag = likeFlag;
    }
}