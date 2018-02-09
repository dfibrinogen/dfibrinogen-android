package com.dafian.android.dfibrinogen.ui.view.user;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dafian.android.dfibrinogen.R;
import com.dafian.android.dfibrinogen.data.entity.UserProfile;
import com.dafian.android.dfibrinogen.presenter.UserPresenter;
import com.dafian.android.dfibrinogen.ui.adapter.UserAdapter;
import com.dafian.android.dfibrinogen.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Dafian on 2/8/18
 */

public class UserFragment extends BaseFragment implements UserView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_user)
    RecyclerView rvUser;
    @BindView(R.id.sw_user)
    SwipeRefreshLayout swUser;
    @BindView(R.id.fab_add)
    FloatingActionButton fabAdd;

    private Unbinder unbinder;
    private UserPresenter presenter;

    private List<UserProfile> profileList;
    private UserAdapter adapter;

    public static UserFragment newInstance() {
        UserFragment fragment = new UserFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new UserPresenter(getManager());
        presenter.attachView(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        unbinder = ButterKnife.bind(this, view);

        initView();
        initEvent();
        loadingData();

        return view;
    }

    @Override
    public void showErrorMessage(String errorMessage) {

        Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_SHORT).show();
        swUser.setRefreshing(false);
    }

    @Override
    public void showUserList(List<UserProfile> userProfileList) {

        this.profileList.addAll(userProfileList);
        adapter.notifyDataSetChanged();
        swUser.setRefreshing(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    private void initView() {

        toolbar.setTitle(R.string.main_title_friend);
        initToolbarNav(toolbar, true);

        profileList = new ArrayList<>();
        adapter = new UserAdapter(getActivity(), profileList);

        rvUser.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvUser.setItemAnimator(new DefaultItemAnimator());
        rvUser.setAdapter(adapter);
    }

    private void initEvent() {

        fabAdd.setOnClickListener(view -> {
            // Add User
            Toast.makeText(getActivity(), "Add User", Toast.LENGTH_SHORT).show();
        });
    }

    private void loadingData() {

        profileList.clear();

        swUser.setRefreshing(true);
        presenter.getUserAll();
    }
}
