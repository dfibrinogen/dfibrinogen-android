package com.dafian.android.dfibrinogen.presenter;

import com.dafian.android.dfibrinogen.BasePresenterTest;
import com.dafian.android.dfibrinogen.TestDataFactory;
import com.dafian.android.dfibrinogen.data.DataManager;
import com.dafian.android.dfibrinogen.data.entity.ForumCategory;
import com.dafian.android.dfibrinogen.ui.view.category.ForumCategoryView;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Dafian on 2/8/18
 */

@RunWith(MockitoJUnitRunner.class)
public class CategoryPresenterTest extends BasePresenterTest {

    private ForumCategoryView view;

    private DataManager manager;
    private CategoryPresenter presenter;

    @BeforeClass
    public static void setUpClass() {

        RxAndroidPlugins.setInitMainThreadSchedulerHandler(__ -> Schedulers.trampoline());
    }

    @Before
    public void setUp() throws Exception {

        view = mock(ForumCategoryView.class);
        manager = getMockDataManager();
        presenter = new CategoryPresenter(manager);
        presenter.attachView(view);
    }

    @After
    public void tearDown() throws Exception {

        presenter.detachView();
    }

    @AfterClass
    public static void tearDownClass() {

        RxAndroidPlugins.reset();
    }

    @Test
    public void getCategoryAll_withSuccess() throws Exception {

        List<ForumCategory> categoryList = TestDataFactory.makeForumCategory();

        when(manager.getForumCategoryAll())
                .thenReturn(Observable.just(categoryList));

        presenter.getCategoryAll();

        verify(view, times(1)).showCategoryList(categoryList);
        verify(view, never()).showErrorMessage("");
    }
}