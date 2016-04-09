package com.Bean;

/**
 * Created by xiao on 2015/12/31.
 * 团单行政区
 */
public class Districts {
    public Districts(int district_id, String district_name, String biz_area_name, int biz_area_id) {
        this.district_id = district_id;
        this.district_name = district_name;
        this.biz_area_name = biz_area_name;
        this.biz_area_id = biz_area_id;
    }

    public Districts() {
    }

    public int getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public int getBiz_area_id() {
        return biz_area_id;
    }

    public void setBiz_area_id(int biz_area_id) {
        this.biz_area_id = biz_area_id;
    }

    public String getBiz_area_name() {
        return biz_area_name;
    }

    public void setBiz_area_name(String biz_area_name) {
        this.biz_area_name = biz_area_name;
    }

    private int district_id;            //行政区id
        private String district_name;//行政区名称
        private String biz_area_name; //商圈名称
        private int biz_area_id;         //商圈id

    @Override
    public String toString() {
        return "Districts{" +
                "district_id=" + district_id +
                ", district_name='" + district_name + '\'' +
                ", biz_area_name='" + biz_area_name + '\'' +
                ", biz_area_id=" + biz_area_id +
                '}';
    }
}
