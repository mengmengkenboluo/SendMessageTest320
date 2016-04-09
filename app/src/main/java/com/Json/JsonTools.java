package com.Json;

import android.util.Log;

import com.Bean.CityBean;
import com.Bean.ShopDeals;
import com.http.HttpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiao on 2015/12/6.
 * 完成对Json数据的解析
 */
public class JsonTools  {

    public JsonTools(){
    }
    public static List<CityBean> getCityBean(String key,String jsonResult){
        List<CityBean> cityList = new ArrayList<CityBean>();
        try {
            JSONObject object = new JSONObject(jsonResult);
            JSONArray  jsonArray = object.getJSONArray(key);
            for(int i =0;i<jsonArray.length();i++) {
                JSONObject cityObject = jsonArray.getJSONObject(i);
                CityBean cityBean = new CityBean();
                cityBean.setCity_id(cityObject.getLong("city_id"));
                cityBean.setCity_name(cityObject.getString("city_name"));
                cityBean.setShort_name(cityObject.getString("short_name"));
                cityBean.setCity_pinyin(cityObject.getString("city_pinyin"));
                cityBean.setShort_pinyin(cityObject.getString("short_pinyin"));
                cityList.add(cityBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  cityList;

    }
    public static List<ShopDeals> getShopDeals(String key,String jsonResult){
        List<ShopDeals> shopDealsList = new ArrayList<ShopDeals>();
        try {
            JSONObject object = new JSONObject(jsonResult);
            JSONArray  jsonArray = object.getJSONArray(key);
            for(int i =0;i<jsonArray.length();i++) {
                JSONObject shopObject = jsonArray.getJSONObject(i);
                ShopDeals shopDeals = new ShopDeals();
                shopDeals.setDeal_id(shopObject.getInt("deal_id"));
                shopDeals.setImage(shopObject.getString("image"));
                Log.e("JsonTools","image"+shopObject.getString("image"));
                shopDeals.setTiny_image(shopObject.getString("tiny_image"));
                Log.e("JsonTools","tiny_image"+shopObject.getString("tiny_image"));
                shopDeals.setTitle(shopObject.getString("title"));
                shopDeals.setDescription(shopObject.getString("description"));
                shopDeals.setComment_num(shopObject.getInt("comment_num"));
                shopDeals.setDeal_url(shopObject.getString("deal_url"));
                shopDeals.setDeal_murl(shopObject.getString("deal_murl"));
                shopDeals.setMarket_price(shopObject.getInt("market_price"));
                shopDeals.setCurrent_price(shopObject.getInt("current_price"));
                shopDeals.setPromotion_price(shopObject.getInt("promotion_price"));
                shopDeals.setSale_num(shopObject.getInt("sale_num"));
                shopDeals.setScore((float) shopObject.getDouble("score"));
                shopDealsList.add(shopDeals);
             return  shopDealsList;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  null;

    }
}
