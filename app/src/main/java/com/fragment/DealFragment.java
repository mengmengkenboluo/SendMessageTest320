package com.fragment;


import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

import com.Adapter.CityGridAdapter;
import com.Adapter.CityListAdapter;
import com.Adapter.MyListViewAdapter;
import com.Application.MyApplication;
import com.Bean.CityBean;
import com.Bean.MainListItem;
import com.Bean.ShopDeals;
import com.Json.JsonTools;
import com.Loction.MyLocationListener;
import com.NetWork;
import com.Volley.MyBitmap;
import com.Volley.VolleyListener;
import com.Volley.VolleyRequest;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.example.xiao.activity.CityListActivity;
import com.example.xiao.sendmessagetest.R;
import com.http.HttpUtils;
import com.xiao.myself.MyHeaderView;
import com.xiao.myself.MyListView;
import com.xiao.myself.MyViewPager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Cache.MySharedPreferenced;

import static com.example.xiao.sendmessagetest.R.layout.pop_radio;

/**
 * Created by xiao on 2015/11/20.第一个Fragment
 *
 */
public class DealFragment  extends Fragment implements View.OnClickListener,MyListView.MyListViewListener{
    public TextView mLoction;//定位
    public MyListView mListView;
    public MyListViewAdapter adapter;
    public GridView mGridView;
    public GridView mGridView_1;
    public MyViewPager mViewPager;
    public List<GridView> mGridViewDtats;
    public LayoutInflater mInflater;
    public List<MainListItem> mList;
    public Context mContext;
    public Map<String,String> map;
    public Handler mHandler;
    private int start = 0;
    private static int refreshCnt = 0;
    private MyHeaderView mMyHeaderView;
    //记录Y的值
    private float mLastY = -1;
    private Scroller mScroller;
    private AbsListView.OnScrollListener mScrollListener;
    //HeaderView的高度
    private int mHeaderHeight;
    private LinearLayout mHeaderContent;
    //是否可以下拉刷新
    private boolean mEnablePullRefresh =false;
    //是否正在下拉刷新
    private boolean mPullRefreshing =true;
    //城市列表
    private String httpUrl ="http://apis.baidu.com/baidunuomi/openapi/cities";
    //团单详情列表
    private String shopDeal_url ="http://apis.baidu.com/baidunuomi/openapi/shopdeals?shop_id=1745896";
    //团单分类列表
    private String shop_category ="http://apis.baidu.com/baidunuomi/openapi/categories";
    //城市Bean
    private CityBean cityBean;
    //放置城市列表
    private List<CityBean> cityBeanList;
    private List<ShopDeals> shopDealsList;
    private LocationClient mLocationClient;
    private MyLocationListener myListener;
    private BDLocation bdLocation;
    private SharedPreferences preferences;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mInflater = LayoutInflater.from(getActivity());
        mContext = MyApplication.getContext();
        mHandler = new Handler();
        View view = mInflater.inflate(R.layout.fragment_deal,container,false);
        //选择城市按钮
        mLoction = (TextView) view.findViewById(R.id.tv_loction);
        mLoction.setOnClickListener(this);
        mScroller = new Scroller(getActivity());
        //头部动画
        mMyHeaderView = new MyHeaderView(getActivity());
        //头部高度
        mHeaderHeight = mMyHeaderView.getVisiableHeight();
        mHeaderContent = (LinearLayout) mMyHeaderView.findViewById(R.id.ll_header);
        //ListView
        mListView= (MyListView) view.findViewById(R.id.id_listview);
        mListView.addHeaderView(mMyHeaderView,null,false);
        mViewPager = (MyViewPager) view.findViewById(R.id.scroll_viewPager);
        initData();
        Volley_Post_city();
        Volley_Post_deal();
        mLocationClient = new LocationClient(getActivity());
        initLocation();
        bdLocation = new BDLocation();
        myListener = new MyLocationListener();
        mLocationClient.registerLocationListener(myListener);
        mLocationClient.start();
//        mLoction.setText(myListener.sb.getChars());

        preferences= MyApplication.getContext().getSharedPreferences("shop_deal",Context.MODE_WORLD_WRITEABLE);
        adapter = new MyListViewAdapter(mContext, mList, mGridViewDtats,shopDealsList);//将GridView中的数据传入到Adapter
        mListView.setAdapter(adapter);
        mListView.setMyListViewListener(this);
        return view;
    }
    private void Volley_Post_deal() {
        VolleyRequest.RequestPost(mContext,shopDeal_url,"deal",new VolleyListener(mContext,VolleyListener.mListener,VolleyListener.mErrorListener) {
            @Override
            public void onMySuccess(String result) {
                MySharedPreferenced.putShopDeal("shop_deal",result);
                preferences.getString("shop_deal",null);
                shopDealsList = JsonTools.getShopDeals("deal",result);
            }

            @Override
            public void onMyError(VolleyError error) {

            }
        });
    }

    /**
     * 初始化数据
     */
    private void initData() {
        /**
         * ListView的5个Item子类
         */
        MainListItem mainListItem = new MainListItem("viewPager", MainListItem.Type_ViewPager);
        MainListItem mainListItem_1 = new MainListItem("webview_1", MainListItem.Type_WebView_1);
        MainListItem mainListItem_2 = new MainListItem("webview_2", MainListItem.Type_WebView_2);
        MainListItem mainListItem_3 = new MainListItem("webview_3", MainListItem.Type_WebView_3);
        MainListItem mainListItem_4 = new MainListItem("listitem", MainListItem.Type_ListItem);
        cityBeanList = new ArrayList<>();
        shopDealsList = new ArrayList<>();
        mList = new ArrayList<>();
        mList.add(mainListItem);
        mList.add(mainListItem_1);
        mList.add(mainListItem_2);
        mList.add(mainListItem_3);
        mList.add(mainListItem_4);
        mGridViewDtats = new ArrayList<>();
        mGridViewDtats.add((GridView) mInflater.inflate(R.layout.items_viewpager, null));
        mGridViewDtats.add((GridView) mInflater.inflate(R.layout.item1_viewpager, null));
        map =new HashMap<>();
        map.put("apikey","0c8e1e898376804c087eddf37829297f");


    }

    /**
     *
     * @param v 点击定位按钮进行城市切换
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_loction:       //点击定位
                Intent intent = new Intent(getActivity(), CityListActivity.class);
                startActivity(intent);
//               showPopWindows(v);
                break;
            case R.id.ll_change_cities:

        }
    }
    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //对ListView的内容进行刷新
                mList.clear();
                initData();
                adapter = new MyListViewAdapter(getActivity(), mList, mGridViewDtats,shopDealsList);//将GridView中的数据传入到Adapter
                mListView.setAdapter(adapter);
                onLoad();
            }
        },2000);

    }

    /**
     * 下拉加载
     */
    private void onLoad(){
        mListView.stopRefresh();
    }


    /**
     * 配置定位SDK参数
     */
    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span = 1000;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认false，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }




    private void Volley_Post_city(){
        VolleyRequest.RequestPost(mContext,httpUrl,"city",new VolleyListener(mContext,VolleyListener.mListener,VolleyListener.mErrorListener) {
            @Override
            public void onMySuccess(String result) {
                cityBeanList = JsonTools.getCityBean("cities",result);
            }

            @Override
            public void onMyError(VolleyError error) {
                Log.e("DealFragment","error-------------");
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        MyApplication.getRequestQueue().cancelAll("city");
    }
}
