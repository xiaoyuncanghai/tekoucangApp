package com.lion.tekoucangapp.delegate;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.apkfuns.logutils.LogUtils;
import com.lion.circle.CircleFragment;
import com.lion.classify.ClassifyFragment;
import com.lion.homepage.HomePageFragment;
import com.lion.lib_common.themvp.view.AppDelegate;
import com.lion.lib_common.util.StatusBarUtil;
import com.lion.lib_common.util.Utils;
import com.lion.mine.MineFragment;
import com.lion.shop.ShopFragment;
import com.lion.tekoucangapp.R;
import com.next.easynavigation.view.EasyNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class MainActDelegate extends AppDelegate {

    private List<Fragment> fragments = new ArrayList<>();
    private EasyNavigationBar navigationBar;
    private String[] tabText = {"首页", "分类", "发圈", "我的"};
    private int[] normalIcon = {R.drawable.ic_homepage,
            R.drawable.ic_category, R.drawable.ic_circle, R.drawable.ic_mine};
    private int[] selectIcon = {R.drawable.ic_homepage_press,
            R.drawable.ic_category_press, R.drawable.ic_circle_press, R.drawable.ic_mine_press};


    @Override
    public int getRootLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initWidget(Bundle savedInstanceState) {
        super.initWidget(savedInstanceState);
        LinearLayout root = get(R.id.root);
        root.setPadding(0,
                Utils.getStatusBarHeight(this.getActivity()) + Utils.dip2px(this.getActivity(), 5f),
                0, Utils.dip2px(this.getActivity(), 10f));
        navigationBar = get(R.id.navigationBar);
        fragments.add(HomePageFragment.newInstance());
        fragments.add(ClassifyFragment.newInstance());
        fragments.add(ShopFragment.newInstance());
        fragments.add(CircleFragment.newInstance());
        fragments.add(MineFragment.newInstance());
        navigationBar.titleItems(tabText)
                .normalIconItems(normalIcon)
                .selectIconItems(selectIcon)
                .fragmentList(fragments)
                .centerImageRes(R.drawable.ic_shop_common)
                .centerTextStr("开店")
                .centerLayoutRule(EasyNavigationBar.RULE_BOTTOM)
                .centerLayoutBottomMargin(0)
                .centerAlignBottom(true)
                .fragmentManager(getCurrentActivity().getSupportFragmentManager())
                .setOnTabClickListener(new EasyNavigationBar.OnTabClickListener() {
                    @Override
                    public boolean onTabSelectEvent(View view, int position) {
                        LogUtils.d("yuchao, position = " + position);
                        return false;
                    }

                    @Override
                    public boolean onTabReSelectEvent(View view, int position) {
                        return false;
                    }

                })
                .setOnCenterTabClickListener(new EasyNavigationBar.OnCenterTabSelectListener() {
                    @Override
                    public boolean onCenterTabSelectEvent(View view) {

                        return false;
                    }
                })
                .canScroll(false)
                .centerAsFragment(true)
                .mode(EasyNavigationBar.NavigationMode.MODE_ADD)
                .build();
    }

    public HomePageFragment getHomepageFragment() {
        return findFragment(HomePageFragment.class);
    }

    public ClassifyFragment getClassifyFragment() {
        return findFragment(ClassifyFragment.class);
    }

    public ShopFragment getShopFragment() {
        return findFragment(ShopFragment.class);
    }

    public CircleFragment getCircleFragment() {
        return findFragment(CircleFragment.class);
    }

    public MineFragment getMineFragment() {
        return findFragment(MineFragment.class);
    }

}
