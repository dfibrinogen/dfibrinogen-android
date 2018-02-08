package com.dafian.android.dfibrinogen.presenter;

import com.dafian.android.dfibrinogen.data.DataManager;
import com.dafian.android.dfibrinogen.presenter.base.BasePresenter;
import com.dafian.android.dfibrinogen.ui.view.category.ForumCategoryView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Dafian on 2/7/18
 */

public class CategoryPresenter extends BasePresenter<ForumCategoryView> {

    private CompositeDisposable disposable;

    private DataManager manager;

    public CategoryPresenter(DataManager manager) {
        this.manager = manager;
        this.disposable = new CompositeDisposable();
    }

    @Override
    public void attachView(ForumCategoryView view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (disposable != null) disposable.dispose();
    }

    public void getCategoryAll() {

        disposable.add(manager.getForumCategoryAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(forumCategoryList -> {
                    if (isViewAttached()) {
                        getView().showCategoryList(forumCategoryList);
                    }
                }, throwable -> {
                    if (isViewAttached()) {
                        getView().showErrorMessage(throwable.getMessage());
                    }
                }));
    }
}
