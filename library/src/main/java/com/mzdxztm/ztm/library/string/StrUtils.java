package com.mzdxztm.ztm.library.string;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 功能
 * 1、字符串和TextView判空
 * 2、字符串识别（电话、身份证、驾驶证、车牌号等）
 * 3、常用的字符串分离、截取、替换和拼接
 * 4、常用的字符串格式化（地点、时间、电话等）
 *
 */
public class StrUtils {

    public static boolean isEmpty(TextView tv) {
        return TextUtils.isEmpty(tv.getText());
    }

    public static boolean isEmpty(EditText editText) {
        return TextUtils.isEmpty(editText.getText());
    }

    public static boolean isEmpty(String str) {
        return TextUtils.isEmpty(str);
    }

    //

}
