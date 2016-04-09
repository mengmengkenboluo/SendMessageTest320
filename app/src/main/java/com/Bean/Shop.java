package com.Bean;

/**
 * Created by xiao on 2015/12/31.商户详情接口
 */
public class Shop {
    private int shop_id;                 //商户id
    private  int city_id;                //城市id
    private String shop_name;           //商户名称
    private String shop_url;            //商户PC的url
    private String shop_murl;           //商户移动端url
    private String address;             //商户地址
    private int district_id;            //行政区id
    private int bizarea_id;             //商圈id

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
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

    public int getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    public int getBizarea_id() {
        return bizarea_id;
    }

    public void setBizarea_id(int bizarea_id) {
        this.bizarea_id = bizarea_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpen_time() {
        return open_time;
    }

    public void setOpen_time(String open_time) {
        this.open_time = open_time;
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

    public String getTraffic_info() {
        return traffic_info;
    }

    public void setTraffic_info(String traffic_info) {
        this.traffic_info = traffic_info;
    }

    public int getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(int update_time) {
        this.update_time = update_time;
    }

    public Shop() {

    }

    private String phone;               //商户电话

    public Shop(int shop_id, int city_id, String shop_name, String shop_url, String shop_murl, String address, int district_id, int bizarea_id, String phone, String open_time, float longitude, float latitude, String traffic_info, int update_time) {
        this.shop_id = shop_id;
        this.city_id = city_id;
        this.shop_name = shop_name;
        this.shop_url = shop_url;
        this.shop_murl = shop_murl;
        this.address = address;
        this.district_id = district_id;
        this.bizarea_id = bizarea_id;
        this.phone = phone;
        this.open_time = open_time;
        this.longitude = longitude;
        this.latitude = latitude;
        this.traffic_info = traffic_info;
        this.update_time = update_time;
    }

    private String open_time;           //营业时间
    private float longitude;            //经度
    private float latitude;             //纬度
    private String traffic_info;        //交通信息
    private int update_time;            //更新时间，合作方可根据该字段选择是否更新

    @Override
    public String toString() {
        return "Shop{" +
                "shop_id=" + shop_id +
                ", city_id=" + city_id +
                ", shop_name='" + shop_name + '\'' +
                ", shop_url='" + shop_url + '\'' +
                ", shop_murl='" + shop_murl + '\'' +
                ", address='" + address + '\'' +
                ", district_id=" + district_id +
                ", bizarea_id=" + bizarea_id +
                ", phone='" + phone + '\'' +
                ", open_time='" + open_time + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", traffic_info='" + traffic_info + '\'' +
                ", update_time=" + update_time +
                '}';
    }
}
