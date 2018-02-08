package com.dafian.android.dfibrinogen;

import com.dafian.android.dfibrinogen.data.DataManager;
import com.dafian.android.dfibrinogen.data.api.RestService;

import static org.mockito.Mockito.mock;

/**
 * @author Dafian on 2/8/18
 */

public class BasePresenterTest {

    protected DataManager getMockDataManager() {

        RestService restService = mock(RestService.class);
        return new DataManager(restService);
    }
}
