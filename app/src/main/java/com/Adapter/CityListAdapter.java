package com.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.Bean.CityBean;
import com.Bean.CityListNameBean;
import com.example.xiao.sendmessagetest.R;
import com.xiao.myself.MyGridView;
import com.xiao.myself.MyListView;

import java.text.Collator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiao on 2016/1/3.
 * 城市列表适配器
 */
public class CityListAdapter extends BaseAdapter {
    private Context mContext;
    private List<CityBean> list;//城市列表
    private List<CityListNameBean> mylist;
    private  Map<String,Integer> selector = new HashMap<>();// 键值是索引表的字母，值为对应在listview中的位置
    private String[] str_index = { "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N",  "P", "Q","R","S","T"
            , "W", "X", "Y", "Z" };//字母表
    private ViewHolder holder;
    private MyListView cityListView;
    private ViewHolder_List holder_list;
    public CityListAdapter(Context mContext, List<CityBean> list,List<CityListNameBean> listNameBeans) {
        this.mContext = mContext;
        this.list = list;
        this.mylist = listNameBeans;
        selector = new HashMap<>();
        for(int i =0;i<str_index.length;i++){
            for (int j =0;j<list.size();j++){
                list.get(j).setJianxie_pin(String.valueOf(list.get(j).getShort_pinyin().charAt(0)));
                if (list.get(j).getJianxie_pin().equals(str_index[i].toLowerCase())){
                    selector.put(str_index[i],j);
                    break;
                }

            }
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public List<CityBean> getList() {
        return list;
    }

    public void setList(List<CityBean> list) {
        this.list = list;
    }

    public  Map<String, Integer> getSelector() {
        return selector;
    }

    public void setSelector(Map<String, Integer> selector) {
        this.selector = selector;
    }

    public String[] getIndex() {
        return str_index;
    }

    public void setIndex(String[] index) {
        this.str_index = index;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        holder_list = new ViewHolder_List();
                if (convertView==null){
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_cities_list,null);
                    holder_list.tv1 = (TextView) convertView.findViewById(R.id.ll_item_city);
                    holder_list.index = (TextView) convertView.findViewById(R.id.item_city);
                    convertView.setTag(holder_list);
                }
                else {
                    holder_list= (ViewHolder_List) convertView.getTag();
                }
                    CityBean cityBean = list.get(position);
                    holder_list.tv1.setText(cityBean.getShort_name());//城市名称
                    String currentStr = cityBean.getJianxie_pin();
                    String previewStr = (position - 1) >= 0 ? list.get(position - 1).getJianxie_pin() : " ";
                    if (!previewStr.equals(currentStr)) {
                        holder_list.index.setVisibility(View.VISIBLE);
                        holder_list.index.setText(currentStr);
                    } else {
                        holder_list.index.setVisibility(View.GONE);

                }

//                    holder = new ViewHolder();
//                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_city,null);
//                    holder.current = (Button) convertView.findViewById(R.id.bn_current_city);
//                    holder.recently = (Button) convertView.findViewById(R.id.bn_recenrly_city);
//                    holder.hot_city = (MyGridView) convertView.findViewById(R.id.hot_cities);
//                holder.hot_city.setAdapter(new GridView_CityAdpater(mContext,list));



        return convertView;
    }
    class ViewHolder{
        Button recently;
        Button current;
        MyGridView hot_city;
    }
    class ViewHolder_List{
        TextView tv1;
        TextView index;
    }

    @Override
    public int getItemViewType(int position) {
        if (mylist!= null && position < mylist.size()) {
            return mylist.get(position).getType();
        }

        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        return CityListNameBean.Type_Count;
    }

}
