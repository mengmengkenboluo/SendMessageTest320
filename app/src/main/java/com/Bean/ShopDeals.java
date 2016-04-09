package com.Bean;

/**
 * Created by xiao on 2015/12/29.
 * 商户下团单列表
 */
public class ShopDeals {
    private int deal_id;//团单id
    private String image;//图片链接
    private String tiny_image;//小图链接
    private String title;//商户标题
    private String description;//商户描述
    private int comment_num;//用户评论个数
    private String deal_url;//Pc团单详情页
    private String deal_murl;//Wap团详情页
    private int market_price;//市场价格，单位是分
    private int current_price;//售卖价格，单位是分
    private int promotion_price;//活动价格，单位是分
    private int sale_num;//已售团单数量
    private float score;//用户评分

    public ShopDeals() {
    }

    @Override
    public String toString() {
        return "ShopDeals{" +
                "deal_id=" + deal_id +
                ", image='" + image + '\'' +
                ", tiny_image='" + tiny_image + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", market_price=" + market_price +
                ", current_price=" + current_price +
                ", promotion_price=" + promotion_price +
                ", sale_num=" + sale_num +
                ", score=" + score +
                ", comment_num=" + comment_num +
                ", deal_url='" + deal_url + '\'' +
                ", deal_murl='" + deal_murl + '\'' +
                '}';
    }

    public ShopDeals(int deal_id, String image, String tiny_image, String title, String description, int market_price, int current_price, int promotion_price, int sale_num, float score, int comment_num, String deal_url, String deal_murl) {
        this.deal_id = deal_id;
        this.image = image;
        this.tiny_image = tiny_image;
        this.title = title;
        this.description = description;
        this.market_price = market_price;
        this.current_price = current_price;
        this.promotion_price = promotion_price;
        this.sale_num = sale_num;
        this.score = score;
        this.comment_num = comment_num;
        this.deal_url = deal_url;
        this.deal_murl = deal_murl;
    }



    public int getDeal_id() {
        return deal_id;
    }

    public void setDeal_id(int deal_id) {
        this.deal_id = deal_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTiny_image() {
        return tiny_image;
    }

    public void setTiny_image(String tiny_image) {
        this.tiny_image = tiny_image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getComment_num() {
        return comment_num;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
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


}
