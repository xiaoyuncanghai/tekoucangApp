package com.lion.tekoucangapp.delegate;

import android.os.Bundle;

import com.lion.circle.CircleFragment;
import com.lion.classify.ClassifyFragment;
import com.lion.homepage.HomePageFragment;
import com.lion.lib_common.themvp.view.AppDelegate;
import com.lion.mine.MineFragment;
import com.lion.shop.ShopFragment;
import com.lion.tekoucangapp.R;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActDelegate extends AppDelegate {
    public PageNavigationView pageNavigationView;
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOURTH = 3;
    public static final int FIFTH = 4;

    private SupportFragment[] mFragments = new SupportFragment[5];
    private NavigationController navigationController;

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initWidget(Bundle savedInstanceState) {
        super.initWidget(savedInstanceState);
        if (savedInstanceState == null) {
            mFragments[FIRST] = HomePageFragment.newInstance();
            mFragments[SECOND] = ClassifyFragment.newInstance();
            mFragments[THIRD] = ShopFragment.newInstance();
            mFragments[FOURTH] = CircleFragment.newInstance();
            mFragments[FIFTH] = MineFragment.newInstance();
            loadMultipleRootFragment(R.id.main_content, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOURTH],
                    mFragments[FIFTH]
            );
        } else {
            mFragments[FIRST] = findFragment(HomePageFragment.class);
            mFragments[SECOND] = findFragment(ClassifyFragment.class);
            mFragments[THIRD] = findFragment(ShopFragment.class);
            mFragments[FOURTH] = findFragment(CircleFragment.class);
            mFragments[FIFTH] = findFragment(MineFragment.class);
        }
        initView();
    }

    private void initView() {
        pageNavigationView = get(R.id.bottom_tab);
        navigationController = pageNavigationView.material()
                .addItem(R.drawable.ic_homepage, R.drawable.ic_homepage_press, "首页")
                .addItem(R.drawable.ic_category, R.drawable.ic_category_press, "分类")
                .addItem(R.drawable.ic_category, R.drawable.ic_category_press, "开店")
                .addItem(R.drawable.ic_circle, R.drawable.ic_circle_press, "发圈")
                .addItem(R.drawable.ic_mine, R.drawable.ic_mine_press, "我的")
                .build();
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                showHideFragment(mFragments[index]);
            }

            @Override
            public void onRepeat(int index) {
            }
        });
    }

    public HomePageFragment getHomepageFragment(){
        return findFragment(HomePageFragment.class);
    }

    public ClassifyFragment getClassifyFragment() {
        return findFragment(ClassifyFragment.class);
    }

    public ShopFragment getShopFragment() {
        return findFragment(ShopFragment.class);
    }

    public CircleFragment getCircleFragment() { return findFragment(CircleFragment.class); }

    public MineFragment getMineFragment() {
        return findFragment(MineFragment.class);
    }

}
