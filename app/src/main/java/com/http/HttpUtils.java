package com.http;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xiao on 2015/12/6.
 */
public class HttpUtils {
    public static Handler handler;
    private HttpClient mHttpClient;
    private HttpPost mHttpPost;
    private HttpResponse mHttpResponse;
    private String url;
    private HttpEntity mHttpEntity;
    public static HttpURLConnection conn;
    private String path;
    public static Bitmap bitmap;
    public static  InputStream inputStream;
    public  HttpUtils(String url){
        this.url = url;
    }

    /**
     * 获取城市列表
     * @return
     */
    public String  getJsonContent(){
        mHttpClient = new DefaultHttpClient();
        mHttpPost = new HttpPost(url);
        try {
            mHttpPost.setHeader("apikey","0c8e1e898376804c087eddf37829297f");
            mHttpResponse = mHttpClient.execute(mHttpPost);
            mHttpEntity = mHttpResponse.getEntity();
            inputStream = mHttpEntity.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            StringBuffer sb = new StringBuffer();
            while ((line=br.readLine())!=null){
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


public static Bitmap getBitmap(final String path) throws IOException {
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            URL url = null;
            try {
                url = new URL(path);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            conn = null;
            try {
                conn = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            conn.setConnectTimeout(5000);
            try {
                conn.setRequestMethod("GET");
                if (conn.getResponseCode() == 200) {
                    inputStream = conn.getInputStream();
                    Log.e("HttpUtils","inputStream"+inputStream);
                }
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    };
    new Thread(runnable).start();
    return bitmap;
}

}
