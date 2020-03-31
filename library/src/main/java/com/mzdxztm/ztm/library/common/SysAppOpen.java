package com.mzdxztm.ztm.library.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.content.FileProvider;
import android.widget.Toast;

import com.mzdxztm.ztm.library.data.FiledConstant;
import com.mzdxztm.ztm.library.tool.LogUtils;

import java.io.File;


/**
 * 打开系统App
 * 带有返回值的暂时先不算在内（如拍照）
 */
public class SysAppOpen {

    //<editor-fold desc="camera">
    public static void openSysCamera(Context context) {
        openSysCamera(context, getImageFileName());
    }

    public static void openSysCamera(Context context, String fileName) {
        if (!MyPermission.isGranted(MyPermission.write)) {
            Toast.makeText(context, "读取内存权限没打开", Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //系统常量， 启动相机的关键
        Uri uriForFile = FileProvider.getUriForFile(context, InitUtils.app.getPackageName(), new File(FiledConstant.IMG_DIR, fileName));
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uriForFile);
        context.startActivity(intent);
    }

    /**
     * @param activity
     * @param requestCode
     */
    public static void openSysCamera(Activity activity, int requestCode) {
        if (!MyPermission.isGranted(MyPermission.write)) {
            Toast.makeText(activity, "读取内存权限没打开", Toast.LENGTH_LONG).show();
            return;
        }
        openSysCamera(activity, getImageFileName(), requestCode);
    }

    public static void openSysCamera(Activity activity, String fileName, int requestCode) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //系统常量， 启动相机的关键
        Uri uriForFile = FileProvider.getUriForFile(activity, InitUtils.app.getPackageName(), new File(FiledConstant.IMG_DIR, fileName));
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uriForFile);
        activity.startActivityForResult(intent, requestCode); // 参数常量为自定义的request code, 在取返回结果时有用
    }

    /**
     * 根据时间生成jpg文件名
     *
     * @return
     */
    private static String getImageFileName() {
        return FileUtils.getFileName() + ".jpg";
    }
    //</editor-fold>

    //<editor-fold desc="phone">

    /**
     * 打电话
     *
     * @param phone
     */
    public static void call(String phone) {

    }

    public static void callBoard() {

    }

    public static void sendMsg(String msg, String phone) {

    }

    //</editor-fold>

    //<editor-fold desc="settings">

    /**
     * 打开设置主页面
     */
    public static void settings() {
        InitUtils.app.startActivity(new Intent(Settings.ACTION_SETTINGS));
    }

    /**
     * 蓝牙界面
     */
    public static void buletooth() {
        InitUtils.app.startActivity(new Intent(Settings.ACTION_BLUETOOTH_SETTINGS));
    }

    /**
     * wifi界面
     */
    public static void wifi() {
        InitUtils.app.startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
    }

    /**
     * app管理页面
     */
    public static void appManager() {
        String activityStr = "android.settings.APPLICATION_DETAILS_SETTINGS";
        if (Build.VERSION.SDK_INT <= 8) activityStr = "com.android.settings.InstalledAppDetails";

        if (isActivityExist(activityStr)) InitUtils.app.startActivity(new Intent(activityStr));
        else {
            LogUtils.e("app详情页启动失败！");
            //启动设置主页
            settings();
        }
    }

    /**
     * 权限设置界面，没有的就打开app管理页面，找到相关的应用点进去，然后再设置权限
     */
    public static void permission() {// TODO: 2020/3/30 很多品牌还没处理
        String activityStr = null;
        if (Build.MANUFACTURER.equals("Huawei"))
            activityStr = "com.huawei.permissionmanager.ui.MainActivity";//华为
        if (Build.MANUFACTURER.equals("Meizu"))
            activityStr = "com.meizu.safe.security.SHOW_APPSEC";//魅族（可能异常）
        if (Build.MANUFACTURER.equals("Sony"))
            activityStr = "com.sonymobile.cta.SomcCTAMainActivity";//索尼
        if (Build.MANUFACTURER.equals("OPPO"))
            activityStr = "com.color.safecenter.permission.PermissionManagerActivity";//OPPO
        if (Build.MANUFACTURER.equals("Letv"))
            activityStr = "com.letv.android.letvsafe.PermissionAndApps";//乐视
        if (Build.MANUFACTURER.equals("ZTE")) ;//中兴
        if (Build.MANUFACTURER.equals("YuLong")) ;//酷派
        if (Build.MANUFACTURER.equals("samsung")) ;//三星
        if (Build.MANUFACTURER.equals("LENOVO")) ;//联想
        if (Build.MANUFACTURER.equals("Xiaomi")) ;//小米

        if (activityStr == null) appManager();
        else InitUtils.app.startActivity(new Intent(activityStr));

    }
    //</editor-fold>

    //<editor-fold desc="other">

    /**
     * @param context
     * @param o       图片 文字
     */
    public static void share(Context context, Object o) {

    }

    //</editor-fold>

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
