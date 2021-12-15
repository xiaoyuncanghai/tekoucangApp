package com.lion.lib_common.delegate;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;

import com.lion.lib_common.R;
import com.lion.lib_common.constants.Constant;
import com.lion.lib_common.themvp.view.AppDelegate;
import com.lion.lib_common.util.FileUtils;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class WebViewActDelegate extends AppDelegate {

    private WebView wv_webView;
    private String webUrl = "http://shop.tekoucang.top";
    private String imgUrl;
    private ValueCallback<Uri> mUploadMessage;
    private ValueCallback<Uri[]> mUploadCallbackAboveL;
    private final int RESULT_CODE_PICK_FROM_ALBUM_BELLOW_LOLLILOP = 1;
    private final int RESULT_CODE_PICK_FROM_ALBUM_ABOVE_LOLLILOP = 2;
    String compressPath = "";

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_webview;
    }

    @Override
    public void initWidget(Bundle savedInstanceState) {
        super.initWidget(savedInstanceState);
        wv_webView = get(R.id.wv_webView);
        initX5Config();
        initData();
    }

    private void initX5Config() {
        WebSettings webSetting = wv_webView.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setAllowFileAccess(true);
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSetting.setSupportZoom(true);
        webSetting.setBuiltInZoomControls(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setSupportMultipleWindows(false);
        webSetting.setLoadWithOverviewMode(true);
        webSetting.setAppCacheEnabled(true);
        webSetting.setDatabaseEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setGeolocationEnabled(true);
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
        webSetting.setAppCachePath(getActivity().getDir("appcache", 0).getPath());
        webSetting.setDatabasePath(getActivity().getDir("databases", 0).getPath());
        webSetting.setGeolocationDatabasePath(getActivity().getDir("geolocation", 0)
                .getPath());
        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
    }


    private void initData() {
        webUrl = getActivity().getIntent().getStringExtra(Constant.KEY_WEB_LINK);
        wv_webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("file://")) {
                    wv_webView.getSettings().setJavaScriptEnabled(false);
                } else {
                    wv_webView.getSettings().setJavaScriptEnabled(true);
                }
                if (url.startsWith("weixin") || url.contains("upwrp")) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    getActivity().startActivity(intent);
                    return true;
                }
                String referer = "http://shop.tekoucang.top";
                if (url.contains("https://wx.tenpay.com")) {
                    Map<String, String> extraHeaders = new HashMap<>();
                    extraHeaders.put("Referer", referer);
                    view.loadUrl(url, extraHeaders);
                    referer = url;
                    return true;
                }
                if (url.startsWith("alipays") || url.startsWith("alipay")) {
                    try {
                        Log.d("yuchao", "try in");
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        getActivity().startActivity(intent);
                        return true;
                    } catch (Exception e) {
                        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                                .setMessage("未检测到支付宝客户端，请安装后重试.")
                                .setPositiveButton("立即安装", (dialog12, which) -> {
                                    Uri alipayUrl = Uri.parse("https://d.alipay.com");
                                    getActivity().startActivity(new Intent("android.intent.action.VIEW", alipayUrl));
                                    wv_webView.goBack();
                                }).setNegativeButton("取消", (dialog1, which) -> wv_webView.goBack()).create();
                        dialog.setCancelable(false);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.show();
                    }
                    return true;
                }
                if (!(url.startsWith("http") || url.startsWith("https"))) {
                    return true;
                }
                view.loadUrl(url);
                return true;
            }
        });

        wv_webView.setWebChromeClient(new MyWebChromeClient());
        wv_webView.loadUrl(webUrl);
    }

    class MyWebChromeClient extends WebChromeClient {
        public void openFileChooser(ValueCallback<Uri> uploadMsg,
                                    String acceptType) {
            if (mUploadMessage != null)
                return;
            mUploadMessage = uploadMsg;
            selectImage(RESULT_CODE_PICK_FROM_ALBUM_BELLOW_LOLLILOP);
        }

        public void openFileChooser(ValueCallback<Uri> uploadMsg) {
            openFileChooser(uploadMsg, "");
        }

        // For Android > 4.1.1
        public void openFileChooser(ValueCallback<Uri> uploadMsg,
                                    String acceptType, String capture) {
            openFileChooser(uploadMsg, acceptType);
        }

        public boolean onShowFileChooser(WebView webView,
                                         ValueCallback<Uri[]> filePathCallback,
                                         FileChooserParams fileChooserParams) {
            mUploadCallbackAboveL = filePathCallback;
            selectImage(RESULT_CODE_PICK_FROM_ALBUM_ABOVE_LOLLILOP);
            return true;
        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }
    }

    private void selectImage(int resultCode) {
        compressPath = Environment.getExternalStorageDirectory().getPath() + "/QWB/temp";
        File file = new File(compressPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        compressPath = compressPath + File.separator + "compress.png";
        File image = new File(compressPath);
        if (image.exists()) {
            image.delete();
        }
        Intent intent = new Intent(
                Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        getActivity().startActivityForResult(intent, resultCode);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (mUploadMessage == null && mUploadCallbackAboveL == null) {
            return;
        }
        Uri uri = null;
        switch (requestCode) {
            case RESULT_CODE_PICK_FROM_ALBUM_BELLOW_LOLLILOP:
                uri = afterChosePic(data);
                if (mUploadMessage != null) {
                    mUploadMessage.onReceiveValue(uri);
                    mUploadMessage = null;
                }
                break;
            case RESULT_CODE_PICK_FROM_ALBUM_ABOVE_LOLLILOP:
                try {
                    Uri[] results = null;
                    uri = afterChosePic(data);
                    if (data.getDataString() == null) {
                        results = new Uri[]{uri};
                    } else {
                        results = new Uri[]{Uri.parse(data.getDataString())};
                    }
                    if (uri == null) {
                        mUploadCallbackAboveL.onReceiveValue(new Uri[]{});
                        mUploadCallbackAboveL = null;
                        break;
                    }
                    if (mUploadCallbackAboveL != null && uri != null) {
                        mUploadCallbackAboveL.onReceiveValue(results);
                        mUploadCallbackAboveL = null;
                    }
                } catch (Exception e) {
                    mUploadCallbackAboveL = null;
                    e.printStackTrace();
                }
                break;
        }
    }

    private Uri afterChosePic(Intent data) {
        if (data == null) {
            return null;
        }
        String path = getRealFilePath(data.getData());
        String[] names = path.split("\\.");
        String endName = null;
        if (names != null) {
            endName = names[names.length - 1];
        }
        if (endName != null) {
            compressPath = compressPath.split("\\.")[0] + "." + endName;
        }
        File newFile;
        try {
            newFile = FileUtils.compressFile(path, compressPath);
        } catch (Exception e) {
            newFile = null;
        }
        return Uri.fromFile(newFile);
    }

    public String getRealFilePath(final Uri uri) {
        if (null == uri) {
            return null;
        }
        final String scheme = uri.getScheme();
        String data = null;
        if (scheme == null) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_FILE.equals(scheme)) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
            Cursor cursor = getActivity().getContentResolver().query(uri,
                    new String[]{MediaStore.Images.ImageColumns.DATA}, null, null, null);
            if (null != cursor) {
                if (cursor.moveToFirst()) {
                    int index = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATA);
                    if (index > -1) {
                        data = cursor.getString(index);
                    }
                }
                cursor.close();
            }
        }
        return data;
    }

}
