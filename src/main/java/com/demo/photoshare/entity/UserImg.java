package com.demo.photoshare.entity;

/**
 *  用户上传的图片信息
 */
public class UserImg {
    private Integer picid;

    private Integer imgUid;

    private String url;

    private String pictitle;

    private String imgdesc;

    private Integer imgFlag;

    public Integer getPicid() {
        return picid;
    }

    public void setPicid(Integer picid) {
        this.picid = picid;
    }

    public Integer getImgUid() {
        return imgUid;
    }

    public void setImgUid(Integer imgUid) {
        this.imgUid = imgUid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPictitle() {
        return pictitle;
    }

    public void setPictitle(String pictitle) {
        this.pictitle = pictitle == null ? null : pictitle.trim();
    }

    public String getImgdesc() {
        return imgdesc;
    }

    public void setImgdesc(String imgdesc) {
        this.imgdesc = imgdesc == null ? null : imgdesc.trim();
    }

    public Integer getImgFlag() {
        return imgFlag;
    }

    public void setImgFlag(Integer imgFlag) {
        this.imgFlag = imgFlag;
    }
}