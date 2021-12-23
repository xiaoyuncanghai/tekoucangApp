package com.lion.homepage.data;

import com.chad.library.adapter.base.entity.MultiItemEntity;

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
}
