package com.lion.homepage.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.apkfuns.logutils.LogUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lion.homepage.R;
import com.lion.homepage.data.BannerData;
import com.lion.homepage.data.HomePageDataBean;
import com.lion.lib_common.constants.URLConstant;
import com.stx.xhb.xbanner.XBanner;

import java.math.BigInteger;
import java.util.List;

public class HomePageAdapter extends BaseMultiItemQuickAdapter<HomePageDataBean, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    private Context mContext;

    public HomePageAdapter(Context context, List<HomePageDataBean> data) {
        super(data);
        mContext = context;
        addItemType(HomePageDataBean.TYPE_HOME_PAGE_BANNER, R.layout.home_banner_layout);
        addItemType(HomePageDataBean.TYPE_HOME_PAGE_CATEGORY, R.layout.home_category_layout);
        addItemType(HomePageDataBean.TYPE_HOME_PAGE_CLEAR_TITLE, R.layout.home_sub_title);
        addItemType(HomePageDataBean.TYPE_HOME_PAGE_CLEAR_PRODUCT, R.layout.home_clear_product_item);
        addItemType(HomePageDataBean.TYPE_HOME_PAGE_VIP_TITLE, R.layout.home_sub_title);
        addItemType(HomePageDataBean.TYPE_HOME_PAGE_VIP_PRODUCT, R.layout.home_best_product_item);
        addItemType(HomePageDataBean.TYPE_HOME_PAGE_PRODUCT_LIST, R.layout.home_product_list_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomePageDataBean item) {
        switch (helper.getItemViewType()) {
            case HomePageDataBean.TYPE_HOME_PAGE_BANNER:
                LinearLayout searchBar = helper.getView(R.id.search_bar);
                XBanner xBanner = helper.getView(R.id.xBanner);
                searchBar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //搜索
                    }
                });
                xBanner.setBannerData(item.getBannerDataList());
                xBanner.setAutoPlayAble(item.getBannerDataList().size() > 1);
                xBanner.loadImage(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        Glide.with(mContext)
                                .load(((BannerData) model).getPic())
                                .placeholder(R.drawable.banner_placeholder)
                                .error(R.drawable.banner_placeholder)
                                .apply(RequestOptions.bitmapTransform(new RoundedCorners(10)))
                                .into((ImageView) view);
                    }
                });
                /*xBanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
                    @Override
                    public void onItemClick(XBanner banner, Object model, View view, int position) {
                        Toast.makeText(mContext, "点击了第" + position + "图片", Toast.LENGTH_SHORT).show();
                        if (!((BannerData) model).getXBannerUrl().equals("")) {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            Uri content_url = Uri.parse(URLConstant.BASE_URL + ((BannerData) model).getXBannerUrl());
                            intent.setData(content_url);
                            mContext.startActivity(intent);
                        }
                    }
                });*/
                break;
            case HomePageDataBean.TYPE_HOME_PAGE_CATEGORY:
                ImageView iv_homepage_category = helper.getView(R.id.iv_homepage_category);
                Glide.with(mContext)
                        .load(item.getMenu_pic())
                        .placeholder(R.drawable.ic_launcher)
                        .error(R.drawable.ic_launcher)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(1)))
                        .into(iv_homepage_category);
                break;

            case HomePageDataBean.TYPE_HOME_PAGE_CLEAR_TITLE:
                helper.setText(R.id.tv_sub_title, "最后清空");
                helper.addOnClickListener(R.id.tv_category_more);
                break;
            case HomePageDataBean.TYPE_HOME_PAGE_VIP_TITLE:
                helper.setText(R.id.tv_sub_title, "会员精选");
                helper.addOnClickListener(R.id.tv_category_more);
                break;
            case HomePageDataBean.TYPE_HOME_PAGE_CLEAR_PRODUCT:
                ImageView clear_product_img = helper.getView(R.id.clear_product_img);
                Glide.with(mContext)
                        .load(item.getClearProductImg())
                        .placeholder(R.drawable.ic_launcher)
                        .error(R.drawable.ic_launcher)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(1)))
                        .into(clear_product_img);
                helper.setText(R.id.clear_product_price_tv, "￥：" + item.getClearProductPrice());
                break;

            case HomePageDataBean.TYPE_HOME_PAGE_VIP_PRODUCT:
                ImageView best_product_img = helper.getView(R.id.best_product_img);
                Glide.with(mContext).load(item.getVipProductImg()).placeholder(R.drawable.ic_launcher)
                        .error(R.drawable.ic_launcher)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(1)))
                        .into(best_product_img);
                helper.setText(R.id.best_product_content, item.getVipProductContent());
                helper.setText(R.id.best_product_ot_price, "原价:￥" + item.getNormalProductPrice());
                helper.setText(R.id.best_product_price, "现价:￥" + item.getVipProductPrice());
                break;

            case HomePageDataBean.TYPE_HOME_PAGE_PRODUCT_LIST:
                ImageView home_prod_item_img = helper.getView(R.id.home_prod_item_img);
                Glide.with(mContext).load(item.getProductImage()).placeholder(R.drawable.ic_launcher)
                        .error(R.drawable.ic_launcher)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(1)))
                        .into(home_prod_item_img);

                helper.setText(R.id.product_item_title_tv, item.getProductContent());
                helper.setText(R.id.product_item_desc_tv, "临期时间:" + item.getProductOutTime());
                helper.setText(R.id.product_item_price, "￥:" + item.getProductPrice());
                helper.setText(R.id.product_item_score_price, "用劵:" + item.getProductScorePrice());
                helper.setText(R.id.product_market_price, "￥:" + item.getProductMarketPrice());
                ProgressBar pb_product = helper.getView(R.id.pb_product);
                BigInteger saleNum = new BigInteger(String.valueOf(item.getSaleNum()));
                BigInteger saleCoin = new BigInteger("100");
                BigInteger totleNum = new BigInteger(String.valueOf(item.getSaleNum() + item.getStoke()));
                double progress = saleNum.multiply(saleCoin).divide(totleNum).doubleValue();
                LogUtils.d("yuchao, saleNum = "+saleNum + "totleNum = "+ totleNum + "progress = "+ progress);
                helper.setText(R.id.product_sale_num, "已抢购:" + progress + "%");
                pb_product.setProgress((int) progress);
                break;
        }

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = getItemViewType(position);
                    switch (type) {
                        case HomePageDataBean.TYPE_HOME_PAGE_BANNER:
                        case HomePageDataBean.TYPE_HOME_PAGE_CLEAR_TITLE:
                        case HomePageDataBean.TYPE_HOME_PAGE_VIP_TITLE:
                        case HomePageDataBean.TYPE_HOME_PAGE_PRODUCT_LIST:
                            return 20;
                        case HomePageDataBean.TYPE_HOME_PAGE_CATEGORY:
                            return 4;
                        case HomePageDataBean.TYPE_HOME_PAGE_CLEAR_PRODUCT:
                        case HomePageDataBean.TYPE_HOME_PAGE_VIP_PRODUCT:
                            return 5;
                        default:
                            return 0;
                    }
                }
            });
        }
    }
}
