package com.xiao.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.xiao.sendmessagetest.R;
import com.xiao.util.ViewHolder;

import java.util.List;

/**
 * Created by xiao on 2015/11/7.通用的Adapter<T>为了适应不同的Bean
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    //可供子类使用
    protected Context mContext;
    protected List<T> mDatas;
    //用于加载布局
    protected LayoutInflater mInflater;
    protected int mLayoutID;
    //将数据集和布局文件传入到CommonAdapter中
    public CommonAdapter(Context context, List<T> datas, int layoutID) {
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mDatas = datas;
        this.mLayoutID = layoutID;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }
    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //初始化ViewHolder
        ViewHolder holder = ViewHolder.get(mContext, convertView, parent, mLayoutID, position);
        //给view添加数据 Bean是通过mDatas的getItem(position)得到的。
        convert(holder, getItem(position));
        return holder.getConvertView();//因为converView是在ViewHolder中进行初始化的
    }
    //必须要实现的方法。传入 ViewHolder和T(当前item的数据集)
    public abstract void convert(ViewHolder holder, T t);
}
