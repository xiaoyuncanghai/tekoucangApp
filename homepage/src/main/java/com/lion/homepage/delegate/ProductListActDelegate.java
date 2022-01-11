package com.lion.homepage.delegate;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.lion.homepage.R;
import com.lion.homepage.adapter.ProductListAdapter;
import com.lion.homepage.data.ProductDataBean;
import com.lion.homepage.data.SearchBean;
import com.lion.lib_common.constants.Constant;
import com.lion.lib_common.constants.URLConstant;
import com.lion.lib_common.rxEasyhttp.EasyHttp;
import com.lion.lib_common.rxEasyhttp.callback.SimpleCallBack;
import com.lion.lib_common.rxEasyhttp.exception.ApiException;
import com.lion.lib_common.themvp.view.AppDelegate;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;

import retrofit2.converter.gson.GsonConverterFactory;

public class ProductListActDelegate extends AppDelegate {

    private String cateId;
    private String cateName;
    private EditText edit_search;
    private ImageView iv_change_layout;
    private TextView tv_category_title;
    private LinearLayout ll_category_part_price;
    private ImageView iv_part_price_up;
    private ImageView iv_part_price_down;
    private LinearLayout ll_category_part_sale_num;
    private ImageView iv_part_sale_num_up;
    private ImageView iv_part_sale_num_down;
    private TextView tv_category_part_new;
    private ArrayList<ProductDataBean> productList = new ArrayList<>();
    private ArrayList<ProductDataBean> productListTemp = new ArrayList<>();

    private SmartRefreshLayout srl_product_list;
    private RecyclerView rcy_product_list;
    private int page = 1;
    private String priceOrder = "";
    private String salesOrder = "";
    private String news = "";
    private ProductListAdapter productListAdapter;
    private LinearLayoutManager linearLayoutManager;
    private boolean isGrid = true;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private TextView category_part_price;
    private TextView tv_category_part_sale_num;
    private View emptyView;

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_product_list;
    }

    @Override
    public void initWidget(Bundle savedInstanceState) {
        super.initWidget(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        EasyHttp.get(URLConstant.LIST_PAGE)
                .params("page", page + "")
                .params("sid", cateId)
                .params("priceOrder", priceOrder)
                .params("salesOrder", salesOrder)
                .params("news", news)
                .addConverterFactory(GsonConverterFactory.create())
                .execute(new SimpleCallBack<String>() {

                    @Override
                    public void onError(ApiException e) {
                        Snackbar.make(srl_product_list, e.getMessage(), Snackbar.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String s) {
                        SearchBean jsonBean = new Gson().fromJson(s, SearchBean.class);
                        if (jsonBean.getStatus() == 200) {
                            productListTemp.clear();
                            if (jsonBean.getData() != null && jsonBean.getData().size() > 0) {
                                for (int i = 0; i < jsonBean.getData().size(); i++) {
                                    ProductDataBean product = new ProductDataBean();
                                    product.setImgUrl(jsonBean.getData().get(i).getImage());
                                    product.setProductName(jsonBean.getData().get(i).getStore_name());
                                    product.setProductMoney(jsonBean.getData().get(i).getPrice());
                                    product.setSaleNum(jsonBean.getData().get(i).getSales());
                                    product.setProductId(jsonBean.getData().get(i).getId());
                                    product.setVipMoney(jsonBean.getData().get(i).getVip_price());
                                    productListTemp.add(product);
                                }
                                if (srl_product_list.isRefreshing()) {
                                    productList.clear();
                                }
                                productList.addAll(productListTemp);
                                productListAdapter.notifyDataSetChanged();
                                if (srl_product_list.isRefreshing()) {
                                    srl_product_list.finishRefresh();
                                } else if (srl_product_list.isLoading()) {
                                    srl_product_list.finishLoadmore();
                                }
                            } else {
                                if (srl_product_list.isRefreshing()) {
                                    srl_product_list.finishRefresh();
                                    productList.clear();
                                } else if (srl_product_list.isLoading()) {
                                    srl_product_list.finishLoadmoreWithNoMoreData();
                                }
                            }
                        }

                    }
                });
    }

    private void initView() {
        cateId = getActivity().getIntent().getStringExtra(Constant.KEY_CATEGORY_ID);
        cateName = getActivity().getIntent().getStringExtra(Constant.KEY_CATEGORY_NAME);

        edit_search = get(R.id.edit_search);
        iv_change_layout = get(R.id.iv_change_layout);

        tv_category_title = get(R.id.tv_category_title);
        ll_category_part_price = get(R.id.ll_category_part_price);
        category_part_price = get(R.id.category_part_price);
        iv_part_price_up = get(R.id.iv_part_price_up);
        iv_part_price_down = get(R.id.iv_part_price_down);
        ll_category_part_sale_num = get(R.id.ll_category_part_sale_num);
        tv_category_part_sale_num = get(R.id.tv_category_part_sale_num);
        iv_part_sale_num_up = get(R.id.iv_part_sale_num_up);
        iv_part_sale_num_down = get(R.id.iv_part_sale_num_down);
        tv_category_part_new = get(R.id.tv_category_part_new);

        srl_product_list = get(R.id.srl_product_list);
        rcy_product_list = get(R.id.rcy_product_list);

        tv_category_title.setText(cateName);
        tv_category_title.setTextColor(getActivity().getResources().getColor(R.color.home_page_title_color));

        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        rcy_product_list.setLayoutManager(staggeredGridLayoutManager);
        rcy_product_list.setItemAnimator(new DefaultItemAnimator());
        productListAdapter = new ProductListAdapter(getActivity(), productList);
        productListAdapter.setViewType(ProductListAdapter.GRID_TYPE);
        rcy_product_list.setAdapter(productListAdapter);
        emptyView = View.inflate(this.activity, R.layout.search_layout_item_empty, null);
        //srl_product_list.autoRefresh();
        iv_change_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGrid) {
                    isGrid = false;
                    productListAdapter.setViewType(ProductListAdapter.LINEAR_TYPE);
                    rcy_product_list.setLayoutManager(linearLayoutManager);
                } else {
                    isGrid = true;
                    productListAdapter.setViewType(ProductListAdapter.GRID_TYPE);
                    rcy_product_list.setLayoutManager(staggeredGridLayoutManager);
                }
            }
        });

        tv_category_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        ll_category_part_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (priceOrder == "") {
                    priceOrder = "asc";
                    iv_part_price_up.setImageResource(R.drawable.ic_menu_dropdown_up_theme);
                    iv_part_price_down.setImageResource(R.drawable.ic_menu_dropdown_down);
                    category_part_price.setTextColor(getActivity().getResources().getColor(R.color.home_page_title_color));
                } else if (priceOrder == "asc") {
                    priceOrder = "desc";
                    iv_part_price_up.setImageResource(R.drawable.ic_menu_dropdown_up);
                    iv_part_price_down.setImageResource(R.drawable.ic_menu_dropdown_down_theme);
                    category_part_price.setTextColor(getActivity().getResources().getColor(R.color.home_page_title_color));
                } else {
                    priceOrder = "";
                    iv_part_price_up.setImageResource(R.drawable.ic_menu_dropdown_up);
                    iv_part_price_down.setImageResource(R.drawable.ic_menu_dropdown_down);
                    category_part_price.setTextColor(getActivity().getResources().getColor(R.color.secondaryText));
                }
                srl_product_list.autoRefresh();
            }
        });
        ll_category_part_sale_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (salesOrder == "") {
                    salesOrder = "asc";
                    iv_part_sale_num_up.setImageResource(R.drawable.ic_menu_dropdown_up_theme);
                    iv_part_sale_num_down.setImageResource(R.drawable.ic_menu_dropdown_down);
                    tv_category_part_sale_num.setTextColor(getActivity().getResources().getColor(R.color.home_page_title_color));
                } else if (salesOrder == "asc") {
                    salesOrder = "desc";
                    iv_part_sale_num_up.setImageResource(R.drawable.ic_menu_dropdown_up);
                    iv_part_sale_num_down.setImageResource(R.drawable.ic_menu_dropdown_down_theme);
                    tv_category_part_sale_num.setTextColor(getActivity().getResources().getColor(R.color.home_page_title_color));
                } else {
                    salesOrder = "";
                    iv_part_sale_num_up.setImageResource(R.drawable.ic_menu_dropdown_up);
                    iv_part_sale_num_down.setImageResource(R.drawable.ic_menu_dropdown_down);
                    tv_category_part_sale_num.setTextColor(getActivity().getResources().getColor(R.color.secondaryText));
                }
                srl_product_list.autoRefresh();
            }
        });

        tv_category_part_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (news == "" || news == "0") {
                    news = "1";
                    tv_category_part_new.setTextColor(getActivity().getResources().getColor(R.color.home_page_title_color));
                } else {
                    news = "0";
                    tv_category_part_new.setTextColor(getActivity().getResources().getColor(R.color.secondaryText));
                }
                srl_product_list.autoRefresh();
            }
        });

        srl_product_list.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                initData();
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page = 1;
                initData();
            }
        });
    }
}
