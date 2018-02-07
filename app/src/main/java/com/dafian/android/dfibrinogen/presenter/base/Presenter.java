package com.dafian.android.dfibrinogen.presenter.base;

import com.dafian.android.dfibrinogen.ui.base.BaseView;

/**
 * @author Dafian on 2/7/18
 */

public interface Presenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
