package com.mzdxztm.ztm.library.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

/**
 * 打开系统App
 * 带有返回值的暂时先不算在内（如拍照）
 */
public class SysAppOpen {

    private static Context context;

    public static void init(Context context) {
        SysAppOpen.context = context;
    }


    public static void camera(Activity ac, int requestCode, String saveDir) {

    }

    public static void setting() {

    }

    /**
     * 应用权限设置界面
     */
    public static void permisionSett() {

    }

    public static void call(String phone) {

    }

    /**
     * @param context
     * @param o       图片 文字
     */
    public static void share(Context context, Object o) {

    }

    /**
     * 打开设置主页面
     *
     * @param context
     */
    public static void settings(Context context) {
        context.startActivity(new Intent(Settings.ACTION_SETTINGS));
    }

    /**
     * 打开蓝牙设置界面
     *
     * @param context
     */
    public static void settingBlue(Context context) {
        context.startActivity(new Intent(Settings.ACTION_BLUETOOTH_SETTINGS));
    }


    /**
     * 判断activity是否存在
     *
     * @param activity activity隐式字符串，例如：android.settings.SETTINGS
     * @return
     */
    public static boolean isActivityExist(String activity) {
        Intent intent = new Intent(activity);
        if (InitUtils.app.getPackageManager().resolveActivity(intent, 0) == null) return false;
        return true;
    }

}
