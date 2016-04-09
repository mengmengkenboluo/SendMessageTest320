package com.xiao.util;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * ViewHolder用来存放Item中的控件
 * Created by xiao on 2015/11/7.通用的ViewHolder
 * ViewHolder用来复用convertView
 */
public class ViewHolder {
    //用SpanrseArray来存放View(Item的View)，比Map更有效率
    private SparseArray<View> mViews;
    private Context mContext;
    private int mPosition;
    //显示的View
    private View mConvertView;
    //layoutID是item的layout
    //为空创建，设置layout
    public ViewHolder(Context context,ViewGroup parent,int layoutId,int position){
       this.mContext = context;
       this.mPosition =position;
       this.mViews = new SparseArray<View>();
       mConvertView = LayoutInflater.from(context).inflate(layoutId,parent,false);
       mConvertView.setTag(this);
    }
    //入口方法。判断view是不是存不存在，不存在创建(执行ViewHoler的构造参数进行创建).
    public static ViewHolder get(Context context,View convertview,ViewGroup parent,int layoutId,int position){
        if(convertview==null){
           return new ViewHolder(context,parent,layoutId,position);
        }
        //不为空
        else {
           ViewHolder holder= (ViewHolder) convertview.getTag();
            //position更新
            holder.mPosition = position;
            return holder;
        }
    }
    //根据view的ID从SparseArray中获取view，用于返回ConvertView
    public <T extends View> T getView(int viewId){
        //从SparseArray中获取view
        View view = mViews.get(viewId);
        //如果view不存在，则将当前View存入到SparseArray中
        if(view==null){
            view = mConvertView.findViewById(viewId);
            //存储view的ID和view(ListView或GridView中的控件)
            mViews.put(viewId,view);
        }

        return (T) view;

    }
    //获取View的方法
    public View getConvertView(){
        return mConvertView;
    }
    public ViewHolder setText(int viewID,String text){
        TextView tv = getView(viewID);
        tv.setText(text);
        return this;

    }
    public ViewHolder setImage(int viewID,int imageID){
        ImageView iv = getView(viewID);
        iv.setImageResource(imageID);
        return this;

    }


}
