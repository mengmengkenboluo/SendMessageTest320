package com.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.Bean.GridViewBean;
import com.example.xiao.sendmessagetest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiao on 2015/11/13.ViewPager的Adapter
 */
public class MyViewPagerAdapter extends PagerAdapter {
    public Context mContext;
    public List<GridView> mDatas = new ArrayList<GridView>(); //ViewPager中的Item
    public MyGridViewAdapter adapter,adapter_1;
    public List<GridViewBean> mBean;//GridView中需要的数据
    public List<GridViewBean> mBean_1;//GridView中需要的数据
    private String info[] = {"美食", "电影", "酒店", "KTV",
            "今日新单", "优惠买单", "旅游", "小吃快餐", "外卖",
            "生活服务", "休闲娱乐", "丽人", "周边游",
            "车票", "购物", "全部分类"
    };
    private int icon[] = {R.drawable.ic_category_0, R.drawable.ic_category_1,
            R.drawable.ic_category_2, R.drawable.ic_category_3,
            R.drawable.ic_category_4, R.drawable.ic_category_5,
            R.drawable.ic_category_6, R.drawable.ic_category_7,
            R.drawable.ic_category_8, R.drawable.ic_category_9,
            R.drawable.ic_category_10, R.drawable.ic_category_11,
            R.drawable.ic_category_12, R.drawable.ic_category_13,
            R.drawable.ic_category_14, R.drawable.ic_category_15,
    };
    public MyViewPagerAdapter(Context context, List<GridView> Gdatas) {
        mContext = context;
        mDatas = Gdatas;
    }
    @Override
    public int getCount() { //返回Item的数量
        return mDatas.size();
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {  //当前view是否属于object
        return view == object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) { //position处的Item
        container.addView(mDatas.get(position));
        mBean = new ArrayList<GridViewBean>();
        mBean_1 = new ArrayList<GridViewBean>();
        if(position==0){
            for (int i = 0; i < info.length/2; i++) {
                GridViewBean bean = new GridViewBean(icon[i],info[i]);//传入数据
                mBean.add(bean);
            }

        adapter = new MyGridViewAdapter(mContext,mBean);
        mDatas.get(position).setAdapter(adapter);
        adapter.notifyDataSetChanged();
        }
        if(position==1){
            for (int i = 8; i < info.length; i++) {
                GridViewBean bean = new GridViewBean(icon[i],info[i]);//传入数据
                mBean_1.add(bean);
            }

            adapter_1 = new MyGridViewAdapter(mContext,mBean_1);
            mDatas.get(position).setAdapter(adapter_1);
            adapter_1.notifyDataSetChanged();
        }
        return mDatas.get(position);
    }
}
