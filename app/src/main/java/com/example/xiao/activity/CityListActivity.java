package com.example.xiao.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.Adapter.CityListAdapter;
import com.Adapter.CityListNameAdapter;
import com.Adapter.GridView_CityAdpater;
import com.Bean.CityBean;
import com.Bean.CityListNameBean;
import com.Json.JsonTools;
import com.Volley.VolleyListener;
import com.Volley.VolleyRequest;
import com.android.volley.VolleyError;
import com.example.xiao.sendmessagetest.R;
import com.xiao.myself.MyGridView;
import com.xiao.myself.MyListView;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xiao on 2016/1/3.
 * 城市列表Activity
 */
public class CityListActivity extends Activity {
    private CityListAdapter cityListAdapter;
    private List<CityBean> mylist;
    private String httpUrl ="http://apis.baidu.com/baidunuomi/openapi/cities";
    private ImageButton imageButton;
    private LinearLayout list_city;
    private MyListView listView;
    private MyGridView grid_hot_city;
    private Context mContext;
    private int hight;
    private List<CityListNameBean> listNameBeans;
    private String[] str_index = { "A", "B", "C", "D", "E", "F", "G", "H","J", "K", "L", "M", "N", "P", "Q","R","S","T"
            , "W", "X", "Y", "Z" };//字母表
    private List<String> hot_city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);
        mylist = new ArrayList<>();
        hot_city = new ArrayList<>();
        hot_city.add("北京");
        hot_city.add("上海");
        hot_city.add("成都");
        hot_city.add("杭州");
        hot_city.add("郑州");
        hot_city.add("武汉");
        hot_city.add("天津");
        hot_city.add("重庆");
        hot_city.add("西安");
        init();
        View view = View.inflate(this,R.layout.item_city,null);
        listView.addHeaderView(view);
        grid_hot_city = (MyGridView) view.findViewById(R.id.hot_cities);
        grid_hot_city.setAdapter(new GridView_CityAdpater(this,hot_city));
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CityListActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        volley_name();
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        hight =list_city.getHeight()/str_index.length;
        getIndexView();
    }
    /**
     * 绘制城市字母表
     */
    public void getIndexView(){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,hight);
        for (int i =0;i<str_index.length;i++){
            final TextView tv = new TextView(this);
            tv.setLayoutParams(params);
            tv.setText(str_index[i]);
            tv.setPadding(5,0,5,0);
            list_city.addView(tv);
            //触摸右侧字母列表
           list_city.setOnTouchListener(new View.OnTouchListener() {
               @Override
               public boolean onTouch(View v, MotionEvent event) {
                   float y = event.getY();
                   int index = (int) (y / hight);
                   if (index > -1 && index < str_index.length) {
                       String key = str_index[index];
                       if (cityListAdapter.getSelector().containsKey(key)) {
                           //
                           int pos = cityListAdapter.getSelector().get(key);
                           if (listView.getHeaderViewsCount() > 0) {
                               listView.setSelectionFromTop(pos +listView.getHeaderViewsCount(), 0);
                           } else {
                               listView.setSelectionFromTop(pos, 0);
                           }
                       }
                   }
                   switch (event.getAction()) {
                       case MotionEvent.ACTION_DOWN:
                          list_city.setBackgroundColor(Color.parseColor("#c0c0c0"));
                           break;
                       case MotionEvent.ACTION_UP:
                          list_city.setBackgroundColor(Color.parseColor("#ffffff"));
                           break;
                       case MotionEvent.ACTION_MOVE:
                           break;
                   }
                   return true;
               }
           });
        }
    }
    private void init() {
        listView = (MyListView)findViewById(R.id.city_listview);
        list_city = (LinearLayout) findViewById(R.id.ll_index);
        imageButton = (ImageButton) findViewById(R.id.close_city_name);
        listNameBeans = new ArrayList<>();
        CityListNameBean linear = new CityListNameBean("linear",CityListNameBean.TYPE_LINEAR);
        CityListNameBean item = new CityListNameBean("item",CityListNameBean.TYPE_ITEM);
        listNameBeans.add(linear);
        listNameBeans.add(item);

    }
    private void volley_name() {
        VolleyRequest.RequestPost(this,httpUrl,"name",new VolleyListener(this,VolleyListener.mListener,VolleyListener.mErrorListener) {
            @Override
            public void onMySuccess(String result) {
                mylist=JsonTools.getCityBean("cities",result);
                for(int i =0;i<mylist.size();i++) {
                    mylist.get(i).setJianxie_pin(String.valueOf(mylist.get(i).getShort_pinyin().charAt(0)));
                }
                LetterComparator comparator = new LetterComparator();
                Collections.sort(mylist, comparator);
                cityListAdapter = new CityListAdapter(mContext,mylist,listNameBeans);
                listView.setAdapter(cityListAdapter);
            }
            @Override
            public void onMyError(VolleyError error) {
                Log.e("CityListActivity","获取城市列表失败");
            }
        });
    }
    //对城市列表进行排序
    public class LetterComparator implements Comparator<CityBean> {
        @Override
        public int compare(CityBean lhs, CityBean rhs) {
            return Collator.getInstance().compare(lhs.getJianxie_pin(),rhs.getJianxie_pin());
        }
    }
}
