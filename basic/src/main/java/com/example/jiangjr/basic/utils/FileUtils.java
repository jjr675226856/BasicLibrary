package com.example.jiangjr.basic.utils;

import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * Created by jiangjr on 2015/1/19.
 */
public class FileUtils {
    /**
     * 检查是否存在SDCard
     *
     * @return
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *   获得应用缓存文件的目录
     * @return
     *    获取SDCard 根目录 ：Environment.getExternalStorageDirectory().getAbsolutePath()
     */
    public static String getSdCardPath(String pageName) {
        File file = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath()
                + File.separator  //代表-> /
                + "Android"
                + File.separator
                + "data"
                + File.separator
                + pageName
                + File.separator
                + "cache" + File.separator);

        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    /**
     *   获得外部应用缓存文件的目录
     * @return
     *
     */
    public static String getCachePath(String pageName) {
        File file = new File(Environment.getDownloadCacheDirectory()
                .getAbsolutePath()
                + File.separator
                + "Android"
                + File.separator
                + "data"
                + File.separator
                + pageName
                + File.separator
                + "cache" + File.separator);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String getSaveImagePath(String pageName){
        File file = new File(getSdCardPath(pageName)
                +File.separator
                +"download"
                +File.separator);
        if (!file.exists()){
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String getSaveApkPath(String pageName){
        File file = new File(getSdCardPath(pageName)
                +File.separator
                +"apk"
                +File.separator);
        if (!file.exists()){
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String getTakeImagePath(String pageName){
        File file = new File(getSdCardPath(pageName)
                +File.separator
                +"photo"
                +File.separator);
        if (!file.exists()){
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String getWebViewCachePath(String pageName){
        File file = new File(getSdCardPath(pageName)
                +File.separator
                +"webViewCache"
                +File.separator);
        if (!file.exists()){
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    /**
     *  获取ImageLoader 的缓存文件内容
     * @return
     */
    public static String getImageLoaderPath(String pageName){
        File file = new File(getSdCardPath(pageName)
                +File.separator
                +"imageCache"
                +File.separator);
        if (!file.exists()){
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    /**
     *  获取 录音文件路径
     * @return
     */
    public static String getVoicePath(String pageName){
        File file = new File(getSdCardPath(pageName)
                +File.separator
                +"voice"
                +File.separator);
        if (!file.exists()){
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    //TODO 获取下载到的图片保存地址
    public static File saveFileImage(String name,String pageName) {
        File file = new File(getSaveImagePath(pageName)
                +File.separator
                +name
                );
        return file;
    }

    //TODO 获取APK文件的保存地址
    public static File saveFileApkPath(String name,String pageName) {
        File file = new File(getSaveApkPath(pageName)
                +File.separator
                +name
                +".apk");
        return file;
    }

    //TODO 获取照相机拍照的图片保存地址
    public static File saveFileTakePhotoImage(String name,String pageName) {
        File file = new File(getTakeImagePath(pageName)
                +File.separator
                +name
                +".png");
        return file;
    }

    // TODO 保存缓存图片的地址
    public static File saveFileBitmap(Bitmap bitmap, String name,String pageName) {
        File f = new File(getSdCardPath(pageName) + File.separator + name
                + ".jpg");
        FileOutputStream fOut = null;
        try {
            fOut = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG, 75, fOut);
        return f;
    }

    //TODO录音保存地址
    public static File saveFileVoice(String pageName) {
        File file = new File(getVoicePath(pageName)
                +File.separator
                +generalFileName());
        return file;
    }

    /**
     * 随机生成文件的名称
     *
     * @return
     */
    private static String generalFileName() {
        return UUID.randomUUID().toString().replace("-","") + ".amr";
    }
}