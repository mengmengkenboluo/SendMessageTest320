package Cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.Application.MyApplication;

/**
 * Created by xiao on 2016/3/21.
 */
public class MySharedPreferenced {
    public static final String SHOP_DEAL="shop_deal";
    public static SharedPreferences.Editor getEditor(){
        SharedPreferences preferences = MyApplication.getContext().getSharedPreferences(SHOP_DEAL, Context.MODE_WORLD_WRITEABLE);
        SharedPreferences.Editor editor = preferences.edit();
        Log.e("MySharedPreference","==============="+preferences);
        return editor;
    }
    public static String putShopDeal(String name,String value){
        SharedPreferences.Editor editor= MySharedPreferenced.getEditor();
        editor.putString(name,value);
        editor.commit();
        return value;
    }
}
