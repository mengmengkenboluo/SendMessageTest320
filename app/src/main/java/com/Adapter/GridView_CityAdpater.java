package com.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.Bean.CityBean;
import com.example.xiao.sendmessagetest.R;

import java.util.List;
import java.util.Map;

/**
 * Created by xiao on 2016/3/20.
 * 热门城市GridView设置热门城市
 */
public class GridView_CityAdpater extends BaseAdapter {
    private Context context;
    private Button bn_name;
    private List<String> citynamelist;
    public GridView_CityAdpater(Context context,List<String> list){
        this.context = context;
        this.citynamelist = list;
    }
    @Override
    public int getCount() {
        return citynamelist.size();
    }

    @Override
    public Object getItem(int position) {
        return citynamelist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            convertView=View.inflate(context, R.layout.city_grid_button,null);
            bn_name = (Button) convertView.findViewById(R.id.bn_hot_cities);
            bn_name.setText(citynamelist.get(position));
        return convertView;
    }
}
