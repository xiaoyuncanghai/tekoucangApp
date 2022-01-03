package com.lion.lib_common.base;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.apkfuns.logutils.LogUtils;
import com.tencent.smtt.sdk.QbSdk;

import java.util.List;


/**
 * 要想使用BaseApplication，必须在组件中实现自己的Application，并且继承BaseApplication；
 * 组件中实现的Application必须在debug包中的AndroidManifest.xml中注册，否则无法使用；
 * 组件的Application需置于java/debug文件夹中，不得放于主代码；
 * 组件中获取Context的方法必须为:Utils.getContext()，不允许其他写法；
 * @name BaseApplication
 */
public class BaseApplication extends MultiDexApplication {

    public static final String ROOT_PACKAGE = "com.yuu1.fulisudi";

    private static BaseApplication sInstance;

    private List<ApplicationDelegate> mAppDelegateList;



    public static BaseApplication getInstance() {
        return sInstance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        LogUtils.getLogConfig()
                .configAllowLog(true)
                .configTagPrefix("yuchao")
                .configShowBorders(true)
                .configFormatTag("%d{HH:mm:ss:SSS} %t %c{-5}");
        QbSdk.setDownloadWithoutWifi(true);
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg0) {
                Log.d("app", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {

            }
        };
        QbSdk.initX5Environment(getApplicationContext(),  cb);
        /*if (Utils.isAppDebug()) {
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);*/
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();

    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }
}
