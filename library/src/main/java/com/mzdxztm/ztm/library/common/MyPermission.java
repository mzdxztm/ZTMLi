package com.mzdxztm.ztm.library.common;

import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;

import com.mzdxztm.ztm.library.other.androidCodeUtils.Utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyPermission {

    public static final String write = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final String read = "android.permission.READ_EXTERNAL_STORAGE";

    /**
     * 获取app使用的权限集合
     *
     * @return the permissions used in application
     */
    public static List<String> getPermissions() {
        String packageName = InitUtils.app.getPackageName();
        PackageManager pm = InitUtils.app.getPackageManager();
        try {
            String[] permissions = pm.getPackageInfo(packageName, PackageManager.GET_PERMISSIONS).requestedPermissions;
            if (permissions == null) return Collections.emptyList();
            return Arrays.asList(permissions);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    /**
     * 判断权限是否已经打开
     *
     * @param permissions The permissions.
     * @return {@code true}: yes<br>{@code false}: no
     */
    public static boolean isGranted(final String... permissions) {
        for (String permission : permissions) {
            if (!isGranted(permission)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断权限是否已经打开
     *
     * @param permission
     * @return
     */
    private static boolean isGranted(final String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M
                || PackageManager.PERMISSION_GRANTED
                == ContextCompat.checkSelfPermission(InitUtils.app, permission);
    }




}
