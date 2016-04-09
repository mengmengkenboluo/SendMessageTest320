package com.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.Bean.CityBean;
import com.Json.JsonTools;
import com.example.xiao.sendmessagetest.R;
import com.http.HttpUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiao on 2015/11/21.
 */
public class CityGridAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private TextView  mLoction;
    private Context mContext;
    private List<CityBean> mCities;
    public CityGridAdapter(Context context,List<CityBean> cities){
        this.mContext =context;
        this.mCities = cities;
    }
    @Override
    public int getCount() {
        return mCities.size();
    }
    @Override
    public Object getItem(int position) {
        return mCities.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView =View.inflate(mContext,R.layout.items_grid_popwindow,null);
        mLoction = (TextView) convertView.findViewById(R.id.loction_area);
        mLoction.setText(mCities.get(position).getShort_name());
        return convertView;
    }
}
