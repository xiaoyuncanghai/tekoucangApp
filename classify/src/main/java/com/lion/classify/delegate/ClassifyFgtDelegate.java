package com.lion.classify.delegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.lion.classify.R;
import com.lion.classify.adapter.LeftAdapter;
import com.lion.classify.data.ClassifyJsonBean;
import com.lion.classify.listener.CheckListener;
import com.lion.classify.listener.RvListener;
import com.lion.classify.ui.RightFragment;
import com.lion.classify.view.ItemHeaderDecoration;
import com.lion.lib_common.constants.ARouterPath;
import com.lion.lib_common.constants.URLConstant;
import com.lion.lib_common.rxEasyhttp.EasyHttp;
import com.lion.lib_common.rxEasyhttp.callback.SimpleCallBack;
import com.lion.lib_common.rxEasyhttp.exception.ApiException;
import com.lion.lib_common.themvp.view.AppDelegate;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation.SupportActivity;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClassifyFgtDelegate extends AppDelegate implements CheckListener {

    private RecyclerView rvSort;
    private LinearLayoutManager mLinearLayoutManager;
    private LinearLayout categoryPage;
    private LeftAdapter mLeftAdapter;
    private ClassifyJsonBean classifyJsonBean;
    private RightFragment mRightFragment;
    private int targetPosition;
    private boolean isMoved;
    private LinearLayout edit_search;

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_classify;
    }

    @Override
    public void initWidget(Bundle savedInstanceState) {
        super.initWidget(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        rvSort = get(R.id.rv_sort);
        edit_search = get(R.id.edit_search);
        categoryPage = get(R.id.category_page);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        rvSort.setLayoutManager(mLinearLayoutManager);
        DividerItemDecoration decoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        rvSort.addItemDecoration(decoration);
        edit_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getActivity(), );
                ARouter.getInstance().build(ARouterPath.SEARCH_PATH).navigation();
            }
        });
    }

    private void initData() {
        EasyHttp.get(URLConstant.CATEGORY_PAGE)
                .addConverterFactory(GsonConverterFactory.create())
                .execute(new SimpleCallBack<String>() {

                    @Override
                    public void onError(ApiException e) {
                        Snackbar.make(categoryPage, e.getMessage(), Snackbar.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String s) {
                        classifyJsonBean = new Gson().fromJson(s, ClassifyJsonBean.class);
                        if (classifyJsonBean.getStatus() == 200) {
                            if (classifyJsonBean.getData() != null && classifyJsonBean.getData().size() > 0) {
                                ArrayList<ClassifyJsonBean.DataBean> parentDataBean = classifyJsonBean.getData();
                                List<String> list = new ArrayList<>();
                                for (int i = 0; i < parentDataBean.size(); i++) {
                                    list.add(parentDataBean.get(i).getCate_name());
                                }
                                mLeftAdapter = new LeftAdapter(getActivity(), list, new RvListener() {
                                    @Override
                                    public void onItemClick(int id, int position) {
                                        if (mRightFragment != null) {
                                            isMoved = true;
                                            targetPosition = position;
                                            setChecked(position, true);
                                        }
                                    }
                                });
                                rvSort.setAdapter(mLeftAdapter);
                                createFragment();
                            }
                        }
                    }
                });
    }



    public void createFragment() {
        FragmentTransaction fragmentTransaction = ((SupportActivity)getActivity()).getSupportFragmentManager().beginTransaction();
        mRightFragment = new RightFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("right", classifyJsonBean.getData());
        mRightFragment.setArguments(bundle);
        mRightFragment.setListener(this::check);
        fragmentTransaction.add(R.id.lin_fragment, mRightFragment);
        fragmentTransaction.commit();
    }

    private void setChecked(int position, boolean isLeft) {
        Log.d("p-------->", String.valueOf(position));
        if (isLeft) {
            mLeftAdapter.setCheckedPosition(position);
            //???????????????????????????????????????????????????????????????
            int count = 0;
            for (int i = 0; i < position; i++) {
                count += classifyJsonBean.getData().get(i).getChildren().size();
            }
            count += position;
            mRightFragment.setData(count);
            ItemHeaderDecoration.setCurrentTag(String.valueOf(targetPosition));//????????????????????????????????????????????????????????????tag
        } else {
            if (isMoved) {
                isMoved = false;
            }
            mLeftAdapter.setCheckedPosition(position);
            ItemHeaderDecoration.setCurrentTag(String.valueOf(position));//???????????????????????????????????????????????????????????????????????????tag

        }
        moveToCenter(position);

    }

    //??????????????????item??????
    private void moveToCenter(int position) {
        //????????????position?????????????????????????????????item????????????????????????????????????????????????????????????????????????
        View childAt = rvSort.getChildAt(position - mLinearLayoutManager.findFirstVisibleItemPosition());
        if (childAt != null) {
            int y = (childAt.getTop() - rvSort.getHeight() / 2);
            rvSort.smoothScrollBy(0, y);
        }

    }


    @Override
    public void check(int position, boolean isScroll) {
        setChecked(position, isScroll);
    }
}
