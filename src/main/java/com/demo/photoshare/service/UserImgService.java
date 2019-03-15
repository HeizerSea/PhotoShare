package com.demo.photoshare.service;

import com.demo.photoshare.entity.UserImg;

import java.util.List;

public interface UserImgService {

    /**
     *  将图片地址保存到数据库
     * @param filePathNew
     */
    public void saveUploadFile(String fileName,String pictitle,String desc,Integer userid);

    /**
     *  根据用户Id查询出所有图片数据
     * @param uid
     * @return
     */
    public List<UserImg> findByUid(Integer uid);

    /**
     *  根据图片Id查找图片
     * @param pid
     * @return
     */
    public UserImg findByPid(Integer pid);

    /**
     * 删除用户上传的图片
     */
    public void delImg(Integer uid, Integer pid);
}
