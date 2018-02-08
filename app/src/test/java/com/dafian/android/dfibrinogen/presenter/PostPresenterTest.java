package com.dafian.android.dfibrinogen.presenter;

import com.dafian.android.dfibrinogen.BasePresenterTest;
import com.dafian.android.dfibrinogen.TestDataFactory;
import com.dafian.android.dfibrinogen.data.DataManager;
import com.dafian.android.dfibrinogen.data.entity.ForumPost;
import com.dafian.android.dfibrinogen.ui.view.forum.ForumPostView;

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
public class PostPresenterTest extends BasePresenterTest {

    private ForumPostView view;

    private DataManager manager;
    private PostPresenter presenter;

    @BeforeClass
    public static void setUpClass() {

        RxAndroidPlugins.setInitMainThreadSchedulerHandler(__ -> Schedulers.trampoline());
    }

    @Before
    public void setUp() throws Exception {

        view = mock(ForumPostView.class);
        manager = getMockDataManager();
        presenter = new PostPresenter(manager);
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
    public void getPostAll_withSuccess() throws Exception {

        List<ForumPost> forumPostList = TestDataFactory.makeForumPost();

        when(manager.getForumPostAll())
                .thenReturn(Observable.just(forumPostList));

        presenter.getPostAll();

        verify(view, times(1)).showPostList(forumPostList);
        verify(view, never()).showErrorMessage("");
    }
}