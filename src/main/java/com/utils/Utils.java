package com.utils;

import org.springframework.expression.ParseException;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    /*
     * date格式转换成mysql timestamp格式的数据
     * @param date example:'2017-12-18'
     * @return $timestamp 1517802908
    */
    public static String dateToTimestamp(String str)
    {
        String timestamp = "";
        Date date = new Date();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            date    = dateFormat.parse(str);
            long ts = date.getTime() / 1000;
            timestamp = String.valueOf(ts);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return timestamp;
    }


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
