package com.lion.circle;

import android.os.Bundle;

import com.lion.circle.delegate.CircleFgtDelegate;
import com.lion.lib_common.themvp.presenter.FragmentPresenter;

public class CircleFragment extends FragmentPresenter<CircleFgtDelegate> {
    @Override
    public void initData() {

    }

    @Override
    protected Class<CircleFgtDelegate> getDelegateClass() {
        return CircleFgtDelegate.class;
    }

    public static CircleFragment newInstance() {
        Bundle args = new Bundle();
        CircleFragment fragment = new CircleFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
