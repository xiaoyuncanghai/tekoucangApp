package com.lion.lib_common.ui;

import android.content.Intent;

import androidx.annotation.Nullable;

import com.lion.lib_common.delegate.WebViewActDelegate;
import com.lion.lib_common.themvp.presenter.ActivityPresenter;

public class WebViewActivity extends ActivityPresenter<WebViewActDelegate> {
    @Override
    protected Class<WebViewActDelegate> getDelegateClass() {
        return WebViewActDelegate.class;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        viewDelegate.onActivityResult(requestCode, resultCode, data);
    }
}
