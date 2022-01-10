package com.lion.homepage.data;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class ProductDataBean implements MultiItemEntity {
    private String imgUrl;
    private String productName;
    private double productMoney;
    private double vipMoney;
    private int saleNum;
    private int productId;

    public static final int TYPE_EMPTY = 0;
    public static final int TYPE_LIST = 1;
    public static final int TYPE_GRID = 1;

    public int getProductId() {
        return productId;
    }

    public double getVipMoney() {
        return vipMoney;
    }

    public void setVipMoney(double vipMoney) {
        this.vipMoney = vipMoney;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductMoney() {
        return productMoney;
    }

    public void setProductMoney(double productMoney) {
        this.productMoney = productMoney;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    private int itemType;

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
