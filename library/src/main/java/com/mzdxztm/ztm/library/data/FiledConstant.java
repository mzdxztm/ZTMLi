package com.mzdxztm.ztm.library.data;

import android.os.Environment;

import java.io.File;

public class FiledConstant {

    //<editor-fold desc="目录相关">
    public static String ROOT_DIR = getRootDir();

    public static String IMG_DIR = ROOT_DIR + File.separator + "image";

    public static String VIDEO_DIR = ROOT_DIR + File.separator + "video";

    public static String NET_CACHE_DIR = ROOT_DIR + File.separator + "net";

    public static String OTHER_DIR = ROOT_DIR + File.separator + "other";

    private static String getRootDir() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            return Environment.getExternalStorageDirectory() + File.separator + "ztm";
        } else {
            return Environment.getDataDirectory() + File.separator + "ztm";
        }
    }
    //</editor-fold>


}
