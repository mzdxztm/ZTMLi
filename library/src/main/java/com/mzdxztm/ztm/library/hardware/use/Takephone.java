package com.mzdxztm.ztm.library.hardware.use;

import android.app.Activity;
import android.content.Context;
import com.mzdxztm.ztm.library.common.FileUtils;
import com.mzdxztm.ztm.library.common.SysAppOpen;


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
        SysAppOpen.openSysCamera(context);
    }

    public static void openSysCamera(Context context, String fileName) {
        SysAppOpen.openSysCamera(context, fileName);
    }

    /**
     * @param activity
     * @param requestCode
     */
    public static void openSysCamera(Activity activity, int requestCode) {
        SysAppOpen.openSysCamera(activity, requestCode);
    }

    public static void openSysCamera(Activity activity, String fileName, int requestCode) {
        SysAppOpen.openSysCamera(activity, fileName, requestCode);
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
