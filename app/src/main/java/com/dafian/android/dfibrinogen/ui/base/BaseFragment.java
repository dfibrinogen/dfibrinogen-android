package com.dafian.android.dfibrinogen.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.dafian.android.dfibrinogen.R;
import com.dafian.android.dfibrinogen.data.DataManager;
import com.dafian.android.dfibrinogen.data.SessionManager;
import com.dafian.android.dfibrinogen.data.api.RestFactory;
import com.dafian.android.dfibrinogen.data.api.RestService;
import com.dafian.android.dfibrinogen.util.Helper;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * @author Dafian on 2/7/18
 */

public class BaseFragment extends SupportFragment {

    private RestService restService;
    private DataManager manager;
    private SessionManager session;

    protected OnFragmentOpenDrawerListener openDrawerListener;

    protected void initToolbarNav(Toolbar toolbar, boolean isHome) {

        if (isHome) {
            toolbar.setNavigationIcon(R.drawable.ic_menu);
            toolbar.setNavigationOnClickListener(v -> {
                if (openDrawerListener != null) {
                    openDrawerListener.onOpenDrawer();
                }
            });

        } else {
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
            toolbar.setNavigationOnClickListener(v -> pop());
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentOpenDrawerListener) {
            openDrawerListener = (OnFragmentOpenDrawerListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        openDrawerListener = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public RestService getRestService() {
        if (restService == null) {
            restService = RestFactory.create();
        }
        return restService;
    }

    public DataManager getManager() {
        if (manager == null) {
            manager = new DataManager(getRestService());
        }
        return manager;
    }

    public SessionManager getSession() {
        if (session == null) {
            session = new SessionManager(Helper.getDefaultPreferences(getActivity()));
        }
        return session;
    }

    public interface OnFragmentOpenDrawerListener {

        void onOpenDrawer();
    }
}
