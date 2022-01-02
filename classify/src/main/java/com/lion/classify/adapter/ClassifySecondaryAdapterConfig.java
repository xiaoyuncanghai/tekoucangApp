package com.lion.classify.adapter;

import android.content.Context;

import com.kunminx.linkage.adapter.viewholder.LinkageSecondaryFooterViewHolder;
import com.kunminx.linkage.adapter.viewholder.LinkageSecondaryHeaderViewHolder;
import com.kunminx.linkage.adapter.viewholder.LinkageSecondaryViewHolder;
import com.kunminx.linkage.bean.BaseGroupedItem;
import com.kunminx.linkage.contract.ILinkageSecondaryAdapterConfig;
import com.lion.classify.data.ClassifyGroupData;

public class ClassifySecondaryAdapterConfig implements ILinkageSecondaryAdapterConfig<ClassifyGroupData.ItemInfo> {
    @Override
    public void setContext(Context context) {

    }

    @Override
    public int getGridLayoutId() {
        return 0;
    }

    @Override
    public int getLinearLayoutId() {
        return 0;
    }

    @Override
    public int getHeaderLayoutId() {
        return 0;
    }

    @Override
    public int getFooterLayoutId() {
        return 0;
    }

    @Override
    public int getHeaderTextViewId() {
        return 0;
    }

    @Override
    public int getSpanCountOfGridMode() {
        return 0;
    }

    @Override
    public void onBindViewHolder(LinkageSecondaryViewHolder linkageSecondaryViewHolder, BaseGroupedItem<ClassifyGroupData.ItemInfo> baseGroupedItem) {

    }

    @Override
    public void onBindHeaderViewHolder(LinkageSecondaryHeaderViewHolder linkageSecondaryHeaderViewHolder, BaseGroupedItem<ClassifyGroupData.ItemInfo> baseGroupedItem) {

    }

    @Override
    public void onBindFooterViewHolder(LinkageSecondaryFooterViewHolder holder, BaseGroupedItem<ClassifyGroupData.ItemInfo> item) {

    }
}
