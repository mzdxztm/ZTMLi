package com.mzdxztm.ztm.library.string;

import android.text.TextUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 字符串格式化（
 */
public class StrFormat {

    //<editor-fold desc="时间相关">
    public static final String DATE_FORMAT_DAY = "yyyy-MM-dd";
    public static final String DATE_FORMAT_TIME1 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_TIME2 = "yyyy-MM-dd HH:mm";

    public static String date(Date date, String formatStr) {
        DateFormat format = new SimpleDateFormat(formatStr);
        return format.format(date);
    }

    //</editor-fold>

}
