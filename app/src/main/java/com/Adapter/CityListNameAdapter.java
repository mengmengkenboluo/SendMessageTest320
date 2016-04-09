package com.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.Bean.CityBean;
import com.example.xiao.sendmessagetest.R;

import java.text.Collator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiao on 2016/3/17.
 */
public class CityListNameAdapter extends BaseAdapter {
    private List<CityBean> mList;//城市列表
    private Context mContext;
    private String[] str_index = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q","R","S","T"
            ,"U", "V", "W", "X", "Y", "Z" };//字母表
    private Map<String,Integer> selector;// 键值是索引表的字母，值为对应在listview中的位置
    private ViewHolder holder;
   public CityListNameAdapter(Context context,List<CityBean> list,Map<String,Integer> selector){
       mList=list;
       mContext=context;
       this.selector=selector;
   }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_cities_list,null);
            holder.tv1 = (TextView) convertView.findViewById(R.id.ll_item_city);
            holder.index = (TextView) convertView.findViewById(R.id.item_city);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        CityBean cityBean = mList.get(position);
        holder.tv1.setText(cityBean.getShort_name());
        String currentStr = cityBean.getJianxie_pin();
        String previewStr = (position - 1) >= 0 ? mList.get(position - 1).getJianxie_pin() : " ";
        if (!previewStr.equals(currentStr)){
            holder.index.setVisibility(View.VISIBLE);
            holder.index.setText(currentStr);
        }
        else {
            holder.index.setVisibility(View.GONE);
        }
        return convertView;
    }
    class ViewHolder{
        TextView tv1;
        TextView index;
    }
    public Map<String, Integer> getSelector() {
        return selector;
    }
}
