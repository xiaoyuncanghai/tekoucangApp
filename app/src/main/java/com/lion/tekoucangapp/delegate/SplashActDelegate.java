package com.lion.tekoucangapp.delegate;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.lion.lib_common.constants.Constant;
import com.lion.lib_common.constants.URLConstant;
import com.lion.lib_common.themvp.view.AppDelegate;
import com.lion.lib_common.ui.WebViewActivity;
import com.lion.lib_common.util.SPHelper;
import com.lion.tekoucangapp.R;
import com.lion.tekoucangapp.activity.MainActivity;

public class SplashActDelegate extends AppDelegate {
    @Override
    public int getRootLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initWidget(Bundle savedInstanceState) {
        super.initWidget(savedInstanceState);
        if (SPHelper.getBoolean(Constant.KEY_FIRST_ENTER, true)) {
            showDialog();
        } else {
            startAct();
        }
    }

    private void showDialog() {
        View view = View.inflate(getActivity(), R.layout.notification_dialog, null);
        final Dialog dialog = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setCancelable(true)
                .create();
        dialog.show();
        TextView textView2 = view.findViewById(R.id.agree_content2);
        TextView textView4 = view.findViewById(R.id.agree_content4);
        TextView agreeButton = view.findViewById(R.id.agree_button);
        TextView cancelButton = view.findViewById(R.id.cancel_button);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        textView2.setOnClickListener(v -> {
            /*ARouter.getInstance().build(ARouterPath.WEB_PATH)
                    .withString(Constant.KEY_WEB_LINK, URLConstant.USER_AGREEMENT)
                    .navigation();*/
            Intent intent = new Intent(getActivity(), WebViewActivity.class);
            intent.putExtra(Constant.KEY_WEB_LINK, URLConstant.USER_AGREEMENT);
            getActivity().startActivity(intent);
        });

        textView4.setOnClickListener(v -> {
            /*ARouter.getInstance().build(ARouterPath.WEB_PATH)
                    .withString(Constant.KEY_WEB_LINK, URLConstant.PRIVACY_POLICY)
                    .navigation();*/
            Intent intent = new Intent(getActivity(), WebViewActivity.class);
            intent.putExtra(Constant.KEY_WEB_LINK, URLConstant.PRIVACY_POLICY);
            getActivity().startActivity(intent);
        });

        agreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                SPHelper.putBoolean(Constant.KEY_FIRST_ENTER, false);
                startAct();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                getActivity().finish();
            }
        });
    }

    public void startAct() {
        new Handler().postDelayed(() -> {
            //ARouter.getInstance().build(ARouterPath.MAIN_PATH).navigation();
            Intent intent = new Intent(getActivity(), MainActivity.class);
            getActivity().startActivity(intent);
            getActivity().finish();
        }, 1000);
    }
}

