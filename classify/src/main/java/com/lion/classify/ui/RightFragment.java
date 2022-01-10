package com.lion.classify.ui;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.apkfuns.logutils.LogUtils;
import com.google.android.material.snackbar.Snackbar;
import com.lion.classify.R;
import com.lion.classify.adapter.RightAdapter;
import com.lion.classify.data.ClassifyJsonBean;
import com.lion.classify.data.RightBean;
import com.lion.classify.listener.CheckListener;
import com.lion.classify.listener.RvListener;
import com.lion.classify.presenter.RightPresenter;
import com.lion.classify.view.ItemHeaderDecoration;
import com.lion.lib_common.constants.ARouterPath;
import com.lion.lib_common.constants.Constant;

import java.util.ArrayList;
import java.util.List;

public class RightFragment extends CommonFragment<RightPresenter, String> implements
        CheckListener {

    private RecyclerView mRv;
    private RightAdapter mAdapter;
    private GridLayoutManager mManager;
    private List<RightBean> mDatas = new ArrayList<>();
    private ItemHeaderDecoration mDecoration;
    private boolean move = false;
    private int mIndex = 0;
    private CheckListener checkListener;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sort_detail;
    }

    @Override
    protected void initCustomView(View view) {
        mRv = (RecyclerView) view.findViewById(R.id.rv);

    }

    @Override
    protected void initListener() {
        mRv.addOnScrollListener(new RecyclerViewListener());
    }

    @Override
    protected RightPresenter initPresenter() {
        showRightPage(1);
        mManager = new GridLayoutManager(mContext, 2);
        //通过isTitle的标志来判断是否是title
        mManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mDatas.get(position).isTitle() ? 2 : 1;
            }
        });
        mRv.setLayoutManager(mManager);
        mAdapter = new RightAdapter(mContext, mDatas, new RvListener() {
            @Override
            public void onItemClick(int id, int position) {
                String content = "";
                if (R.id.root == id) {
                    //content = "title";
                } else if (R.id.content == id) {
                    ARouter.getInstance().build(ARouterPath.PRODUCT_LIST_PAGE)
                            .withString(Constant.KEY_CATEGORY_ID, mDatas.get(position).getCategoryId())
                            .withString(Constant.KEY_CATEGORY_NAME, mDatas.get(position).getTitleName())
                            .navigation();
                }
                /*Snackbar snackbar = Snackbar
                        .make(mRv, "当前点击的是" + content + ":" + mDatas.get(position).getName(),
                                Snackbar.LENGTH_SHORT);
                View mView = snackbar.getView();
                mView.setBackgroundColor(Color.BLUE);
                TextView text = mView.findViewById(R.id.snackbar_text);
                text.setTextColor(Color.WHITE);
                text.setTextSize(25);
                snackbar.show();*/
            }
        });

        mRv.setAdapter(mAdapter);
        mDecoration = new ItemHeaderDecoration(mContext, mDatas);
        mRv.addItemDecoration(mDecoration);
        mDecoration.setCheckListener(checkListener);
        initData();
        return new RightPresenter();
    }


    private void initData() {
        ArrayList<ClassifyJsonBean.DataBean> rightList = getArguments()
                .getParcelableArrayList("right");
        for (int i = 0; i < rightList.size(); i++) {
            RightBean head = new RightBean(rightList.get(i).getCate_name());
            //头部设置为true
            head.setTitle(true);
            head.setTitleName(rightList.get(i).getCate_name());
            head.setTag(String.valueOf(i));
            mDatas.add(head);
            List<ClassifyJsonBean.DataBean.ChildrenBean> childrenBeanList = rightList.get(i)
                    .getChildren();
            for (int j = 0; j < childrenBeanList.size(); j++) {
                RightBean body = new RightBean(childrenBeanList.get(j).getCate_name());
                body.setTag(String.valueOf(i));
                body.setCategoryId(childrenBeanList.get(j).getId());
                LogUtils.d("yuchao, id = "+childrenBeanList.get(j).getId());
                String name = rightList.get(i).getCate_name();
                body.setImgsrc(childrenBeanList.get(j).getPic());
                body.setTitleName(name);
                mDatas.add(body);
            }
        }
        mAdapter.notifyDataSetChanged();
        mDecoration.setData(mDatas);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void refreshView(int code, String data) {

    }

    public void setData(int n) {
        mIndex = n;
        mRv.stopScroll();
        smoothMoveToPosition(n);
    }

    @Override
    protected void getData() {

    }

    public void setListener(CheckListener listener) {
        this.checkListener = listener;
    }

    private void smoothMoveToPosition(int n) {
        int firstItem = mManager.findFirstVisibleItemPosition();
        int lastItem = mManager.findLastVisibleItemPosition();
        Log.d("first--->", String.valueOf(firstItem));
        Log.d("last--->", String.valueOf(lastItem));
        if (n <= firstItem) {
            mRv.scrollToPosition(n);
        } else if (n <= lastItem) {
            Log.d("pos---->", String.valueOf(n) + "VS" + firstItem);
            int top = mRv.getChildAt(n - firstItem).getTop();
            Log.d("top---->", String.valueOf(top));
            mRv.scrollBy(0, top);
        } else {
            mRv.scrollToPosition(n);
            move = true;
        }
    }


    @Override
    public void check(int position, boolean isScroll) {
        checkListener.check(position, isScroll);

    }


    private class RecyclerViewListener extends RecyclerView.OnScrollListener {

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (move && newState == RecyclerView.SCROLL_STATE_IDLE) {
                move = false;
                int n = mIndex - mManager.findFirstVisibleItemPosition();
                Log.d("n---->", String.valueOf(n));
                if (0 <= n && n < mRv.getChildCount()) {
                    int top = mRv.getChildAt(n).getTop();
                    Log.d("top--->", String.valueOf(top));
                    mRv.smoothScrollBy(0, top);
                }
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (move) {
                move = false;
                int n = mIndex - mManager.findFirstVisibleItemPosition();
                if (0 <= n && n < mRv.getChildCount()) {
                    int top = mRv.getChildAt(n).getTop();
                    mRv.scrollBy(0, top);
                }
            }
        }
    }


}
