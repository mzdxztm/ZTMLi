package com.mzdxztm.ztm.library.common;

import android.text.TextUtils;
import android.text.format.DateUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;

/**
 * 文件相关
 * 功能：
 * 1、判断文件是否存在
 * 2、创建和删除文件
 * 3、文件读写
 */
public class FileUtils {

    public static boolean isExist(String path) {
        return new File(path).exists();
    }

    public static File createFile(String path, boolean replace) {
        return createFile(new File(path), replace);
    }

    /**
     * @param file
     * @param replace 如果文件已经存在 是否替换，true为替换
     * @return
     */
    public static File createFile(File file, boolean replace) {
        if (replace && file.exists()) {
            file.delete();
        }
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return file;
    }

    public static boolean deleteFile(String path) {
        return new File(path).delete();
    }

    public static String getFileName(String dir, String fileName) {
        if (dir == null || TextUtils.isEmpty(fileName)) return null;
        if (!dir.endsWith(File.separator)) dir = dir + File.separator;
        return dir + fileName;
    }

    /**
     * 根据时间生成文件名
     *
     * @return
     */
    public static String getFileName() {
       /* Date date = new Date(System.currentTimeMillis());
       StringBuffer sb = new StringBuffer();
       sb.append(date.getYear())
               .append(date.getMonth())
       .append(date.getMonth()).append(date.getDay()).append(date.getHours())
       .append(date.getMinutes());*/
        return "" + System.currentTimeMillis();
    }

    public static boolean isImageFile(String file) {
        if (TextUtils.isEmpty(file)) return false;
        return strComp(filePostfix(file), "PNG", "JPG", "GIF", "ICO", "BMP", "WEBP", "TAG", "TIF");
    }

    public static boolean isAudioFile(String file) {
        if (TextUtils.isEmpty(file)) return false;
        return strComp(filePostfix(file), "MP3", "MP2", "FLAC", "WAV", "AMR", "OGG", "AWB",
                "WMA", "AAC", "AC3", "M4R", "M4A", "MMF", "WAVPACK");
    }

    public static boolean isVideoFile(String file) {
        if (TextUtils.isEmpty(file)) return false;
        return strComp(filePostfix(file), "MP4", "3GP", "AVI", "MKV", "MOV", "FLV", "WMV", "MPG");
    }

    /**
     * 获取文件扩展名
     *
     * @param file
     * @return
     */
    public static String filePostfix(String file) {
        if (TextUtils.isEmpty(file)) return "";
        return file.substring(file.lastIndexOf("."), file.length());
    }

    /**
     * 判断字符串是否与数组中某个字符串相等(忽略大小写)
     *
     * @param src
     * @param strs
     * @return 有相等的字符串返回true，否则false
     */
    private static boolean strComp(String src, String... strs) {
        if (TextUtils.isEmpty(src) || strs == null) return false;
        if (strs.length == 0) return false;
        for (int i = 0; i < strs.length; i++) {
            if (src.equalsIgnoreCase(strs[i])) return true;
        }
        return false;
    }

    public static FileInputStream readFile(String file) {
        if (TextUtils.isEmpty(file)) return null;
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stream;
    }

    public static FileOutputStream writeFile(String file) {
        if (TextUtils.isEmpty(file)) return null;
        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stream;
    }

    public static BufferedReader readerFile(String file) {
        if (TextUtils.isEmpty(file)) return null;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }

    public static BufferedWriter writersFile(String file) {
        if (TextUtils.isEmpty(file)) return null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bufferedWriter;
    }


}
