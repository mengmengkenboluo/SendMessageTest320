package com.Volley;

import android.content.Context;
import android.widget.ImageView;

import com.Application.MyApplication;
import com.android.volley.toolbox.ImageLoader;

import Cache.BitmapCache;

/**
 * Created by xiao on 2016/3/6.
 */
public class MyBitmap {
    public static ImageLoader imageLoader;
    public static void MyBitmapCache(String url,ImageView view,int id,int errorId) {
       imageLoader = new ImageLoader(MyApplication.queue, new BitmapCache());
        ImageLoader.ImageListener  listener= ImageLoader.getImageListener(view,id,errorId);
        imageLoader.get(url,listener);
    }
}
