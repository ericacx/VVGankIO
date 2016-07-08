package com.gank.io.network;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gank.io.R;

/**
 * *          _       _
 * *   __   _(_)_   _(_) __ _ _ __
 * *   \ \ / / \ \ / / |/ _` | '_ \
 * *    \ V /| |\ V /| | (_| | | | |
 * *     \_/ |_| \_/ |_|\__,_|_| |_|
 * <p>
 * Created by vivian on 16/7/7.
 */
//设置统一的默认图片,动画时间
//有不一样的地方可以单用 Glide
public class GlideUtil {

    /**
     * 加载图片
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadPic(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.background_tab)//统一的默认图片
                .crossFade(100)//统一的动画时间
                .into(imageView);
    }

    /**
     * 加载图片
     * @param activity
     * @param url
     * @param imageView
     */
    public static void loadPic(Activity activity, String url, ImageView imageView) {
        Glide.with(activity)
                .load(url)
                .placeholder(R.drawable.background_tab)//统一的默认图片
                .crossFade(100)//统一的动画时间
                .into(imageView);
    }

    /**
     * 加载图片
     * @param activity
     * @param url
     * @param imageView
     */
    public static void loadPic(FragmentActivity activity, String url, ImageView imageView) {
        Glide.with(activity)
                .load(url)
                .placeholder(R.drawable.background_tab)//统一的默认图片
                .crossFade(100)//统一的动画时间
                .into(imageView);
    }

    /**
     * 加载图片
     * @param fragment
     * @param url
     * @param imageView
     */
    public static void loadPic(Fragment fragment, String url, ImageView imageView) {
        Glide.with(fragment)
                .load(url)
                .placeholder(R.drawable.background_tab)//统一的默认图片
                .crossFade(100)//统一的动画时间
                .into(imageView);
    }

    /**
     * 加载图片
     * @param fragment
     * @param url
     * @param imageView
     */
    public static void loadPic(android.app.Fragment fragment, String url, ImageView imageView) {
        Glide.with(fragment)
                .load(url)
                .placeholder(R.drawable.background_tab)//统一的默认图片
                .crossFade(100)//统一的动画时间
                .into(imageView);
    }
}
