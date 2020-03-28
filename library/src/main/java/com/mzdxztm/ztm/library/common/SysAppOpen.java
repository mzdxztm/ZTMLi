package com.mzdxztm.ztm.library.common;

import android.app.Activity;
import android.content.Context;

/**
 * 打开系统App
 * 带有返回值的暂时先不算在内（如拍照）
 */
public class SysAppOpen {

    private static Context context;

    public static void init(Context context){
        SysAppOpen.context = context;
    }


    public static void camera(Activity ac,int requestCode,String saveDir) {

    }

    public static void setting() {

    }

    /**
     * 应用权限设置界面
     */
    public static void permisionSett(){

    }

    public static void call(String phone) {

    }

    /**
     *
     * @param context
     * @param o 图片 文字
     */
    public static void share(Context context, Object o) {

    }



}
