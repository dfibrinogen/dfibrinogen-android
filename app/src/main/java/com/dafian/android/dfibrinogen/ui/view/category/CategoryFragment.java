package com.dafian.android.dfibrinogen.ui.view.category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dafian.android.dfibrinogen.R;
import com.dafian.android.dfibrinogen.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Dafian on 2/8/18
 */

public class CategoryFragment extends BaseFragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_category)
    RecyclerView rvCategory;
    @BindView(R.id.sw_category)
    SwipeRefreshLayout swCategory;
    @BindView(R.id.fab_add)
    FloatingActionButton fabAdd;

    private Unbinder unbinder;

    public static CategoryFragment newInstance() {
        CategoryFragment fragment = new CategoryFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forum_category, container, false);
        unbinder = ButterKnife.bind(this, view);

        initView();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void initView() {

        toolbar.setTitle(R.string.main_title_category);
        initToolbarNav(toolbar, true);
    }
}
