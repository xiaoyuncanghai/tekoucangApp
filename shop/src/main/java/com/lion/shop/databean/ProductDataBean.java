package com.lion.shop.databean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class ProductDataBean implements MultiItemEntity {

    public final static int HEADER_ITEM = 0;
    public final static int BODY_ITEM = 1;
    private int itemType;
    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int type) {
        this.itemType = type;
    }

    private String header;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
    private String imgUrl;
    private String title;
    private double price;
    private double outPrice;
    private String time;
    private int cateId;
    private int stoke;

    public int getStoke() {
        return stoke;
    }

    public void setStoke(int stoke) {
        this.stoke = stoke;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOutPrice() {
        return outPrice;
    }

    public void setOutPrice(double outPrice) {
        this.outPrice = outPrice;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
