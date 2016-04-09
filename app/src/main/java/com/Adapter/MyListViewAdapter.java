package com.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.Bean.MainListItem;
import com.Bean.ShopDeals;
import com.Volley.MyBitmap;
import com.Volley.VolleyBitmapListener;
import com.Volley.VolleyRequest;
import com.android.volley.VolleyError;
import com.example.xiao.sendmessagetest.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiao on 2015/11/13.
 */
public class MyListViewAdapter extends BaseAdapter{
    public Context mContext;
    public MyViewPagerAdapter adapter;
    public ViewPager viewPager;
    public List<MainListItem> mDatas;
    public List<GridView> mGridViewDatas;
    public List<ShopDeals> mShopDeals;
    public List<Bitmap> mylistBitmap;
    public  ListItemHolder holder;
    public MyListViewAdapter(Context context, List<MainListItem> datas, List<GridView> Gdatas,List<ShopDeals> shopDealses) {
        mContext = context;
        mDatas = datas;
        mGridViewDatas = Gdatas;
        mShopDeals = shopDealses;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        Map<String,String> map = new HashMap<>();
        mylistBitmap = new ArrayList<>();
                map.put("apikey","0c8e1e898376804c087eddf37829297f");
        switch (type) {
            case MainListItem.Type_ViewPager: {
                if (convertView == null) {
                    convertView = View.inflate(mContext, R.layout.items_main, null);
                    viewPager =(ViewPager)convertView.findViewById(R.id.scroll_viewPager);
                    adapter = new MyViewPagerAdapter(mContext, mGridViewDatas);
                    viewPager.setAdapter(adapter);
                }
                break;
            }
            case MainListItem.Type_WebView_1: {
                WebViewHolder_1 holder = null;
                if (convertView == null) {
                    holder = new WebViewHolder_1();
                    convertView = View.inflate(mContext, R.layout.item_main_webview_1, null);
                    holder.v1 = (WebView) convertView.findViewById(R.id.webview_1_web_1);
                    holder.v2 = (WebView) convertView.findViewById(R.id.webview_1_web_2);
                    holder.v3 = (WebView) convertView.findViewById(R.id.webview_1_web_3);
                    holder.v4 = (WebView) convertView.findViewById(R.id.webview_1_web_4);
                    holder.tv = (TextView) convertView.findViewById(R.id.webview_1_textview);
                    convertView.setTag(holder);
                }
                else {
                    convertView.getTag();
                }

                break;
            }
            case MainListItem.Type_WebView_2: {
                if (convertView == null) {
                    convertView = View.inflate(mContext, R.layout.item_main_webview_2, null);
                    WebView webView = (WebView) convertView.findViewById(R.id.webview_2);
                    webView.loadUrl("http://apis.baidu.com/baidunuomi/openapi/categories",map);
                }
                break;

            }
            case MainListItem.Type_WebView_3: {
                WebViewHolder_1 holder_1 = null;
                if (convertView == null) {
                    holder_1 = new WebViewHolder_1();
                    convertView = View.inflate(mContext, R.layout.item_main_webview_3, null);
                    holder_1.v1 = (WebView) convertView.findViewById(R.id.webview_3_webview_1);
                    holder_1.v2 = (WebView) convertView.findViewById(R.id.webview_3_webview_2);
                    holder_1.v3 = (WebView) convertView.findViewById(R.id.webview_3_webview_3);
                    holder_1.v4 = (WebView) convertView.findViewById(R.id.webview_3_webview_4);
                    holder_1.v1.loadUrl("http://apis.baidu.com/baidunuomi/openapi/categories",map);
                    holder_1.v2.loadUrl("http://apis.baidu.com/baidunuomi/openapi/categories",map);
                    holder_1.v3.loadUrl("http://apis.baidu.com/baidunuomi/openapi/categories",map);
                    holder_1.v4.loadUrl("http://apis.baidu.com/baidunuomi/openapi/categories",map);
                    convertView.setTag(holder_1);
                }
                else {
                    convertView.getTag();
                }
                break;
            }
            case MainListItem.Type_ListItem: {

                holder = null;
                    if (convertView == null) {
                        holder = new ListItemHolder();
                        convertView = View.inflate(mContext, R.layout.item_main_more, null);
                        holder.picture = (ImageView) convertView.findViewById(R.id.more_image);
                        holder.name = (TextView) convertView.findViewById(R.id.more_name);
                        holder.detail = (TextView) convertView.findViewById(R.id.more_details);
                        holder.distance = (TextView) convertView.findViewById(R.id.more_distance);
                        holder.price = (TextView) convertView.findViewById(R.id.more_price);
                        holder.sale = (TextView) convertView.findViewById(R.id.more_sale);
                        holder.name.setText(mShopDeals.get(0).getTitle());
                        holder.detail.setText(mShopDeals.get(0).getDescription());
                        getImage();
                        holder.price.setText(Integer.toString((mShopDeals.get(0).getCurrent_price())/100));
                        convertView.setTag(holder);
                    } else {
                        convertView.getTag();
                    }

                break;
            }

        }
        return convertView;
    }

    //Item类型数量
    @Override
    public int getViewTypeCount() {
        return MainListItem.Type_Count;
    }

    //Item类型
    @Override
    public int getItemViewType(int position) {
        if (mDatas != null && position < mDatas.size()) {
            return mDatas.get(position).getType();
        }

        return super.getItemViewType(position);
    }

    public class WebViewHolder_1 {
        public WebView v1;
        public WebView v2;
        public WebView v3;
        public WebView v4;
        TextView tv;
    }

    public class ListItemHolder {
        public ImageView picture;
        public TextView name;
        public TextView detail;
        public TextView price;
        public TextView distance;
        public TextView sale;
    }
    public void getImage(){
        VolleyRequest.myImageLoad(mContext, mShopDeals.get(0).getTiny_image(), new VolleyBitmapListener(mContext, VolleyBitmapListener.mListener, VolleyBitmapListener.mErrorListener) {

            @Override
            public void onMySuccess(Bitmap result) {
                MyBitmap.MyBitmapCache(mShopDeals.get(0).getTiny_image(),holder.picture,R.drawable.bg_loading_poi_list,R.drawable.bg_loading_poi_list );
                holder.picture.setImageBitmap(result);
            }

            @Override
            public void onMyError(VolleyError error) {
                Toast.makeText(mContext,"联网出现错误。请重试",Toast.LENGTH_LONG).show();
            }
        });
    }
}
