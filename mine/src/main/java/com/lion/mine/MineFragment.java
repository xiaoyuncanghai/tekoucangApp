package com.lion.mine;

import android.os.Bundle;

import com.lion.lib_common.themvp.presenter.FragmentPresenter;
import com.lion.mine.delegate.MineFgtDelegate;

public class MineFragment extends FragmentPresenter<MineFgtDelegate> {
    @Override
    public void initData() {

    }

    @Override
    protected Class<MineFgtDelegate> getDelegateClass() {
        return MineFgtDelegate.class;
    }

    public static MineFragment newInstance() {
        Bundle args = new Bundle();
        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
