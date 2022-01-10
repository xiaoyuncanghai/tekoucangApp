package com.lion.homepage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lion.homepage.R;
import com.lion.homepage.data.ProductDataBean;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder> {

    private ArrayList<ProductDataBean> mList;
    private Context mContext;
    public final static int LINEAR_TYPE = 0;
    public final static int GRID_TYPE = 1;
    private int viewType = GRID_TYPE;

    public ProductListAdapter(Context context, ArrayList<ProductDataBean> productDataList) {
        this.mContext = context;
        this.mList = productDataList;
    }

    @NonNull
    @Override
    public ProductListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == LINEAR_TYPE) {//通过第二个参数viewType判断选用的视图
            view = View.inflate(mContext, R.layout.search_layout_item_list, null);//加载item布局
        } else {
            view = View.inflate(mContext, R.layout.search_layout_item_grid, null);//加载item布局
        }
        ProductListViewHolder viewHolder = new ProductListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListViewHolder holder, int position) {
        if (holder instanceof ProductListViewHolder) {
            if (mList != null && mList.size() > 0) {
                Glide.with(mContext)
                        .load(mList.get(position).getImgUrl())
                        .placeholder(R.drawable.ic_launcher)
                        .error(R.drawable.ic_launcher)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(1)))
                        .into(holder.product_list_iv);
                holder.product_list_price.setText("￥" + mList.get(position).getProductMoney());
                holder.product_list_title.setText(mList.get(position).getProductName());
                holder.product_list_sale_num.setText("已售" + mList.get(position).getSaleNum());
                holder.product_list_vip_price.setText("卷后价" + mList.get(position).getVipMoney());
            }
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    @Override
    public int getItemViewType(int position) {
        return viewType;
    }

    public class ProductListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView product_list_iv;
        private final TextView product_list_title;
        private final TextView product_list_price;
        private final TextView product_list_sale_num;
        private final TextView product_list_vip_price;

        public ProductListViewHolder(@NonNull View itemView) {
            super(itemView);
            product_list_iv = itemView.findViewById(R.id.product_list_iv);
            product_list_title = itemView.findViewById(R.id.product_list_title);
            product_list_price = itemView.findViewById(R.id.product_list_price);
            product_list_sale_num = itemView.findViewById(R.id.product_list_sale_num);
            product_list_vip_price = itemView.findViewById(R.id.product_list_vip_price);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
