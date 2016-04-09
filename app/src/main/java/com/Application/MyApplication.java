package com.Application;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.baidu.apistore.sdk.ApiStoreSDK;

/**
 * Created by xiao on 2015/11/14.
 */
public class MyApplication extends Application {
    public static Context context;
    public static Context getContext() {
        return context;
    }
    public static void setContext(Context context) {
        MyApplication.context = context;
    }

    //全局请求队列
    public static RequestQueue queue;
    @Override
    public void onCreate() {
        super.onCreate();
//        ApiStoreSDK.init(this,"0c8e1e898376804c087eddf37829297f");
        context = getApplicationContext();
        //实例化请求队列
        queue = Volley.newRequestQueue(context);
    }
    //暴露一个方法，用于获取RequestQueue
    public static RequestQueue getRequestQueue(){
        return queue;
    }
}
