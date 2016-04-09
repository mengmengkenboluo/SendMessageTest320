package com.Bean;

import java.util.List;

/**
 * Created by xiao on 2015/12/31.
 * 团单详情
 */
public class Deals {
    public Deals() {
    }
    private int deal_id;                //商品id
    private List city_ids;              //商品所在全部城市id
    private String title;	    		//商品标题
    private String  min_title;			//商品wap标题
    private String description;			//商品描述
    private String long_title;			//长标题
    private int  cat_id	;			    //一级分类的id
    private List  subcat_ids;			//二级分类的id列表，一个商品可能属于多个二级分类
    private int  publish_time;		    //商品发布时间
    private int  purchase_deadline;	    //商品购买的截止时间
    private int coupon_start_time;	    //券有效开始时间
    private int  coupon_end_time;		//券有效截止时间
    private int  market_price;		    //商品原价，单位是分
    private int  current_price;		    //团购价，单位是分
    private int  promotion_price;		//糯米的当前售卖价格，活动后的价格，单位是分，没有活动价，与团购价相同
    private int   sale_num;			    //商品购买数量
    private boolean  is_reservation_required;	//是否要求预约
    private String image;				//商品大图
    private String  mid_image;			//商品中图
    private String tiny_image;			//商品小图
    private String deal_url	;		    //pc的落地页
    private String deal_murl;			//wap的落地页
    private String buy_contents;        //购买内容
    private String  consumer_tips;	    //消费提示
    private String  buy_details;			//购买详情
    private String  shop_description;	//商户环境
    private List   shop_ids;			//商户列表
    private int  update_time;			//更新时间

    @Override
    public String toString() {
        return "Deals{" +
                "deal_id=" + deal_id +
                ", city_ids=" + city_ids +
                ", title='" + title + '\'' +
                ", min_title='" + min_title + '\'' +
                ", description='" + description + '\'' +
                ", long_title='" + long_title + '\'' +
                ", cat_id=" + cat_id +
                ", subcat_ids=" + subcat_ids +
                ", publish_time=" + publish_time +
                ", purchase_deadline=" + purchase_deadline +
                ", coupon_start_time=" + coupon_start_time +
                ", coupon_end_time=" + coupon_end_time +
                ", market_price=" + market_price +
                ", current_price=" + current_price +
                ", promotion_price=" + promotion_price +
                ", sale_num=" + sale_num +
                ", is_reservation_required=" + is_reservation_required +
                ", image='" + image + '\'' +
                ", mid_image='" + mid_image + '\'' +
                ", tiny_image='" + tiny_image + '\'' +
                ", deal_url='" + deal_url + '\'' +
                ", deal_murl='" + deal_murl + '\'' +
                ", buy_contents='" + buy_contents + '\'' +
                ", consumer_tips='" + consumer_tips + '\'' +
                ", buy_details='" + buy_details + '\'' +
                ", shop_description='" + shop_description + '\'' +
                ", shop_ids=" + shop_ids +
                ", update_time=" + update_time +
                '}';
    }

    public int getDeal_id() {
        return deal_id;
    }

    public void setDeal_id(int deal_id) {
        this.deal_id = deal_id;
    }

    public List getCity_ids() {
        return city_ids;
    }

    public void setCity_ids(List city_ids) {
        this.city_ids = city_ids;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMin_title() {
        return min_title;
    }

    public void setMin_title(String min_title) {
        this.min_title = min_title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLong_title() {
        return long_title;
    }

    public void setLong_title(String long_title) {
        this.long_title = long_title;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public List getSubcat_ids() {
        return subcat_ids;
    }

    public void setSubcat_ids(List subcat_ids) {
        this.subcat_ids = subcat_ids;
    }

    public int getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(int publish_time) {
        this.publish_time = publish_time;
    }

    public int getPurchase_deadline() {
        return purchase_deadline;
    }

    public void setPurchase_deadline(int purchase_deadline) {
        this.purchase_deadline = purchase_deadline;
    }

    public int getCoupon_start_time() {
        return coupon_start_time;
    }

    public void setCoupon_start_time(int coupon_start_time) {
        this.coupon_start_time = coupon_start_time;
    }

    public int getCoupon_end_time() {
        return coupon_end_time;
    }

    public void setCoupon_end_time(int coupon_end_time) {
        this.coupon_end_time = coupon_end_time;
    }

    public int getMarket_price() {
        return market_price;
    }

    public void setMarket_price(int market_price) {
        this.market_price = market_price;
    }

    public int getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(int current_price) {
        this.current_price = current_price;
    }

    public int getPromotion_price() {
        return promotion_price;
    }

    public void setPromotion_price(int promotion_price) {
        this.promotion_price = promotion_price;
    }

    public int getSale_num() {
        return sale_num;
    }

    public void setSale_num(int sale_num) {
        this.sale_num = sale_num;
    }

    public boolean isIs_reservation_required() {
        return is_reservation_required;
    }

    public void setIs_reservation_required(boolean is_reservation_required) {
        this.is_reservation_required = is_reservation_required;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMid_image() {
        return mid_image;
    }

    public void setMid_image(String mid_image) {
        this.mid_image = mid_image;
    }

    public String getTiny_image() {
        return tiny_image;
    }

    public void setTiny_image(String tiny_image) {
        this.tiny_image = tiny_image;
    }

    public String getDeal_url() {
        return deal_url;
    }

    public void setDeal_url(String deal_url) {
        this.deal_url = deal_url;
    }

    public String getDeal_murl() {
        return deal_murl;
    }

    public void setDeal_murl(String deal_murl) {
        this.deal_murl = deal_murl;
    }

    public String getBuy_contents() {
        return buy_contents;
    }

    public void setBuy_contents(String buy_contents) {
        this.buy_contents = buy_contents;
    }

    public String getConsumer_tips() {
        return consumer_tips;
    }

    public void setConsumer_tips(String consumer_tips) {
        this.consumer_tips = consumer_tips;
    }

    public String getBuy_details() {
        return buy_details;
    }

    public void setBuy_details(String buy_details) {
        this.buy_details = buy_details;
    }

    public String getShop_description() {
        return shop_description;
    }

    public void setShop_description(String shop_description) {
        this.shop_description = shop_description;
    }

    public List getShop_ids() {
        return shop_ids;
    }

    public void setShop_ids(List shop_ids) {
        this.shop_ids = shop_ids;
    }

    public int getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(int update_time) {
        this.update_time = update_time;
    }

    public Deals(int deal_id, List city_ids, String title, String min_title, String description, String long_title, int cat_id, List subcat_ids, int publish_time, int purchase_deadline, int coupon_start_time, int coupon_end_time, int market_price, int current_price, int promotion_price, int sale_num, boolean is_reservation_required, String image, String mid_image, String tiny_image, String deal_url, String deal_murl, String buy_contents, String consumer_tips, String buy_details, String shop_description, List shop_ids, int update_time) {
        this.deal_id = deal_id;
        this.city_ids = city_ids;
        this.title = title;

        this.min_title = min_title;
        this.description = description;
        this.long_title = long_title;
        this.cat_id = cat_id;
        this.subcat_ids = subcat_ids;
        this.publish_time = publish_time;
        this.purchase_deadline = purchase_deadline;
        this.coupon_start_time = coupon_start_time;
        this.coupon_end_time = coupon_end_time;
        this.market_price = market_price;
        this.current_price = current_price;
        this.promotion_price = promotion_price;
        this.sale_num = sale_num;
        this.is_reservation_required = is_reservation_required;
        this.image = image;
        this.mid_image = mid_image;
        this.tiny_image = tiny_image;
        this.deal_url = deal_url;
        this.deal_murl = deal_murl;
        this.buy_contents = buy_contents;
        this.consumer_tips = consumer_tips;
        this.buy_details = buy_details;
        this.shop_description = shop_description;
        this.shop_ids = shop_ids;
        this.update_time = update_time;
    }




}
