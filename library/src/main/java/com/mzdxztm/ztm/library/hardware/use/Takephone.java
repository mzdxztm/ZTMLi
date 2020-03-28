package com.mzdxztm.ztm.library.hardware.use;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.widget.Toast;

import com.mzdxztm.ztm.library.common.FileUtils;
import com.mzdxztm.ztm.library.common.InitUtils;
import com.mzdxztm.ztm.library.common.LocalContent;
import com.mzdxztm.ztm.library.common.MyPermission;

import java.io.File;

/**
 * 相机功能：
 * <p>
 * 系统相机目标：
 * 1、启动系统相机，并处理拍照放回结果
 * <p>
 * 自定义相机目标
 * 1.对Camera对象各种参数设置
 * 2、可以将SurfaceView、拍照按钮，计时器等分开传进来，得以实现拍照界面可变
 */

public class Takephone {

    public static void openSysCamera(Context context) {
        openSysCamera(context, getImageFileName());
    }

    public static void openSysCamera(Context context, String fileName) {
        if (!MyPermission.isGranted(MyPermission.write)) {
            Toast.makeText(context, "读取内存权限没打开", Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //系统常量， 启动相机的关键
        Uri uriForFile = FileProvider.getUriForFile(context, InitUtils.app.getPackageName(), new File(LocalContent.img_dir, fileName));
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
        Uri uriForFile = FileProvider.getUriForFile(activity, InitUtils.app.getPackageName(), new File(LocalContent.img_dir, fileName));
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

}
