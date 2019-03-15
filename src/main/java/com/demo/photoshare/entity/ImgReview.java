package com.demo.photoshare.entity;

/**
 *  图片评论信息
 */
public class ImgReview {
    private Integer reId;

    private Integer rePicId;

    private Integer reUserId;

    private String content;

    private Integer reviewFlag;

    public Integer getReId() {
        return reId;
    }

    public void setReId(Integer reId) {
        this.reId = reId;
    }

    public Integer getRePicId() {
        return rePicId;
    }

    public void setRePicId(Integer rePicId) {
        this.rePicId = rePicId;
    }

    public Integer getReUserId() {
        return reUserId;
    }

    public void setReUserId(Integer reUserId) {
        this.reUserId = reUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getReviewFlag() {
        return reviewFlag;
    }

    public void setReviewFlag(Integer reviewFlag) {
        this.reviewFlag = reviewFlag;
    }
}