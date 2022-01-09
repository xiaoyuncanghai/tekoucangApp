package com.lion.tekoucangapp.activity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lion.lib_common.constants.ARouterPath;
import com.lion.lib_common.themvp.presenter.ActivityPresenter;
import com.lion.tekoucangapp.delegate.MainActDelegate;

@Route(path = ARouterPath.MAIN_PATH)
public class MainActivity extends ActivityPresenter<MainActDelegate> {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
    }

    @Override
    protected Class<MainActDelegate> getDelegateClass() {
        return MainActDelegate.class;
    }
}