package com.lion.homepage.ui;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lion.homepage.delegate.ProductListActDelegate;
import com.lion.lib_common.constants.ARouterPath;
import com.lion.lib_common.themvp.presenter.ActivityPresenter;

@Route(path = ARouterPath.PRODUCT_LIST_PAGE)
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
