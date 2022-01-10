package com.lion.homepage.delegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.apkfuns.logutils.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.lion.homepage.R;
import com.lion.homepage.adapter.HomePageAdapter;
import com.lion.homepage.data.BannerData;
import com.lion.homepage.data.HomePageDataBean;
import com.lion.homepage.data.HomePageJsonBean;
import com.lion.homepage.data.ProductItemJsonBean;
import com.lion.homepage.ui.ProductListActivity;
import com.lion.homepage.ui.SearchActivity;
import com.lion.lib_common.constants.ARouterPath;
import com.lion.lib_common.constants.Constant;
import com.lion.lib_common.constants.URLConstant;
import com.lion.lib_common.rxEasyhttp.EasyHttp;
import com.lion.lib_common.rxEasyhttp.callback.SimpleCallBack;
import com.lion.lib_common.rxEasyhttp.exception.ApiException;
import com.lion.lib_common.themvp.view.AppDelegate;

import java.util.ArrayList;
import java.util.List;

import retrofit2.converter.gson.GsonConverterFactory;

public class HomePageFragmentDelegate extends AppDelegate {

    private RecyclerView rcy_home_page;
    private HomePageAdapter homePageAdapter;
    private ArrayList<HomePageDataBean> homePageItemList = new ArrayList<>();
    private ArrayList<HomePageDataBean> homePageProductList = new ArrayList<>();
    private ArrayList<HomePageDataBean> homePageList = new ArrayList<>();
    private LinearLayout root_home;

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_home_page;
    }

    @Override
    public void initWidget(Bundle savedInstanceState) {
        super.initWidget(savedInstanceState);
        rcy_home_page = get(R.id.rcy_home_page);
        rcy_home_page.setLayoutManager(new GridLayoutManager(this.getActivity(), 20,
                GridLayoutManager.VERTICAL, false));
        root_home = get(R.id.root_home);
        homePageAdapter = new HomePageAdapter(getActivity(), homePageList);
        rcy_home_page.setAdapter(homePageAdapter);
        rcy_home_page.setItemAnimator(new DefaultItemAnimator());
        requestData();
        initEvent();
    }

    private void initEvent() {
        homePageAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (adapter.getItemViewType(position)) {
                    case HomePageDataBean.TYPE_HOME_PAGE_CATEGORY:
                        ARouter.getInstance().build(ARouterPath.PRODUCT_LIST_PAGE)
                                .withString(Constant.KEY_CATEGORY_ID, homePageList.get(position).getMenuAppCatid())
                                .withString(Constant.KEY_CATEGORY_NAME, homePageList.get(position).getMenu_name())
                                .navigation();
                        break;
                }
            }
        });

        homePageAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.search_bar || view.getId() == R.id.edit_search) {
                    Intent intent = new Intent(getActivity(), SearchActivity.class);
                    getActivity().startActivity(intent);
                }
            }
        });
    }

    /**
     * 请求网络数据
     */
    private void requestData() {
        EasyHttp.get(URLConstant.HOME_PAGE)
                .addConverterFactory(GsonConverterFactory.create())
                .execute(new SimpleCallBack<String>() {

                    @Override
                    public void onError(ApiException e) {
                        Snackbar.make(root_home, e.getMessage(), Snackbar.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String s) {
                        HomePageJsonBean jsonBean = new Gson().fromJson(s, HomePageJsonBean.class);
                        if (jsonBean.getStatus() == 200) {
                            homePageItemList.clear();
                            HomePageJsonBean.DataBean data = jsonBean.getData();
                            if (data.getBanner() != null && data.getBanner().size() > 0) {
                                HomePageDataBean bannerPageData = new HomePageDataBean();
                                bannerPageData.setType(HomePageDataBean.TYPE_HOME_PAGE_BANNER);
                                ArrayList<BannerData> bannerDateList = new ArrayList<BannerData>();
                                for (int i = 0; i < data.getBanner().size(); i++) {
                                    BannerData bannerData = new BannerData();
                                    bannerData.setBannerId(data.getBanner().get(i).getId());
                                    bannerData.setXBannerDataTitle(data.getBanner().get(i).getName());
                                    bannerData.setPic(data.getBanner().get(i).getPic());
                                    bannerData.setXBannerUrl(data.getBanner().get(i).getUrl());
                                    bannerData.setWap_url(data.getBanner().get(i).getWap_url());
                                    bannerDateList.add(bannerData);
                                }
                                bannerPageData.setBannerDataList(bannerDateList);
                                homePageItemList.add(bannerPageData);
                            }
                            if (data.getMenus() != null && data.getMenus().size() > 0) {
                                for (int i = 0; i < data.getMenus().size(); i++) {
                                    HomePageJsonBean.DataBean.MenusBean menuItem = data.getMenus().get(i);
                                    HomePageDataBean menuData = new HomePageDataBean();
                                    menuData.setType(HomePageDataBean.TYPE_HOME_PAGE_CATEGORY);
                                    menuData.setMenu_name(menuItem.getName());
                                    menuData.setMenu_id(menuItem.getId());
                                    menuData.setMenu_appImage(menuItem.getApp_image());
                                    menuData.setMenu_pic(menuItem.getPic());
                                    menuData.setMenu_show(menuItem.getShow());
                                    menuData.setMenu_url(menuItem.getUrl());
                                    menuData.setMenu_appTitle(menuItem.getApp_title());
                                    menuData.setMenu_wapUrl(menuItem.getWap_url());
                                    menuData.setMenuAppCatid(menuItem.getApp_catid());
                                    homePageItemList.add(menuData);
                                }
                            }
                            List<HomePageJsonBean.DataBean.AppBean.LastList> lastList = jsonBean.getData().getApp().getLast_list();
                            if (lastList != null && lastList.size() > 0) {
                                HomePageDataBean subTitleDataBean = new HomePageDataBean();
                                subTitleDataBean.setType(HomePageDataBean.TYPE_HOME_PAGE_CLEAR_TITLE);
                                subTitleDataBean.setSubTitle("最后清空");
                                homePageItemList.add(subTitleDataBean);
                                for (int i = 0; i < lastList.size(); i++) {
                                    HomePageDataBean productDataBean = new HomePageDataBean();
                                    productDataBean.setType(HomePageDataBean.TYPE_HOME_PAGE_CLEAR_PRODUCT);
                                    productDataBean.setClearProductId(lastList.get(i).getId());
                                    productDataBean.setClearProductImg(lastList.get(i).getImage());
                                    productDataBean.setClearProductPrice(lastList.get(i).getPrice());
                                    homePageItemList.add(productDataBean);
                                }
                            }
                            List<HomePageJsonBean.DataBean.AppBean.UserBestListBean> userBestList = jsonBean.getData().getApp().getUser_best_list();
                            if (userBestList != null && userBestList.size() > 0) {
                                HomePageDataBean bestDataBean = new HomePageDataBean();
                                bestDataBean.setType(HomePageDataBean.TYPE_HOME_PAGE_VIP_TITLE);
                                bestDataBean.setSubTitle("会员每日精选");
                                homePageItemList.add(bestDataBean);
                                for (int i = 0; i < userBestList.size(); i++) {
                                    HomePageDataBean productVipDataBean = new HomePageDataBean();
                                    productVipDataBean.setType(HomePageDataBean.TYPE_HOME_PAGE_VIP_PRODUCT);
                                    productVipDataBean.setVipProductId(userBestList.get(i).getId());
                                    productVipDataBean.setVipProductImg(userBestList.get(i).getImage());
                                    productVipDataBean.setVipProductContent(userBestList.get(i).getStore_name());
                                    productVipDataBean.setVipProductPrice(userBestList.get(i).getPrice());
                                    productVipDataBean.setNormalProductPrice(userBestList.get(i).getOt_price());
                                    homePageItemList.add(productVipDataBean);
                                }
                            }
                            homePageList.addAll(0, homePageItemList);
                            homePageAdapter.notifyDataSetChanged();
                        }
                    }
                });

        EasyHttp.get(URLConstant.LIST_PAGE)
                .addConverterFactory(GsonConverterFactory.create())
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Snackbar.make(root_home, e.getMessage(), Snackbar.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String s) {
                        ProductItemJsonBean productJsonBean = new Gson().fromJson(s, ProductItemJsonBean.class);
                        if (productJsonBean.getStatus() == 200) {
                            if (productJsonBean.getData() != null && productJsonBean.getData().size() > 0) {
                                for (int i = 0; i < productJsonBean.getData().size(); i++) {
                                    ProductItemJsonBean.DataBean productJsonItem = productJsonBean.getData().get(i);
                                    HomePageDataBean productBean = new HomePageDataBean();
                                    productBean.setType(HomePageDataBean.TYPE_HOME_PAGE_PRODUCT_LIST);
                                    productBean.setProductImage(productJsonItem.getImage());
                                    productBean.setProductContent(productJsonItem.getStore_name());
                                    productBean.setProductOutTime(productJsonItem.getExpire_time());
                                    productBean.setProductPrice(productJsonItem.getPrice());
                                    productBean.setProductScorePrice(productJsonItem.getUse_integral_price());
                                    productBean.setProductMarketPrice(productJsonItem.getOt_price());
                                    productBean.setStoke(productJsonItem.getStock());
                                    productBean.setSaleNum(productJsonItem.getSales());
                                    homePageProductList.add(productBean);
                                }
                            }
                            homePageList.addAll(homePageProductList);
                            homePageAdapter.notifyDataSetChanged();
                        }

                    }
                });
    }
}
