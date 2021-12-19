package com.lion.classify;

import android.os.Bundle;

import com.lion.classify.delegate.ClassifyFgtDelegate;
import com.lion.lib_common.themvp.presenter.FragmentPresenter;

public class ClassifyFragment extends FragmentPresenter<ClassifyFgtDelegate> {
    @Override
    public void initData() {

    }

    @Override
    protected Class<ClassifyFgtDelegate> getDelegateClass() {
        return ClassifyFgtDelegate.class;
    }

    public static ClassifyFragment newInstance() {
        Bundle args = new Bundle();
        ClassifyFragment fragment = new ClassifyFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
