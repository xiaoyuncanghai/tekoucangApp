package com.lion.homepage.data;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;
import java.util.List;

public class HomePageDataBean implements MultiItemEntity {
    private int type;
    public void setType(int type) {
        this.type = type;
    }
    @Override
    public int getItemType() {
        return type;
    }

    public static final int TYPE_HOME_PAGE_BANNER = 0;
    public static final int TYPE_HOME_PAGE_CATEGORY = 1;
    public static final int TYPE_HOME_PAGE_SHARE = 2;
    public static final int TYPE_HOME_PAGE_PRODUCT_LIST = 3;
    public static final int TYPE_HOME_PAGE_CLEAR_TITLE = 4;
    public static final int TYPE_HOME_PAGE_CLEAR_PRODUCT = 5;
    public static final int TYPE_HOME_PAGE_VIP_TITLE = 6;
    public static final int TYPE_HOME_PAGE_VIP_PRODUCT = 7;

    private ArrayList<BannerData> bannerDataList;

    public List<BannerData> getBannerDataList() {
        return bannerDataList;
    }

    public void setBannerDataList(ArrayList<BannerData> bannerDataList) {
        this.bannerDataList = bannerDataList;
    }

    private int menu_id;
    private String menu_name;
    private String menu_pic;
    private String menu_url;
    private String menu_show;
    private String menu_wapUrl;
    private String menu_appImage;
    private String menu_appTitle;
    private String menuAppCatid;

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_pic() {
        return menu_pic;
    }

    public void setMenu_pic(String menu_pic) {
        this.menu_pic = menu_pic;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public String getMenu_show() {
        return menu_show;
    }

    public void setMenu_show(String menu_show) {
        this.menu_show = menu_show;
    }

    public String getMenu_wapUrl() {
        return menu_wapUrl;
    }

    public void setMenu_wapUrl(String menu_wapUrl) {
        this.menu_wapUrl = menu_wapUrl;
    }

    public String getMenu_appImage() {
        return menu_appImage;
    }

    public void setMenu_appImage(String menu_appImage) {
        this.menu_appImage = menu_appImage;
    }

    public String getMenu_appTitle() {
        return menu_appTitle;
    }

    public void setMenu_appTitle(String menu_appTitle) {
        this.menu_appTitle = menu_appTitle;
    }

    public String getMenuAppCatid() {
        return menuAppCatid;
    }

    public void setMenuAppCatid(String menuAppCatid) {
        this.menuAppCatid = menuAppCatid;
    }

    private String subTitle;
    private int categoryId;

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    private int clearProductId;
    private String clearProductImg;
    private double clearProductPrice;

    public int getClearProductId() {
        return clearProductId;
    }

    public void setClearProductId(int clearProductId) {
        this.clearProductId = clearProductId;
    }

    public String getClearProductImg() {
        return clearProductImg;
    }

    public void setClearProductImg(String clearProductImg) {
        this.clearProductImg = clearProductImg;
    }

    public double getClearProductPrice() {
        return clearProductPrice;
    }

    public void setClearProductPrice(double clearProductPrice) {
        this.clearProductPrice = clearProductPrice;
    }

    private int vipProductId;
    private String vipProductImg;
    private String vipProductContent;
    private double vipProductPrice;
    private double normalProductPrice;

    public int getVipProductId() {
        return vipProductId;
    }

    public void setVipProductId(int vipProductId) {
        this.vipProductId = vipProductId;
    }

    public String getVipProductImg() {
        return vipProductImg;
    }

    public void setVipProductImg(String vipProductImg) {
        this.vipProductImg = vipProductImg;
    }

    public String getVipProductContent() {
        return vipProductContent;
    }

    public void setVipProductContent(String vipProductContent) {
        this.vipProductContent = vipProductContent;
    }

    public double getVipProductPrice() {
        return vipProductPrice;
    }

    public void setVipProductPrice(double vipProductPrice) {
        this.vipProductPrice = vipProductPrice;
    }

    public double getNormalProductPrice() {
        return normalProductPrice;
    }

    public void setNormalProductPrice(double normalProductPrice) {
        this.normalProductPrice = normalProductPrice;
    }

    private String productImage;
    private String productContent;
    private String productOutTime;
    private double productPrice;
    private double productMarketPrice;
    private double productScorePrice;
    private int saleNum;
    private int stoke;

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    public String getProductOutTime() {
        return productOutTime;
    }

    public void setProductOutTime(String productOutTime) {
        this.productOutTime = productOutTime;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductMarketPrice() {
        return productMarketPrice;
    }

    public void setProductMarketPrice(double productMarketPrice) {
        this.productMarketPrice = productMarketPrice;
    }

    public double getProductScorePrice() {
        return productScorePrice;
    }

    public void setProductScorePrice(double productScorePrice) {
        this.productScorePrice = productScorePrice;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public int getStoke() {
        return stoke;
    }

    public void setStoke(int stoke) {
        this.stoke = stoke;
    }
}
