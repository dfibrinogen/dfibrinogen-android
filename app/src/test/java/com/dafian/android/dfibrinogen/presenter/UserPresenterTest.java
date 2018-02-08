package com.dafian.android.dfibrinogen.presenter;

import com.dafian.android.dfibrinogen.BasePresenterTest;
import com.dafian.android.dfibrinogen.TestDataFactory;
import com.dafian.android.dfibrinogen.data.DataManager;
import com.dafian.android.dfibrinogen.data.entity.UserProfile;
import com.dafian.android.dfibrinogen.ui.view.user.UserView;

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
public class UserPresenterTest extends BasePresenterTest {

    private UserView view;

    private DataManager manager;
    private UserPresenter presenter;

    @BeforeClass
    public static void setUpClass() {

        RxAndroidPlugins.setInitMainThreadSchedulerHandler(__ -> Schedulers.trampoline());
    }

    @Before
    public void setUp() throws Exception {

        view = mock(UserView.class);
        manager = getMockDataManager();
        presenter = new UserPresenter(manager);
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
    public void getUserAll_withSuccess() throws Exception {

        List<UserProfile> userList = TestDataFactory.makeUser();

        when(manager.getUserProfileAll())
                .thenReturn(Observable.just(userList));

        presenter.getUserAll();

        verify(view, times(1)).showUserList(userList);
        verify(view, never()).showErrorMessage("");
    }

}