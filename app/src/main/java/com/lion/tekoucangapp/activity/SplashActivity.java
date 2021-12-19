package com.lion.tekoucangapp.activity;

import com.lion.lib_common.themvp.presenter.ActivityPresenter;
import com.lion.tekoucangapp.delegate.SplashActDelegate;

public class SplashActivity extends ActivityPresenter<SplashActDelegate> {

    @Override
    protected Class<SplashActDelegate> getDelegateClass() {
        return SplashActDelegate.class;
    }
}
