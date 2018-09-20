package com.example.jiangjr.basic.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jiangjr on 15-3-13.
 */
public class TimeUtil {

    public static String getTimeFormat(){
        try{
            Date dateFormat = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd-hh-mm-ss");
            return new SimpleDateFormat("yyMMddhhmmss").format(dateFormat);
        }catch (Exception e){

        }
        return "";
    }

    public static String getSystemTimeFormat(){
        try{
            Date dateFormat = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd-hh-mm-ss");
            return new SimpleDateFormat("yy-MM-dd-hh:mm:ss").format(dateFormat);
        }catch (Exception e){

        }
        return "";
    }

    public static String getSystemTimeFormatHHmm(){
        try{
            Date dateFormat = new Date();
            SimpleDateFormat format = new SimpleDateFormat("hh-mm");
            return new SimpleDateFormat("hh:mm").format(dateFormat);
        }catch (Exception e){

        }
        return "";
    }
}
