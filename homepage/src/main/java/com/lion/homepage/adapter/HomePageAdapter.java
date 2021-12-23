package com.lion.homepage.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lion.homepage.R;
import com.lion.homepage.data.HomePageDataBean;

import java.util.List;

public class HomePageAdapter extends BaseMultiItemQuickAdapter<HomePageDataBean, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    private  Context mContext;
    public HomePageAdapter(Context context, List<HomePageDataBean> data) {
        super(data);
        mContext = context;
        addItemType(HomePageDataBean.TYPE_HOME_PAGE_BANNER, R.layout.home_banner_layout);
        addItemType(HomePageDataBean.TYPE_HOME_PAGE_CATEGORY, R.layout.home_category_layout);
        addItemType(HomePageDataBean.TYPE_HOME_PAGE_SHARE, R.layout.home_share_layout);
        addItemType(HomePageDataBean.TYPE_HOME_PAGE_PRODUCT_LIST, R.layout.home_product_list_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomePageDataBean item) {

    }
}
