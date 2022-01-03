package com.lion.homepage.delegate;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.apkfuns.logutils.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.lion.homepage.R;
import com.lion.homepage.adapter.SearchAdapter;
import com.lion.homepage.data.ProductDataBean;
import com.lion.homepage.data.SearchBean;
import com.lion.lib_common.constants.URLConstant;
import com.lion.lib_common.rxEasyhttp.EasyHttp;
import com.lion.lib_common.rxEasyhttp.callback.SimpleCallBack;
import com.lion.lib_common.rxEasyhttp.exception.ApiException;
import com.lion.lib_common.themvp.view.AppDelegate;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import java.util.ArrayList;

import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActDelegate extends AppDelegate {

    private EditText et_search;
    private TextView tv_search;
    private RecyclerView rv_search;
    private SmartRefreshLayout srl_search;
    private String keyword;
    private ArrayList<ProductDataBean> searchBeanList = new ArrayList<>();
    private int page = 1;
    private SearchAdapter searchAdapter;

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initWidget(Bundle savedInstanceState) {
        super.initWidget(savedInstanceState);
        et_search = get(R.id.et_search);
        tv_search = get(R.id.tv_search);
        srl_search = get(R.id.srl_search);
        rv_search = get(R.id.rv_search);
        TextView xichenqi = get(R.id.xichenqi);
        TextView jiasiqi = get(R.id.jiasiqi);
        TextView matong = get(R.id.matong);
        TextView reshuiqi = get(R.id.reshuiqi);
        jiasiqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyword = "加湿器";
                searchBeanList.clear();
                page = 1;
                requestList(page, keyword);
            }
        });
        xichenqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyword = "吸尘器";
                searchBeanList.clear();
                page = 1;
                requestList(page, keyword);
            }
        });
        matong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyword = "马桶";
                searchBeanList.clear();
                page = 1;
                requestList(page, keyword);
            }
        });
        reshuiqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyword = "热水器";
                searchBeanList.clear();
                page = 1;
                requestList(page, keyword);
            }
        });
        rv_search.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rv_search.setItemAnimator(new DefaultItemAnimator());
        searchAdapter = new SearchAdapter(getActivity(), searchBeanList);
        searchAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        rv_search.setAdapter(searchAdapter);

        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (et_search.getText().toString().length() > 0) {
                    keyword = et_search.getText().toString();
                    searchBeanList.clear();
                    page = 1;
                    requestList(page, keyword);
                }
                return false;
            }
        });

        tv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_search.getText().toString().length() > 0) {
                    keyword = et_search.getText().toString();
                    searchBeanList.clear();
                    page = 1;
                    requestList(page, keyword);
                }
            }
        });
        srl_search.setEnablePureScrollMode(true);
        srl_search.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                requestList(page, keyword);
            }
        });
    }

    private void requestList(int page, String keyword) {
        EasyHttp.get(URLConstant.LIST_PAGE).params("page", page + "")
                .params("keyword", keyword).addConverterFactory(GsonConverterFactory.create())
                .execute(new SimpleCallBack<String>() {

                    @Override
                    public void onError(ApiException e) {
                        Snackbar.make(srl_search, e.getMessage(), Snackbar.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String s) {
                        LogUtils.d("yuchao, search data = " + s);
                        SearchBean jsonBean = new Gson().fromJson(s, SearchBean.class);
                        if (jsonBean.getStatus() == 200) {
                            if (jsonBean.getData() != null && jsonBean.getData().size() > 0) {
                                for (int i = 0; i < jsonBean.getData().size(); i++) {
                                    ProductDataBean product = new ProductDataBean();
                                    product.setItemType(ProductDataBean.TYPE_LIST);
                                    product.setImgUrl(jsonBean.getData().get(i).getImage());
                                    product.setProductName(jsonBean.getData().get(i).getStore_name());
                                    product.setProductMoney(jsonBean.getData().get(i).getPrice());
                                    product.setSaleNum(jsonBean.getData().get(i).getSales());
                                    product.setProductId(jsonBean.getData().get(i).getId());
                                    searchBeanList.add(product);
                                }
                                searchAdapter.notifyDataSetChanged();
                                if (srl_search.isLoading()) {
                                    srl_search.finishLoadmore();
                                }
                            } else {
                                if (srl_search.isLoadmoreFinished()) {
                                    srl_search.finishLoadmoreWithNoMoreData();
                                }
                                if (page == 1) {
                                    ProductDataBean product = new ProductDataBean();
                                    product.setItemType(ProductDataBean.TYPE_EMPTY);
                                    searchBeanList.clear();
                                    searchBeanList.add(product);
                                    searchAdapter.notifyDataSetChanged();
                                }
                            }
                        }

                    }
                });
    }
}
