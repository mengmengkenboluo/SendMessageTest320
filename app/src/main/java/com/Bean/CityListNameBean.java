package com.Bean;

/**
 * Created by xiao on 2016/3/18.
 */
public class CityListNameBean {
    public static final int TYPE_ITEM=0;
    public static final int TYPE_LINEAR=1;
    public static final int Type_Count =2;
    private String Itemname;
    public CityListNameBean(String itemname, int type) {
        Itemname = itemname;
        this.type = type;
    }

    public String getItemname() {
        return Itemname;
    }

    public int getType() {
        return type;
    }

    private int type;
}
