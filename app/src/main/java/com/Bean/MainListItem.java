package com.Bean;

import android.support.v4.view.ViewPager;
import android.webkit.WebView;

/**
 * Created by xiao on 2015/11/19.
 * ListView的五种子Item
 */
public class MainListItem {
    public static final int Type_ViewPager = 0;
    public static final int Type_WebView_1 = 1;
    public static final int Type_WebView_2 =2;
    public static final int Type_WebView_3 =3;
    public static final int Type_ListItem=4;
    public static final int Type_Count =5;
    private String Itemname;
    private int type;

    public MainListItem(String name, int type) {

        this.Itemname = name;
        this.type = type;
    }

    public int getType() {
        return type;
    }


    public String getItemName() {
        return Itemname;
    }

}
