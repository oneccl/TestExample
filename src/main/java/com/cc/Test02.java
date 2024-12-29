package com.cc;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2024/12/29
 * Time: 18:07
 * Description:
 */
public class Test02 {

    public static void main(String[] args) {
        // 删除目录（递归）
        String path = "C:\\Users\\cc\\Desktop\\test";
        File file = new File(path);
//        System.out.println(deleteDir(file));
        System.out.println(deleteDirectory(file));
    }

    // 使用递归方式删除目录及其中的文件
    public static Boolean deleteDir(File dir) {
        boolean res = true;
        if (dir.exists()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDir(file);
                } else {
                    res = res && file.delete();
                }
            }
            res = res && dir.delete();
        }
        return res;
    }

    // 使用CommonsIO库的FileUtils类删除目录及其中的文件
    public static Boolean deleteDirectory(File dir) {
        try {
            FileUtils.deleteDirectory(dir);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
