package com.lion.homepage.delegate;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import com.apkfuns.logutils.LogUtils;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.lion.homepage.R;
import com.lion.homepage.adapter.HomePageAdapter;
import com.lion.homepage.data.HomePageDataBean;
import com.lion.homepage.data.HomePageJsonBean;
import com.lion.lib_common.constants.URLConstant;
import com.lion.lib_common.rxEasyhttp.EasyHttp;
import com.lion.lib_common.rxEasyhttp.callback.SimpleCallBack;
import com.lion.lib_common.rxEasyhttp.exception.ApiException;
import com.lion.lib_common.themvp.view.AppDelegate;

import java.util.ArrayList;

import retrofit2.converter.gson.GsonConverterFactory;

public class HomePageFragmentDelegate extends AppDelegate {

    private RecyclerView rcy_home_page;
    private HomePageAdapter homePageAdapter;
    private ArrayList<HomePageDataBean> homePageItemList = new ArrayList<HomePageDataBean>();
    private LinearLayout root_home;

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_home_page;
    }

    @Override
    public void initWidget(Bundle savedInstanceState) {
        super.initWidget(savedInstanceState);
        rcy_home_page = get(R.id.rcy_home_page);
        root_home = get(R.id.root_home);
        homePageAdapter = new HomePageAdapter(getActivity(), homePageItemList);
        rcy_home_page.setAdapter(homePageAdapter);
        rcy_home_page.setItemAnimator(new DefaultItemAnimator());
        requestData();
    }

    /**
     * 请求网络数据
     */
    private void requestData() {
        EasyHttp.get(URLConstant.HOME_PAGE)
                .addConverterFactory(GsonConverterFactory.create())
                .execute(new SimpleCallBack<String>() {

                    @Override
                    public void onError(ApiException e) {
                        Snackbar.make(root_home, e.getMessage(), Snackbar.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String s) {
                        LogUtils.d("yuchao, home page data = " + s);
                        HomePageJsonBean jsonBean = new Gson().fromJson(s, HomePageJsonBean.class);
                    }
                });
    }
}
