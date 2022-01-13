package com.lion.shop.delegate;

import android.os.Bundle;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.lion.lib_common.constants.URLConstant;
import com.lion.lib_common.rxEasyhttp.EasyHttp;
import com.lion.lib_common.rxEasyhttp.callback.SimpleCallBack;
import com.lion.lib_common.rxEasyhttp.exception.ApiException;
import com.lion.lib_common.themvp.view.AppDelegate;
import com.lion.shop.R;
import com.lion.shop.adapter.ShopAdapter;
import com.lion.shop.databean.ProductDataBean;
import com.lion.shop.databean.ProductJsonBean;

import java.util.ArrayList;

import retrofit2.converter.gson.GsonConverterFactory;

public class ShopFgtDelegate extends AppDelegate {

    private RecyclerView shop_recycle;
    private ShopAdapter homePageAdapter;
    private ArrayList<ProductDataBean> productDataBeans = new ArrayList<>();

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_shop;
    }

    @Override
    public void initWidget(Bundle savedInstanceState) {
        initView();
        initData();
    }

    private void initData() {
        EasyHttp.get(URLConstant.LIST_PAGE).params("type_id", "1")
                .addConverterFactory(GsonConverterFactory.create())
                .execute(new SimpleCallBack<String>(){

                    @Override
                    public void onError(ApiException e) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        ProductJsonBean jsonBean = new Gson().fromJson(s, ProductJsonBean.class);
                        if (jsonBean.getStatus() == 200) {
                            if (jsonBean.getData() != null && jsonBean.getData().size() > 0) {
                                ProductDataBean header = new ProductDataBean();
                                header.setItemType(ProductDataBean.HEADER_ITEM);
                                header.setHeader("今日采购计划");
                                productDataBeans.add(header);
                                for (int i = 0; i < jsonBean.getData().size(); i++) {
                                    ProductDataBean product = new ProductDataBean();
                                    product.setItemType(ProductDataBean.BODY_ITEM);
                                    product.setImgUrl(jsonBean.getData().get(i).getImage());
                                    product.setTitle(jsonBean.getData().get(i).getStore_name());
                                    product.setPrice(jsonBean.getData().get(i).getPrice());
                                    product.setOutPrice(jsonBean.getData().get(i).getOt_price());
                                    product.setTime(jsonBean.getData().get(i).getExpire_time());
                                    product.setStoke(jsonBean.getData().get(i).getStock());
                                    productDataBeans.add(product);
                                }
                                homePageAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                });
    }

    private void initView() {
        shop_recycle = get(R.id.shop_recycle);
        GridLayoutManager manger = new GridLayoutManager(this.getActivity(), 2,
                GridLayoutManager.VERTICAL, false);
        shop_recycle.setLayoutManager(manger);
        homePageAdapter = new ShopAdapter(getActivity(), productDataBeans);
        shop_recycle.setAdapter(homePageAdapter);
        shop_recycle.setItemAnimator(new DefaultItemAnimator());
    }
}