package com.lion.classify.delegate;

import android.os.Bundle;

import com.kunminx.linkage.LinkageRecyclerView;
import com.lion.classify.R;
import com.lion.classify.adapter.ClassifyPrimaryAdapterConfig;
import com.lion.classify.adapter.ClassifySecondaryAdapterConfig;
import com.lion.classify.data.ClassifyGroupData;
import com.lion.lib_common.themvp.view.AppDelegate;

import java.util.ArrayList;
import java.util.List;

public class ClassifyFgtDelegate extends AppDelegate {
    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_classify;
    }

    @Override
    public void initWidget(Bundle savedInstanceState) {
        super.initWidget(savedInstanceState);
        //LinkageRecyclerView linkage = get(R.id.linkage);
        //List<ClassifyGroupData> items = new ArrayList<ClassifyGroupData>();
        //linkage.init(items, new ClassifyPrimaryAdapterConfig(), new ClassifySecondaryAdapterConfig());
    }
}
