package com.lion.homepage.data;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

public class BannerData extends SimpleBannerInfo {
    private int bannerId ;
    private String name;
    private String url;
    private String pic;
    private String wap_url;

    public int getBannerId() {
        return bannerId;
    }

    public void setBannerId(int bannerId) {
        this.bannerId = bannerId;
    }

    public void setXBannerDataTitle(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getWap_url() {
        return wap_url;
    }

    public void setWap_url(String wap_url) {
        this.wap_url = wap_url;
    }

    @Override
    public String getXBannerUrl() {
        return url;
    }

    public void setXBannerUrl(String url) {
        this.url = url;
    }

    @Override
    public String getXBannerTitle() {
        return name;
    }

    public void setXBannerTitle(String name) {
        this.name = name;
    }
}
