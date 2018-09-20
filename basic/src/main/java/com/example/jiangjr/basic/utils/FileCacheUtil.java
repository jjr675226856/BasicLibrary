package com.example.jiangjr.basic.utils;

import android.text.TextUtils;

import java.io.File;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2015/2/4.
 * 读取缓存和删除缓存
 */
public class FileCacheUtil {

    /***
     *    获取文件
     * @param file  Context.getExternalFilesDir()->
     *              SDCard/Android/data/包名/files/
     *              目录一般放一些长时间保持的数据
     *
     *              Context.getExternalFilesDir()->
     *              SDCard/Android/data/包名/cache/
     *              目录一般放临时的缓存数据
      * @return
     */
    public static long getFolderSize(File file) {
        long size = 0;
        try{
            File[] fileList = file.listFiles();
            for (int i = 0; i<fileList.length ; i++){
                //如果下面还有文件
                if(fileList[i].isDirectory()){
                    size = size + getFolderSize(fileList[i]);
                }
                else{
                    size = size + fileList[i].length();
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return size;
    }

    /***
     *     删除指点目录下的文件及目录
     * @param filePath
     * @param deleteThisPath
     */
    public static void deleteFolderFile(String filePath,boolean deleteThisPath){
        if (!TextUtils.isEmpty(filePath)){
            try {
                File file = new File(filePath);
                if (file.isDirectory()){   //如果下面还有文件
                    File[] files = file.listFiles();
                    for (int i = 0;i< files.length; i ++){
                        deleteFolderFile(files[i].getAbsolutePath(),true);
                    }
                }
                if (deleteThisPath)
                {
                    if (!file.isDirectory()){
                        file.delete();
                    }else{//目录
                        if (file.listFiles().length == 0){ //目录下没有文件或者目录，删除
                            file.delete();
                        }
                    }
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /***
     * 格式化单位
     * @param size
     * @return
     */

    public static String getFormatSize(double size){
        double kitByte = size / 1024 ;
        if (kitByte < 1) {
            return size + "B";
        }

        double megaByte = kitByte / 1024 ;
        if (megaByte < 1 ){
            BigDecimal result = new BigDecimal(Double.toString(kitByte));
            return result.setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString() + "KB";
        }

        double gigaByte = megaByte / 1024 ;
        if (gigaByte < 1){
            BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
            return result2.setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString() + "MB";
        }

        double teraByte = gigaByte / 1024 ;
        if (teraByte < 1){
            BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
            return result3.setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString() + "GB";
        }

        BigDecimal result4 = new BigDecimal(teraByte);
        return  result4.setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString() + "TB";
    }

    //获得缓存数据的大小
    public static String getCacheSize(File file) throws Exception{
        if (file != null) {
            return getFormatSize(getFolderSize(file));
        }
        return null;
    }

}
