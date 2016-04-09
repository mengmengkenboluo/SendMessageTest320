package com.Bean;

/**
 * Created by xiao on 2015/11/20.
 */
public class ListViewItemBean {
    public int getPicrure() {
        return picrure;
    }

    public void setPicrure(int picrure) {
        this.picrure = picrure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int picrure ;
    public String name ;
    public String detail;
    public String sale;
    public String price;
    public String distance;

    public ListViewItemBean(int picrure, String name, String detail, String sale, String price, String distance) {
        this.picrure = picrure;
        this.name = name;
        this.detail = detail;
        this.sale = sale;
        this.price = price;
        this.distance = distance;
    }
}
