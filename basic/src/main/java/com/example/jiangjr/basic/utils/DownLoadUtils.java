package com.example.jiangjr.basic.utils;

import android.content.Context;
import android.content.pm.PackageManager;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jiangjr on 15-3-3.
 */
public class DownLoadUtils {
    public DownLoadUtils(){}

    //TODO 下载图片
    public static File getDownloadImage(String fileName,String url) {
        URL mUrl;
        File file = FileUtils.saveFileImage(fileName);
        HttpURLConnection connection;
        BufferedInputStream in = null;
        FileOutputStream outputStream = null;
        try {
            mUrl = new URL(url);
            connection = (HttpURLConnection) mUrl.openConnection();
            in = new BufferedInputStream(connection.getInputStream());
            outputStream = new FileOutputStream(file);
            byte[] bs = new byte[1024 * 100];
            int len = 0;
            while ((len = in.read(bs)) != -1){
                outputStream.write(bs,0,len);
            }
        } catch (MalformedURLException e) {
           new RuntimeException(e.getMessage());
        } catch (IOException e) {
           new RuntimeException(e.getMessage());
        }finally {
            try {
                in.close();
                outputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return file;
    }

    public static boolean hasCamera(Context context) {
        PackageManager pm = context.getPackageManager();
        return pm.hasSystemFeature(PackageManager.FEATURE_CAMERA)
                || pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT);
    }
}
