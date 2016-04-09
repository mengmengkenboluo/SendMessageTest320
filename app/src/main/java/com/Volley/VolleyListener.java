package com.Volley;

import android.content.Context;
import android.graphics.Bitmap;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by xiao on 2015/11/21.
 * 网络监听事件
 */
public abstract class VolleyListener {
    public Context mContext;
    public static Response.Listener<String> mListener;
    public static Response.ErrorListener mErrorListener;
    public VolleyListener(Context context,Response.Listener<String> listener,Response.ErrorListener errorListener){
        mContext=context;
        mErrorListener=errorListener;
        mListener=listener;
    }
    public abstract void onMySuccess(String result);
    public abstract void onMyError(VolleyError error);

    /**
     * 请求成功回调
     * @return
     */
    public Response.Listener<String> loadingListener(){
        mListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                onMySuccess(response);
            }
        };
        return mListener;
    }

    /**
     * 请求失败回调
     * @return
     */
    public Response.ErrorListener loadingErrorListener(){
        mErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                    onMyError(error);
            }
        };
        return mErrorListener;
    }

}
