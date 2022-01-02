package com.lion.classify.adapter;

import android.content.Context;
import android.view.View;

import com.kunminx.linkage.adapter.viewholder.LinkagePrimaryViewHolder;
import com.kunminx.linkage.contract.ILinkagePrimaryAdapterConfig;

public class ClassifyPrimaryAdapterConfig implements ILinkagePrimaryAdapterConfig {
    @Override
    public void setContext(Context context) {

    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public int getGroupTitleViewId() {
        return 0;
    }

    @Override
    public int getRootViewId() {
        return 0;
    }

    @Override
    public void onBindViewHolder(LinkagePrimaryViewHolder linkagePrimaryViewHolder, boolean b, String s) {

    }

    @Override
    public void onItemClick(LinkagePrimaryViewHolder holder, View view, String title) {

    }
}
