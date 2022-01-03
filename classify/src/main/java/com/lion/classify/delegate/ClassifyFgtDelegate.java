package com.lion.classify.delegate;

import android.os.Bundle;

import com.lion.classify.R;
import com.lion.lib_common.themvp.view.AppDelegate;

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
