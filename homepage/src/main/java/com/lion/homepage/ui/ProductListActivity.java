package com.lion.homepage.ui;

import android.os.Bundle;

import com.lion.homepage.delegate.ProductListActDelegate;
import com.lion.lib_common.themvp.presenter.ActivityPresenter;

public class ProductListActivity extends ActivityPresenter<ProductListActDelegate> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
    }

    @Override
    protected Class<ProductListActDelegate> getDelegateClass() {
        return ProductListActDelegate.class;
    }
}
