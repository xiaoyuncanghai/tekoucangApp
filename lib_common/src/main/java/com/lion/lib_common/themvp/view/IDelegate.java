/*
 * Copyright (c) 2015, 张涛.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lion.lib_common.themvp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.Toolbar;

import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * View delegate base class
 * 视图层代理的接口协议
 *
 * @author kymjs (http://www.kymjs.com/) on 10/23/15.
 */
public interface IDelegate {
    void create(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    int getOptionsMenuId();

    Toolbar getToolbar();

   /* void onStart();
    void onStop();*/

    View getRootView();

    void initWidget(Bundle savedInstanceState);

    <T extends SupportActivity> T getCurrentActivity();

    <T extends SupportActivity> void setActivity(T t);

    void loadMultipleRootFragment(int containerId, int showPosition, SupportFragment... toFragments);
    void showHideFragment(SupportFragment showFragment);
    <T extends SupportFragment> T findFragment(Class<T> fragmentClass);

    void setTitle(String text);
    void setLeft(String text);
    void setRight(String text);
}
