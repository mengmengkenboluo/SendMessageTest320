package com.Bean;

/**
 * Created by xiao on 2015/11/21. 用来存放city
 */
public class CityBean {
    private long city_id;//城市id
    private String city_name;//城市名称
    private String short_name;//城市名称简写
    private String city_pinyin;//城市名称拼音
    private String short_pinyin;//城市名称拼音简写
    private String jianxie_pin;;

    public String getJianxie_pin() {
        return jianxie_pin;
    }

    public void setJianxie_pin(String jianxie_pin) {
        this.jianxie_pin = jianxie_pin;
    }

    public CityBean(){

    }
    public long getCity_id() {
        return city_id;
    }

    @Override
    public String toString() {
        return "CityBean{" +
                "city_id=" + city_id +
                ", city_name='" + city_name + '\'' +
                ", short_name='" + short_name + '\'' +
                ", city_pinyin='" + city_pinyin + '\'' +
                ", short_pinyin='" + short_pinyin + '\'' +
                '}';
    }

    public void setCity_id(long city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getCity_pinyin() {
        return city_pinyin;
    }

    public void setCity_pinyin(String city_pinyin) {
        this.city_pinyin = city_pinyin;
    }

    public String getShort_pinyin() {
        return short_pinyin;
    }

    public void setShort_pinyin(String short_pinyin) {
        this.short_pinyin = short_pinyin;
    }

    public CityBean(long city_id, String city_name, String short_name, String city_pinyin, String short_pinyin, String jianxie_pin) {
        this.city_id = city_id;
        this.city_name = city_name;
        this.short_name = short_name;
        this.city_pinyin = city_pinyin;
        this.short_pinyin = short_pinyin;
        this.jianxie_pin = jianxie_pin;
    }

    public CityBean(long city_id, String city_name, String short_name, String city_pinyin, String short_pinyin) {
        super();

        this.city_id = city_id;
        this.city_name = city_name;
        this.short_name = short_name;
        this.city_pinyin = city_pinyin;
        this.short_pinyin = short_pinyin;

    }
}



