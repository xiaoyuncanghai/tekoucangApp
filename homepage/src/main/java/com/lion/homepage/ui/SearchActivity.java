package com.lion.homepage.ui;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lion.homepage.delegate.SearchActDelegate;
import com.lion.lib_common.constants.ARouterPath;
import com.lion.lib_common.themvp.presenter.ActivityPresenter;

@Route(path = ARouterPath.SEARCH_PATH)
public class SearchActivity extends ActivityPresenter<SearchActDelegate> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
    }

    @Override
    protected Class<SearchActDelegate> getDelegateClass() {
        return SearchActDelegate.class;
    }
}
