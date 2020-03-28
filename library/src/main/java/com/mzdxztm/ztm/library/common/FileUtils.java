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

    public static BufferedReader readerStream(String file) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }

    public static BufferedWriter writerStream(String file) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bufferedWriter;
    }

    public static void close(BufferedReader reader) {
        if (reader == null) return;
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void close(BufferedWriter writer) {
        if (writer == null) return;
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

}
