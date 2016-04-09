package Cache;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.Log;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by xiao on 2016/3/6.
 * 图片缓存(ImageLorder单独使用起不到缓存效果)
 */
public class BitmapCache implements ImageLoader.ImageCache {
    public LruCache<String,Bitmap> cache;
    public int maxMemory = (int) (( Runtime.getRuntime().maxMemory())/1024);
    public int cacheSize = maxMemory/8;

    /**
     * 在构造方法中实例化LruCache
     */
    public BitmapCache() {
        cache = new LruCache<String, Bitmap>(cacheSize){
            /**
             * sizeof的作用是计算缓存对象的大小
             * @param key
             * @param value
             * @return
             */
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes()*value.getHeight()/1024;
            }
        };
    }

    @Override
    public Bitmap getBitmap(String url) {
        Log.e("Bitmap","++++++++++++"+url);
        return cache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        Log.e("Bitmap","-------------"+cache.put(url, bitmap));
            cache.put(url,bitmap);
    }
}
