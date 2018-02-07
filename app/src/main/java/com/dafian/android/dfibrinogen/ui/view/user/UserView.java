package com.dafian.android.dfibrinogen.ui.view.user;

import com.dafian.android.dfibrinogen.data.entity.UserProfile;
import com.dafian.android.dfibrinogen.ui.base.BaseView;

import java.util.List;

/**
 * @author Dafian on 2/7/18
 */

public interface UserView extends BaseView {

    void showUserList(List<UserProfile> userProfileList);
}
