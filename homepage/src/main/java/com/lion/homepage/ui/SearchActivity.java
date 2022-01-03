package com.lion.homepage.ui;

import android.os.Bundle;

import com.lion.homepage.delegate.SearchActDelegate;
import com.lion.lib_common.themvp.presenter.ActivityPresenter;

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
