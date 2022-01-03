package com.lion.homepage.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lion.homepage.R;
import com.lion.homepage.data.ProductDataBean;

import java.util.List;

public class SearchAdapter extends BaseMultiItemQuickAdapter<ProductDataBean, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    private Context mContext;

    public SearchAdapter(Context context, List<ProductDataBean> data) {
        super(data);
        mContext = context;
        addItemType(ProductDataBean.TYPE_EMPTY, R.layout.search_layout_item_empty);
        addItemType(ProductDataBean.TYPE_LIST, R.layout.search_layout_item_main);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductDataBean item) {
        switch (helper.getItemViewType()) {
            case ProductDataBean.TYPE_LIST:
                ImageView search_promote_iv = helper.getView(R.id.search_promote_iv);
                Glide.with(mContext)
                        .load(item.getImgUrl())
                        .placeholder(R.drawable.empty)
                        .error(R.drawable.empty)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(1)))
                        .into(search_promote_iv);
                TextView search_title = helper.getView(R.id.search_title);
                search_title.setText(item.getProductName());
                helper.setText(R.id.search_product_price, "￥" + item.getProductMoney());
                helper.setText(R.id.search_product_sale_num, "已售" + item.getSaleNum());
                break;
        }

    }
}
