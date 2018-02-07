package com.dafian.android.dfibrinogen.presenter;

import com.dafian.android.dfibrinogen.data.DataManager;
import com.dafian.android.dfibrinogen.presenter.base.BasePresenter;
import com.dafian.android.dfibrinogen.ui.view.forum.ForumPostView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Dafian on 2/7/18
 */

public class PostPresenter extends BasePresenter<ForumPostView> {

    private Disposable disposable;

    private DataManager manager;

    public PostPresenter(DataManager manager) {
        this.manager = manager;
    }

    @Override
    public void attachView(ForumPostView view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (disposable != null) disposable.dispose();
    }

    public void getPostAll() {

        if (disposable != null) disposable.dispose();

        disposable = manager.getForumPostAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(forumPostList -> {
                    if (isViewAttached()) {
                        getView().showPostList(forumPostList);
                    }
                }, throwable -> {
                    if (isViewAttached()) {
                        getView().showErrorMessage(throwable.getMessage());
                    }
                });
    }
}
