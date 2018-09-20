package com.example.jiangjr.basic.utils;


import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

public class PicassoUtil {

    private PicassoUtil() {
        throw new IllegalStateException("no instance");
    }

    private static <T> void checkNull(T object, String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
    }

    /**
     * 检查传入的url或者数组中第一个url是不是为空
     */
    @SuppressWarnings("uncheck") public static boolean isUrlsEmpty(String... urls) {
        return urls == null || urls.length == 0 || urls[0] == null || urls[0].trim().isEmpty();
    }

    @SuppressWarnings("uncheck") public static String checkAndHandleUrl(String... urls) {
        if (isUrlsEmpty(urls)) {
            return "empty_url";
        }
        return urls[0];
    }

    public static Picasso getInstance(Context context) {
        return Picasso.with(context);
    }

    public static void load(@NonNull Context context, String path, @DrawableRes int placeholderResId,
                            @NonNull ImageView target) {
        Picasso.with(context)
                .load(checkAndHandleUrl(path))
                .config(Bitmap.Config.RGB_565)
                .placeholder(placeholderResId)
                .error(placeholderResId)
                .into(target);
    }

    /**
     * 默认图为{@link}
     */
    public static void loadCenterCrop(@NonNull Context context, String path,
                                      @NonNull ImageView target) {
//        loadCenterCrop(context, path, R.drawable.img_defult, target);
    }

    public static void loadCenterCrop(@NonNull Context context, String path,
                                      @DrawableRes int placeholderResId, @NonNull ImageView target) {
        loadCenterCrop(context, path, placeholderResId, placeholderResId, target);
    }

    public static void loadCenterCrop(@NonNull Context context, String path,
                                      @DrawableRes int placeholderResId, @DrawableRes int errorResId, @NonNull ImageView target) {
        Picasso.with(context)
                .load(checkAndHandleUrl(path))
                .placeholder(placeholderResId)
                .error(errorResId)
                .centerCrop()
                .fit()
                //.tag(context)
                .into(target);
    }

    public static void loadCenterCrop(@NonNull Context context, @NonNull int resourceId,
                                      @DrawableRes int placeholderResId, @DrawableRes int errorResId, @NonNull ImageView target) {
        if (resourceId == 0) {
            target.setImageDrawable(context.getResources().getDrawable(placeholderResId));
        } else {
            Picasso.with(context)
                    .load(resourceId)
                    .placeholder(placeholderResId)
                    .error(errorResId)
                    .centerCrop()
                    .fit()
                    .into(target);
        }
    }

    public static void loadCenterCrop(@NonNull Context context, File file,
                                      @DrawableRes int placeholderResId, @NonNull ImageView target) {
        if (file == null) {
            target.setImageDrawable(context.getResources().getDrawable(placeholderResId));
        } else {
            Picasso.with(context)
                    .load(file)
                    .placeholder(placeholderResId)
                    .error(placeholderResId)
                    .centerCrop()
                    .fit()
                    .into(target);
        }
    }

    public static void loadCenterCrop(@NonNull Context context, File file,
                                      @DrawableRes int placeholderResId, @DrawableRes int errorResId, @NonNull ImageView target) {
        if (file == null) {
            target.setImageDrawable(context.getResources().getDrawable(placeholderResId));
        } else {
            Picasso.with(context)
                    .load(file)
                    .placeholder(placeholderResId)
                    .error(errorResId)
                    .centerCrop()
                    .fit()
                    .into(target);
        }
    }
//    /**
//     * 以下三个方法是centerCrop方式加载带圆角的图片
//     */
//    public static void loaderRoundConnerCenterCrop(@NonNull Context context, String path,
//                                                   @DrawableRes int placeholderResId, @DrawableRes int errorResId, @NonNull ImageView target,
//                                                   @NonNull int radius, @NonNull int margin) {
//        if (path == null) {
//            target.setImageDrawable(context.getResources().getDrawable(placeholderResId));
//        } else {
//            Picasso.with(context)
//                    .load(checkAndHandleUrl(path))
//                    .placeholder(placeholderResId)
//                    .error(errorResId)
//                    .transform(new RoundedCornersTransformation(DensityUtil.dip2px(context, radius), margin))
//                    .centerCrop()
//                    .fit()
//                    .into(target);
//        }
//    }
//    public static void loaderRoundConnerCenterCrop(@NonNull Context context, int resourceId,
//                                                   @DrawableRes int placeholderResId, @DrawableRes int errorResId, @NonNull ImageView target,
//                                                   @NonNull int radius, @NonNull int margin) {
//        if (resourceId == 0) {
//            target.setImageDrawable(context.getResources().getDrawable(placeholderResId));
//        } else {
//            Picasso.with(context)
//                    .load(resourceId)
//                    .placeholder(placeholderResId)
//                    .error(errorResId)
//                    .transform(new RoundedCornersTransformation(DensityUtil.dip2px(context, radius), margin))
//                    .centerCrop()
//                    .fit()
//                    .into(target);
//        }
//    }
//    public static void loaderRoundConnerCenterCrop(@NonNull Context context, File file,
//                                                   @DrawableRes int placeholderResId, @DrawableRes int errorResId, @NonNull ImageView target,
//                                                   @NonNull int radius, @NonNull int margin) {
//        if (file == null) {
//            target.setImageDrawable(context.getResources().getDrawable(placeholderResId));
//        } else {
//            Picasso.with(context)
//                    .load(file)
//                    .placeholder(placeholderResId)
//                    .error(errorResId)
//                    .transform(new RoundedCornersTransformation(DensityUtil.dip2px(context, radius), margin))
//                    .centerCrop()
//                    .fit()
//                    .into(target);
//        }
//    }
//    /**
//     * 以下三个方法是centerCrop方式加载圆形的图片
//     */
//    public static void loaderCircleCenterCrop(@NonNull Context context, String path,
//                                              @DrawableRes int placeholderResId, @DrawableRes int errorResId, @NonNull ImageView target) {
//        if (path == null || path.trim().isEmpty()) {
//            target.setImageDrawable(context.getResources().getDrawable(placeholderResId));
//        } else {
//            Picasso.with(context)
//                    .load(checkAndHandleUrl(path))
//                    .placeholder(placeholderResId)
//                    .error(errorResId)
//                    .transform(new CropCircleTransformation())
//                    .centerCrop()
//                    .fit()
//                    .into(target);
//        }
//    }
//
//    public static void loaderCircleCenterCrop(@NonNull Context context, @NonNull int resourceId,
//                                              @DrawableRes int placeholderResId, @DrawableRes int errorResId, @NonNull ImageView target) {
//
//        if (resourceId == 0) {
//            target.setImageDrawable(context.getResources().getDrawable(placeholderResId));
//        } else {
//            Picasso.with(context)
//                    .load(resourceId)
//                    .placeholder(placeholderResId)
//                    .error(errorResId)
//                    .transform(new CropCircleTransformation())
//                    .centerCrop()
//                    .fit()
//                    .into(target);
//        }
//    }
//
//    public static void loaderCircleCenterCrop(@NonNull Context context, File file,
//                                              @DrawableRes int placeholderResId, @DrawableRes int errorResId, @NonNull ImageView target) {
//        if (file == null) {
//            target.setImageDrawable(context.getResources().getDrawable(placeholderResId));
//        } else {
//            Picasso.with(context)
//                    .load(file)
//                    .placeholder(placeholderResId)
//                    .error(errorResId)
//                    .transform(new CropCircleTransformation())
//                    .centerCrop()
//                    .fit()
//                    .into(target);
//        }
//    }
//
//    /****************************** CenterInside ***************************************/
//    public static void loaderCenterInside(@NonNull Context context, String path,
//                                          @DrawableRes int placeholderResId, @DrawableRes int errorResId, @NonNull ImageView target) {
//        if (path == null || path.trim().isEmpty()) {
//            target.setImageDrawable(context.getResources().getDrawable(placeholderResId));
//        } else {
//            Picasso.with(context)
//                    .load(checkAndHandleUrl(path))
//                    .placeholder(placeholderResId)
//                    .error(errorResId)
//                    .centerInside()
//                    .fit()
//                    .into(target);
//        }
//    }
//
//    public static void loaderCenterInside(@NonNull Context context, @NonNull int resourceId,
//                                          @DrawableRes int placeholderResId, @DrawableRes int errorResId, @NonNull ImageView target) {
//
//        if (resourceId == 0) {
//            target.setImageDrawable(context.getResources().getDrawable(placeholderResId));
//        } else {
//            Picasso.with(context)
//                    .load(resourceId)
//                    .placeholder(placeholderResId)
//                    .error(errorResId)
//                    .centerInside()
//                    .fit()
//                    .into(target);
//        }
//    }
//
//    public static void loaderCenterInside(@NonNull Context context, File file,
//                                          @DrawableRes int placeholderResId, @DrawableRes int errorResId, @NonNull ImageView target) {
//        if (file == null) {
//            target.setImageDrawable(context.getResources().getDrawable(placeholderResId));
//        } else {
//            Picasso.with(context)
//                    .load(file)
//                    .placeholder(placeholderResId)
//                    .error(errorResId)
//                    .centerInside()
//                    .fit()
//                    .into(target);
//        }
//    }
//    /**
//     * 以下三个方法是centerInside方式加载带圆角的图片
//     */
//
//    public static void loaderRoundConnerCenterInside(@NonNull Context context, String path,
//                                                     @DrawableRes int placeholderResId, @DrawableRes int errorResId, @NonNull ImageView target,
//                                                     @NonNull int radius, @NonNull int margin) {
//        if (path == null) {
//            target.setImageDrawable(context.getResources().getDrawable(placeholderResId));
//        } else {
//            Picasso.with(context)
//                    .load(checkAndHandleUrl(path))
//                    .placeholder(placeholderResId)
//                    .error(errorResId)
//                    .transform(new RoundedCornersTransformation(DensityUtil.dip2px(context, radius), margin))
//                    .centerInside()
//                    .fit()
//                    .into(target);
//        }
//    }
//    public static void loaderRoundConnerCenterInside(@NonNull Context context, int resourceId,
//                                                     @DrawableRes int placeholderResId, @DrawableRes int errorResId, @NonNull ImageView target,
//                                                     @NonNull int radius, @NonNull int margin) {
//        if (resourceId == 0) {
//            target.setImageDrawable(context.getResources().getDrawable(placeholderResId));
//        } else {
//            Picasso.with(context)
//                    .load(resourceId)
//                    .placeholder(placeholderResId)
//                    .error(errorResId)
//                    .transform(new RoundedCornersTransformation(DensityUtil.dip2px(context, radius), margin))
//                    .centerInside()
//                    .fit()
//                    .into(target);
//        }
//    }
//    public static void loaderRoundConnerCenterInside(@NonNull Context context, File file,
//                                                     @DrawableRes int placeholderResId, @DrawableRes int errorResId, @NonNull ImageView target,
//                                                     @NonNull int radius, @NonNull int margin) {
//        if (file == null) {
//            target.setImageDrawable(context.getResources().getDrawable(placeholderResId));
//        } else {
//            Picasso.with(context)
//                    .load(file)
//                    .placeholder(placeholderResId)
//                    .error(errorResId)
//                    .transform(new RoundedCornersTransformation(DensityUtil.dip2px(context, radius), margin))
//                    .centerInside()
//                    .fit()
//                    .into(target);
//        }
//    }
//    /**
//     * 以下三个方法是centerInside方式加载圆形的图片
//     */
//    public static void loaderCircleCenterInside(@NonNull Context context, String path,
//                                                @DrawableRes int placeholderResId, @DrawableRes int errorResId, @NonNull ImageView target) {
//        if (path == null || path.trim().isEmpty()) {
//            target.setImageDrawable(context.getResources().getDrawable(placeholderResId));
//        } else {
//            Picasso.with(context)
//                    .load(path)
//                    .placeholder(placeholderResId)
//                    .error(errorResId)
//                    .transform(new CropCircleTransformation())
//                    .centerInside()
//                    .fit()
//                    .into(target);
//        }
//    }
//
//    public static void loaderCircleCenterInside(@NonNull Context context, @NonNull int resourceId,
//                                                @DrawableRes int placeholderResId, @DrawableRes int errorResId, @NonNull ImageView target) {
//
//        if (resourceId == 0) {
//            target.setImageDrawable(context.getResources().getDrawable(placeholderResId));
//        } else {
//            Picasso.with(context)
//                    .load(resourceId)
//                    .placeholder(placeholderResId)
//                    .error(errorResId)
//                    .transform(new CropCircleTransformation())
//                    .centerInside()
//                    .fit()
//                    .into(target);
//        }
//    }
//
//    public static void loaderCircleCenterInside(@NonNull Context context, File file,
//                                                @DrawableRes int placeholderResId, @DrawableRes int errorResId, @NonNull ImageView target) {
//        if (file == null) {
//            target.setImageDrawable(context.getResources().getDrawable(placeholderResId));
//        } else {
//            Picasso.with(context)
//                    .load(file)
//                    .placeholder(placeholderResId)
//                    .error(errorResId)
//                    .transform(new CropCircleTransformation())
//                    .centerInside()
//                    .fit()
//                    .into(target);
//        }
//    }
}
