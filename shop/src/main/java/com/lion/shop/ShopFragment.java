package com.lion.shop;

import android.os.Bundle;

import com.lion.lib_common.themvp.presenter.FragmentPresenter;
import com.lion.shop.delegate.ShopFgtDelegate;

public class ShopFragment extends FragmentPresenter<ShopFgtDelegate> {
    @Override
    public void initData() {

    }

    @Override
    protected Class<ShopFgtDelegate> getDelegateClass() {
        return ShopFgtDelegate.class;
    }

    public static ShopFragment newInstance() {
        Bundle args = new Bundle();
        ShopFragment fragment = new ShopFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
