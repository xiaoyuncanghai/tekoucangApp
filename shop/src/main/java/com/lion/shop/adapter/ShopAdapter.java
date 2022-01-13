package com.lion.shop.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lion.shop.R;
import com.lion.shop.databean.ProductDataBean;

import java.util.List;

public class ShopAdapter extends BaseMultiItemQuickAdapter<ProductDataBean, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    private Context mContext;

    public ShopAdapter(Context context, List<ProductDataBean> data) {
        super(data);
        this.mContext = context;
        addItemType(ProductDataBean.HEADER_ITEM, R.layout.shop_head_item);
        addItemType(ProductDataBean.BODY_ITEM, R.layout.shop_body_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductDataBean item) {
        switch (helper.getItemViewType()) {
            case ProductDataBean.HEADER_ITEM:
                helper.setText(R.id.tv_shop_item_header, item.getHeader());
                break;
            case ProductDataBean.BODY_ITEM:
                ImageView shop_item_image = helper.getView(R.id.shop_item_image);
                Glide.with(mContext)
                        .load(item.getImgUrl())
                        .placeholder(R.drawable.ic_launcher)
                        .error(R.drawable.ic_launcher)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(1)))
                        .into(shop_item_image);
                TextView shop_item_content = helper.getView(R.id.shop_item_content);
                shop_item_content.setText(item.getTitle());
                TextView shop_item_price = helper.getView(R.id.shop_item_price);
                shop_item_price.setText("￥" + item.getPrice());
                TextView shop_item_out_price = helper.getView(R.id.shop_item_out_price);
                shop_item_out_price.setText("￥" + item.getOutPrice());
                TextView product_time_sale = helper.getView(R.id.product_time_sale);
                product_time_sale.setText("临期时间:" + item.getTime());
                TextView product_item_sale = helper.getView(R.id.product_item_sale);
                if (item.getStoke() > 0) {
                    product_item_sale.setText("立即采购");
                } else {
                    product_item_sale.setText("采购已满");
                }
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
                        case ProductDataBean.HEADER_ITEM:
                            return 2;
                        case ProductDataBean.BODY_ITEM:
                            return 1;
                        default:
                            return 0;
                    }
                }
            });
        }
    }
}
