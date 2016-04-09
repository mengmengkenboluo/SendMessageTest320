package com.Bean;

/**
 * Created by xiao on 2015/11/13.用来存放GridView中Item的数据
 */
public class GridViewBean {
    public GridViewBean() {
    }

    public GridViewBean(int iconId,String name) {
        this.name = name;
        this.iconId = iconId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String name;
    public int iconId;
}
