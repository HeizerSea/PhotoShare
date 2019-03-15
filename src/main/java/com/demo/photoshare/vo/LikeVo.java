package com.demo.photoshare.vo;

/**
 * 用户点赞/喜欢的信息
 */
public class LikeVo {

    private String username;
    private Integer count;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
