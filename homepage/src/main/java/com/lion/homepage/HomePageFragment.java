package com.lion.homepage;

import android.os.Bundle;

import com.lion.homepage.delegate.HomePageFragmentDelegate;
import com.lion.lib_common.themvp.presenter.FragmentPresenter;

public class HomePageFragment extends FragmentPresenter<HomePageFragmentDelegate> {

    @Override
    public void initData() {

    }

    @Override
    protected Class<HomePageFragmentDelegate> getDelegateClass() {
        return HomePageFragmentDelegate.class;
    }

    public static HomePageFragment newInstance() {
        Bundle args = new Bundle();
        HomePageFragment fragment = new HomePageFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
