package com.Volley;

import android.content.Context;
import android.graphics.Bitmap;

import com.Application.MyApplication;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiao on 2015/11/21.请求管理
 */
public class VolleyRequest{
    public static StringRequest stringRequest;
    public static ImageRequest imageRequest;
    /**
     * Get方法
     * @param context
     * @param url
     * @param tag
     * @param volleyListener
     */
    public static void RequestGet(Context context,String url,String tag,VolleyListener volleyListener){
        //防止重复请求消耗资源
        MyApplication.getRequestQueue().cancelAll(tag);
        stringRequest = new StringRequest(Request.Method.GET,url,volleyListener.loadingListener(),volleyListener.loadingErrorListener());
        stringRequest.setTag(tag);
        //添加request到RequsetQueue中
        MyApplication.getRequestQueue().add(stringRequest);
        MyApplication.getRequestQueue().start();

    }

    /**
     * Post方法
     * @param context
     * @param url
     * @param tag

     * @param volleyListener
     */
    public static void RequestPost(Context context,String url,String tag,VolleyListener volleyListener){
        MyApplication.getRequestQueue().cancelAll(tag);
        stringRequest = new StringRequest(url,volleyListener.loadingListener(),
                volleyListener.loadingErrorListener()){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("apikey","0c8e1e898376804c087eddf37829297f");
                return map;
            }
        };
        stringRequest.setTag(tag);
        MyApplication.getRequestQueue().add(stringRequest);
        MyApplication.getRequestQueue().start();

    }
    public static void myImageLoad(Context context,String url,VolleyBitmapListener listener){
        imageRequest = new ImageRequest(url,listener.loadingListener(),200,239 ,Bitmap.Config.RGB_565,listener.loadingErrorListener());
        MyApplication.getRequestQueue().add(imageRequest);
        MyApplication.getRequestQueue().start();
    }

}

