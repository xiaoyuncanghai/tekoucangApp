package com.lion.classify.presenter;

import com.lion.classify.listener.ViewCallBack;

public abstract class CommonPresenter {

    protected ViewCallBack mViewCallBack;

    public void add(ViewCallBack viewCallBack) {
        this.mViewCallBack = viewCallBack;
    }

    public void remove() {
        this.mViewCallBack = null;
    }

    protected abstract void getData();
}
