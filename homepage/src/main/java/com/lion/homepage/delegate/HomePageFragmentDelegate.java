package com.lion.homepage.delegate;

import android.os.Bundle;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import com.lion.homepage.R;
import com.lion.homepage.adapter.HomePageAdapter;
import com.lion.homepage.data.HomePageDataBean;
import com.lion.lib_common.themvp.view.AppDelegate;

import java.util.ArrayList;

public class HomePageFragmentDelegate extends AppDelegate {

    private RecyclerView rcy_home_page;
    private HomePageAdapter homePageAdapter;
    private ArrayList<HomePageDataBean> homePageItemList = new ArrayList<HomePageDataBean>();

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_home_page;
    }

    @Override
    public void initWidget(Bundle savedInstanceState) {
        super.initWidget(savedInstanceState);
        rcy_home_page = get(R.id.rcy_home_page);
        homePageAdapter = new HomePageAdapter(getActivity(), homePageItemList);
        rcy_home_page.setAdapter(homePageAdapter);
        rcy_home_page.setItemAnimator(new DefaultItemAnimator());

    }
}
