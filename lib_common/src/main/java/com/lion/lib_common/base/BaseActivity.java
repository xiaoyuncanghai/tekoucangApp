package com.lion.lib_common.base;

import android.os.Bundle;

import androidx.annotation.Nullable;


import me.yokeyword.fragmentation.SupportActivity;

public class BaseActivity extends SupportActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    public String getSimpleName(){
        return "";
    }


}
