package com.example.jiangjr.basic.utils;

import android.graphics.Bitmap;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/11/5.
 */
public class ImageFileUtil {

    //bitmap 格式的图片转换为File
    public static File saveBitmapFile(Bitmap bitmap) {
        try {
            File imageFile = FileUtils.saveFileTakePhotoImage(TimeUtil.getTimeFormat());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(imageFile));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
            return imageFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
