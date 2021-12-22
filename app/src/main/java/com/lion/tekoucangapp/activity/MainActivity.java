package com.lion.tekoucangapp.activity;

import android.os.Bundle;

import com.lion.lib_common.themvp.presenter.ActivityPresenter;
import com.lion.tekoucangapp.R;
import com.lion.tekoucangapp.delegate.MainActDelegate;

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