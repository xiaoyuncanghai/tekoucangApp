package com.lion.tekoucangapp;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Process;
import android.os.Vibrator;

import com.lion.lib_common.base.BaseApplication;
import com.lion.lib_common.constants.URLConstant;
import com.lion.lib_common.rxEasyhttp.EasyHttp;
import com.lion.lib_common.rxEasyhttp.cache.converter.SerializableDiskConverter;
import com.lion.lib_common.rxEasyhttp.model.HttpHeaders;
import com.lion.lib_common.rxEasyhttp.utils.HttpLog;

import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import me.yokeyword.fragmentation.Fragmentation;
import me.yokeyword.fragmentation.helper.ExceptionHandler;

public class MainApplication extends BaseApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public Vibrator mVibrator;
    @Override
    public void onCreate() {
        super.onCreate();
        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        EasyHttp.init(this);
        HttpHeaders headers = new HttpHeaders();
        /*if (SPHelper.getString("token", "", true) != "") {
            //token不为null的时候设置公共请求头
            headers.put("Authorization", SPHelper.getString("token", "", true));
        } else {
            headers = null;
        }*/
        EasyHttp.getInstance()
                .debug("yuchao", BuildConfig.DEBUG)
                .setReadTimeOut(60 * 1000)
                .setWriteTimeOut(60 * 1000)
                .setConnectTimeout(60 * 1000)
                .setRetryCount(5)//默认网络不好自动重试3次
                .setRetryDelay(1500)//每次延时500ms重试
                .setRetryIncreaseDelay(1500)//每次延时叠加1500ms
                .setBaseUrl(URLConstant.BASE_URL)
                .addCommonHeaders(headers)  //设置公共的请求头
                .setCacheDiskConverter(new SerializableDiskConverter())//默认缓存使用序列化转化
                .setCacheMaxSize(50 * 1024 * 1024)//设置缓存大小为50M
                .setCacheVersion(1)//缓存版本为1
                .setHostnameVerifier(new UnSafeHostnameVerifier(URLConstant.BASE_URL));
        Fragmentation.builder()
                // 设置 栈视图 模式为 悬浮球模式   SHAKE: 摇一摇唤出   NONE：隐藏
                .stackViewMode(Fragmentation.NONE)
                .debug(BuildConfig.DEBUG)
                // 在遇到After onSaveInstanceState时，不会抛出异常，会回调到下面的ExceptionHandler
                .handleException(new ExceptionHandler() {
                    @Override
                    public void onException(Exception e) {

                    }
                })
                .install();
    }

    public class UnSafeHostnameVerifier implements HostnameVerifier {
        private String host;

        public UnSafeHostnameVerifier(String host) {
            this.host = host;
        }

        @Override
        public boolean verify(String hostname, SSLSession session) {
            HttpLog.i("############### verify " + hostname + " " + this.host);
            if (this.host == null || "".equals(this.host) || !this.host.contains(hostname))
                return false;
            return true;
        }
    }

    /**
     * 获取当前进程名称
     *
     * @return processName
     */
    public String getCurrentProcessName() {
        int currentProcessId = Process.myPid();
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo runningAppProcess : runningAppProcesses) {
            if (runningAppProcess.pid == currentProcessId) {
                return runningAppProcess.processName;
            }
        }
        return null;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
