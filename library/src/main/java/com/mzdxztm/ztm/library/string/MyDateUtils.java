package com.mzdxztm.ztm.library.string;

import java.util.Calendar;
import java.util.Date;

/**
 *
 */
public class MyDateUtils {

    public static String getWeekDay(int timeMillis) {
        Date date = new Date(timeMillis);
        return getWeekDay(date);
    }

    public static String getWeekDay(Date date) {
        String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int weekDayNum = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return weekOfDays[weekDayNum];
    }

    public static String getNowTimeBefore(long milli) {
        long seconds = milli / 60;
        StringBuffer buffer = new StringBuffer();
        if (seconds < 3600) {
            buffer.append((long) Math.floor(seconds / 60.0)).append("分钟前");
        } else if (seconds < 86400) {
            buffer.append((long) Math.floor(seconds / 3600.0)).append("小时前");
        } else if (seconds < 604800) {
            buffer.append((long) Math.floor(seconds / 86400.0)).append("天前");
        } else if (seconds < 2592000) {
            buffer.append((long) Math.floor(seconds / 604800.0)).append("周前");
        } else if (seconds < 31104000) {
            buffer.append((long) Math.floor(seconds / 2592000.0)).append("月前");
        } else {
            buffer.append((long) Math.floor(seconds / 31104000.0)).append("年前");
        }
        return buffer.toString();
    }

}
