package com.dafian.android.dfibrinogen.ui.base;

import com.dafian.android.dfibrinogen.data.DataManager;
import com.dafian.android.dfibrinogen.data.SessionManager;
import com.dafian.android.dfibrinogen.data.api.RestFactory;
import com.dafian.android.dfibrinogen.data.api.RestService;
import com.dafian.android.dfibrinogen.util.Helper;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * @author Dafian on 2/8/18
 */

public abstract class BaseActivity extends SupportActivity {

    private RestService restService;
    private DataManager manager;
    private SessionManager session;

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
            session = new SessionManager(Helper.getDefaultPreferences(this));
        }
        return session;
    }
}
