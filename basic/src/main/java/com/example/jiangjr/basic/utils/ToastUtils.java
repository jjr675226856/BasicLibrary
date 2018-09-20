package com.example.jiangjr.basic.utils;

import android.content.Context;
import android.widget.Toast;


/**
 * Created by jiangjr on 2015/1/12.
 */
public class ToastUtils {
    private ToastUtils() {
        //Empty
    }

    public static void showError(final Context context,final int message ) {
        getToast(context,message).show();
    }

    public static void showError(final Context context,final String message ) {
        getToast(context,message).show();
    }

    public static void showShortMessage(Context context, int message) {
        getToast(context,message, Toast.LENGTH_SHORT).show();
    }

    public static void showShortMessage(Context context,String message ) {
        getToast(context,message, Toast.LENGTH_SHORT).show();
    }

    public static void showLongMessage(Context context,String message){
        getToast(context,message).show();
    }

    private static Toast getToast(Context context,int message) {
        return getToast(context, message,  Toast.LENGTH_LONG);
    }

    private static Toast getToast(Context context,String message) {
        return getToast(context, message,  Toast.LENGTH_LONG);
    }

    private static Toast getToast( Context context,int message, int length) {
        return Toast.makeText(context, message, length);
    }

    private static Toast getToast( Context context,String message, int length) {
        return Toast.makeText(context, message, length);
    }


}
