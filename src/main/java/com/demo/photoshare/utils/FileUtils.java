package com.demo.photoshare.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    /**
     *  文件上传
     * @param file
     * @param path
     * @param fileName
     * @return
     */
    public static String upload(MultipartFile file, String path, String fileName) {

        String newName = FileUtils.getFileName(fileName);
        // 生成新的路径与文件名
        String realPath = path + "/" + newName;
        File dest = new File(realPath);

        //判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try {
            //保存文件
            file.transferTo(dest);
            return newName;
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    /**
     *  获取文件的后缀名
     * @param fileName 文件名称
     * @return
     */
    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     *  对图片进行重命名
     * @param fileOriginName
     * @return
     */
    public static String getFileName(String fileOriginName) {
        return UUIDUtils.getUUID() + FileUtils.getSuffix(fileOriginName);
    }
}
