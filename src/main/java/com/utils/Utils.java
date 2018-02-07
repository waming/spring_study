package com.utils;

import org.springframework.expression.ParseException;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    /**
     * mysql 时间戳格式的数据转换成date格式的数据
    **/
    public static String timestampToStringDate(String timestamp, String format)
    {
        if(StringUtils.isEmpty(timestamp)) {
            return "";
        }

        StringBuffer mBuffer = null;
        try {
            mBuffer = new StringBuffer(timestamp);
            mBuffer.append("000");
            SimpleDateFormat bartDateFormat = new SimpleDateFormat(format);
            Date date = new Date();
            long time = Long.valueOf(mBuffer.toString());
            date.setTime(time);
            return bartDateFormat.format(date);
        } catch (Exception e) {
            //e.printStackTrace();
            return "";
        }
    }

    public static String timestampToStringDate(String timestamp)
    {
        return timestampToStringDate(timestamp, "yyyy-MM-dd HH:mm:ss");
    }

    public static  String timestampToStringDate(String timestamp, Integer option)
    {
        return timestampToStringDate(timestamp, "yyyy年MM月dd日");
    }
}
