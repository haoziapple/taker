package com.haozi.taker.core.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件工具类
 * Created by Administrator on 2017/7/12.
 */
public class FileUtil {

    // 读取某个路径下的所有文件名
    public static List<String> readFilesName(String path) {
        File file = new File(path);
        File[] tempList = file.listFiles();
        System.out.println("目录下文件个数:" + tempList.length);

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile())
                list.add(tempList[i].getName());
        }
        return list;
    }

    // 修剪并选取文件名：去除后缀和词组
    public static List<String> getTrimmedList(List<String> list) {
        List<String> result = new ArrayList<String>();
        for (String s : list) {
            if (s.contains(" ") || s.contains("'") || s.contains("-")) {
                continue;
            } else {
                result.add(s.replaceAll("\\.mp3", ""));
            }
        }

        return result;
    }


    public static void main(String[] args) {
        String path = "E:\\words\\a";

        List<String> list = readFilesName(path);

        System.out.println(list);

        List<String> list2 = (getTrimmedList(list));

        System.out.println(list2);
    }

}
