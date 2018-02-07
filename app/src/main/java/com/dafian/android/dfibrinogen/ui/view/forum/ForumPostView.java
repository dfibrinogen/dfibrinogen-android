package com.dafian.android.dfibrinogen.ui.view.forum;

import com.dafian.android.dfibrinogen.data.entity.ForumPost;
import com.dafian.android.dfibrinogen.ui.base.BaseView;

import java.util.List;

/**
 * @author Dafian on 2/7/18
 */

public interface ForumPostView extends BaseView {

    void showPostList(List<ForumPost> forumPostList);
}
