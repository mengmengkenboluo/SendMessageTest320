package com.Volley;

import android.content.Context;
import android.graphics.Bitmap;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by xiao on 2016/3/6.
 */
public abstract class VolleyBitmapListener {
    public Context mContext;
    public static Response.Listener<Bitmap> mListener;
    public static Response.ErrorListener mErrorListener;
    public VolleyBitmapListener(Context context,Response.Listener<Bitmap> listener,Response.ErrorListener errorListener){
        mContext=context;
        mErrorListener=errorListener;
        mListener=listener;
    }
    public abstract void onMySuccess(Bitmap result);
    public abstract void onMyError(VolleyError error);

    /**
     * 请求成功回调
     * @return
     */
    public Response.Listener<Bitmap> loadingListener(){
        mListener = new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
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
