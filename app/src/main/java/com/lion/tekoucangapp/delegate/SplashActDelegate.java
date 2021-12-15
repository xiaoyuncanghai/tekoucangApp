package com.lion.tekoucangapp.delegate;

import android.os.Bundle;

import com.lion.lib_common.themvp.view.AppDelegate;
import com.lion.tekoucangapp.R;

public class SplashActDelegate extends AppDelegate {
    @Override
    public int getRootLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initWidget(Bundle savedInstanceState) {
        super.initWidget(savedInstanceState);
    }
}

