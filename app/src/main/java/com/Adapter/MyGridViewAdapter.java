package com.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.Bean.GridViewBean;
import com.example.xiao.sendmessagetest.R;

import java.util.List;

/**
 * Created by xiao on 2015/11/13.Adapter数据与View联系
 */
public class MyGridViewAdapter extends BaseAdapter {
    public Context mContext;
    public TextView name;
    public ImageView icon;
    public List<GridViewBean> mGridViewDatas;//存放GridView的数据
    public MyGridViewAdapter(Context context, List<GridViewBean> datas) {
        mContext = context;
        mGridViewDatas = datas;
    }
    @Override
    public int getCount() { //返回的是Item的数量
        return mGridViewDatas.size();
    }

    @Override
    public Object getItem(int position) { //得到某个位置上的Item
        return mGridViewDatas.get(position);
    }

    @Override
    public long getItemId(int position) { //得到某个位置上的Item的ID
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {//在position位置上显示View
        if (convertView == null) { //如果当前布局为空
            convertView = View.inflate(mContext, R.layout.items_gridview, null);
        }
        name = (TextView) convertView.findViewById(R.id.item_text);
        icon = (ImageView) convertView.findViewById(R.id.item_image);
            GridViewBean bean = mGridViewDatas.get(position);
            name.setText(bean.getName());
            icon.setImageResource(bean.getIconId());
        return convertView;
    }
}
