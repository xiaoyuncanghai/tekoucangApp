package com.lion.tekoucangapp;

import com.lion.lib_common.themvp.presenter.ActivityPresenter;

public class MainActivity extends ActivityPresenter<MainActDelegate> {


    @Override
    protected Class<MainActDelegate> getDelegateClass() {
        return MainActDelegate.class;
    }
}