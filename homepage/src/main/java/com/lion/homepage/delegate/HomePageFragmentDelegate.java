package com.lion.homepage.delegate;

import android.os.Bundle;

import com.lion.homepage.R;
import com.lion.lib_common.themvp.view.AppDelegate;

public class HomePageFragmentDelegate extends AppDelegate {

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_home_page;
    }

    @Override
    public void initWidget(Bundle savedInstanceState) {
        super.initWidget(savedInstanceState);

    }


}
