package com.lion.tekoucangapp.activity;

import com.lion.lib_common.themvp.presenter.ActivityPresenter;
import com.lion.tekoucangapp.delegate.MainActDelegate;

public class MainActivity extends ActivityPresenter<MainActDelegate> {


    @Override
    protected Class<MainActDelegate> getDelegateClass() {
        return MainActDelegate.class;
    }
}