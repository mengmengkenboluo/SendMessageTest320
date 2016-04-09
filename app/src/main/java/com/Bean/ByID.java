package com.Bean;

/**
 * Created by xiao on 2015/12/31.
 * 团单ID查询
 */
public class ByID {
    private int shop_id;                 //商户id
    private  long city_id;                //城市id
    private String shop_url;            //商户PC的url
    private String shop_murl;           //商户移动端url

    @Override
    public String toString() {
        return "ByID{" +
                "shop_id=" + shop_id +
                ", city_id=" + city_id +
                ", shop_url='" + shop_url + '\'' +
                ", shop_murl='" + shop_murl + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public long getCity_id() {
        return city_id;
    }

    public void setCity_id(long city_id) {
        this.city_id = city_id;
    }

    public String getShop_url() {
        return shop_url;
    }

    public void setShop_url(String shop_url) {
        this.shop_url = shop_url;
    }

    public String getShop_murl() {
        return shop_murl;
    }

    public void setShop_murl(String shop_murl) {
        this.shop_murl = shop_murl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public ByID() {

    }

    private String address;             //商户地址

    public ByID(int shop_id, long city_id, String shop_url, String shop_murl, String address, String phone, float longitude, float latitude) {
        this.shop_id = shop_id;
        this.city_id = city_id;
        this.shop_url = shop_url;
        this.shop_murl = shop_murl;
        this.address = address;
        this.phone = phone;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    private String phone;               //商户电话
    private float longitude;            //经度
    private float latitude;             //纬度
}
