package com.mzdxztm.ztm.library.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.RequiresPermission;
import android.telephony.TelephonyManager;

import com.mzdxztm.ztm.library.common.InitUtils;
import com.mzdxztm.ztm.library.other.androidCodeUtils.Utils;

import static android.Manifest.permission.ACCESS_NETWORK_STATE;

/**
 *检查网络状态和网络类型
 */
public final class NetCheck {

    public enum NetworkType {
        NETWORK_ETHERNET,
        NETWORK_WIFI,
        NETWORK_4G,
        NETWORK_3G,
        NETWORK_2G,
        NETWORK_UNKNOWN,
        NETWORK_NO
    }

    private static ConnectivityManager connecManager;

    @RequiresPermission(ACCESS_NETWORK_STATE)
    public static void init() {
        connecManager = (ConnectivityManager) InitUtils.app.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connecManager != null) connecManager.getActiveNetworkInfo();
    }

    /**
     * 网络是否可用
     *
     * @return
     */
    @RequiresPermission(ACCESS_NETWORK_STATE)
    public static boolean hasNet() {
        NetworkInfo networkInfo = connecManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable();
    }

    @RequiresPermission(ACCESS_NETWORK_STATE)
    public static boolean isWifiAvaliable() {
        NetworkInfo info = connecManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return info != null && info.isAvailable();
    }

    @RequiresPermission(ACCESS_NETWORK_STATE)
    public static boolean isGPRSAvaliable() {
        NetworkInfo info = connecManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        return info != null && info.isAvailable();
    }

    /**
     * 获取网络类型
     * @return
     */
    @RequiresPermission(ACCESS_NETWORK_STATE)
    public static NetworkType getNetworkType() {
        if (isEthernet()) {
            return NetworkType.NETWORK_ETHERNET;
        }
        NetworkInfo info = connecManager.getActiveNetworkInfo();
        if (info != null && info.isAvailable()) {
            if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                return NetworkType.NETWORK_WIFI;
            } else if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
                switch (info.getSubtype()) {
                    case TelephonyManager.NETWORK_TYPE_GSM:
                    case TelephonyManager.NETWORK_TYPE_GPRS:
                    case TelephonyManager.NETWORK_TYPE_CDMA:
                    case TelephonyManager.NETWORK_TYPE_EDGE:
                    case TelephonyManager.NETWORK_TYPE_1xRTT:
                    case TelephonyManager.NETWORK_TYPE_IDEN:
                        return NetworkType.NETWORK_2G;

                    case TelephonyManager.NETWORK_TYPE_TD_SCDMA:
                    case TelephonyManager.NETWORK_TYPE_EVDO_A:
                    case TelephonyManager.NETWORK_TYPE_UMTS:
                    case TelephonyManager.NETWORK_TYPE_EVDO_0:
                    case TelephonyManager.NETWORK_TYPE_HSDPA:
                    case TelephonyManager.NETWORK_TYPE_HSUPA:
                    case TelephonyManager.NETWORK_TYPE_HSPA:
                    case TelephonyManager.NETWORK_TYPE_EVDO_B:
                    case TelephonyManager.NETWORK_TYPE_EHRPD:
                    case TelephonyManager.NETWORK_TYPE_HSPAP:
                        return NetworkType.NETWORK_3G;

                    case TelephonyManager.NETWORK_TYPE_IWLAN:
                    case TelephonyManager.NETWORK_TYPE_LTE:
                        return NetworkType.NETWORK_4G;

                    default:
                        String subtypeName = info.getSubtypeName();
                        if (subtypeName.equalsIgnoreCase("TD-SCDMA")
                                || subtypeName.equalsIgnoreCase("WCDMA")
                                || subtypeName.equalsIgnoreCase("CDMA2000")) {
                            return NetworkType.NETWORK_3G;
                        } else {
                            return NetworkType.NETWORK_UNKNOWN;
                        }
                }
            } else {
                return NetworkType.NETWORK_UNKNOWN;
            }
        }
        return NetworkType.NETWORK_NO;
    }

    /**
     * 是否是以太网
     * @return
     */
    @RequiresPermission(ACCESS_NETWORK_STATE)
    private static boolean isEthernet() {
        final ConnectivityManager cm =
                (ConnectivityManager) Utils.getApp().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) return false;
        final NetworkInfo info = cm.getNetworkInfo(ConnectivityManager.TYPE_ETHERNET);
        if (info == null) return false;
        NetworkInfo.State state = info.getState();
        if (null == state) return false;
        return state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING;
    }

}
