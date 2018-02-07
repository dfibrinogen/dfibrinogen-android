package com.dafian.android.dfibrinogen.presenter;

import com.dafian.android.dfibrinogen.data.DataManager;
import com.dafian.android.dfibrinogen.presenter.base.BasePresenter;
import com.dafian.android.dfibrinogen.ui.view.user.UserView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Dafian on 2/7/18
 */

public class UserPresenter extends BasePresenter<UserView> {

    private Disposable disposable;

    private DataManager manager;

    public UserPresenter(DataManager manager) {
        this.manager = manager;
    }

    @Override
    public void attachView(UserView view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (disposable != null) disposable.dispose();
    }

    public void getUserAll() {

        if (disposable != null) disposable.dispose();

        disposable = manager.getUserProfileAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(userProfileList -> {
                    if (isViewAttached()) {
                        getView().showUserList(userProfileList);
                    }
                }, throwable -> {
                    if (isViewAttached()) {
                        getView().showErrorMessage(throwable.getMessage());
                    }
                });
    }
}
