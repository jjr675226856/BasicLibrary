package com.example.jiangjr.basic.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jiangjr on 15-3-13.
 */
public class TimeUtil {

    public static String getTimeFormat() {
        try {
            Date dateFormat = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd-hh-mm-ss");
            return new SimpleDateFormat("yyMMddhhmmss").format(dateFormat);
        } catch (Exception e) {

        }
        return "";
    }

    public static String getSystemTimeFormat() {
        try {
            Date dateFormat = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd-hh-mm-ss");
            return new SimpleDateFormat("yy-MM-dd-hh:mm:ss").format(dateFormat);
        } catch (Exception e) {

        }
        return "";
    }

    public static long getSystemTimeFormat(String dateFormat) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
            return new SimpleDateFormat("yy-MM-dd hh:mm:ss").parse(dateFormat).getTime();
        } catch (Exception e) {

        }
        return 0;
    }

    public String getMinute(int time) {
        return time / 60 % 60 + "";
    }

    public String getSecond(int time) {
        int num = time % 60;
        return num < 10 ? (0 + "" + num) : (num + "");
    }

    public static String getSystemTimeFormatHHmm() {
        try {
            Date dateFormat = new Date();
            SimpleDateFormat format = new SimpleDateFormat("hh-mm");
            return new SimpleDateFormat("hh:mm").format(dateFormat);
        } catch (Exception e) {

        }
        return "";
    }
}