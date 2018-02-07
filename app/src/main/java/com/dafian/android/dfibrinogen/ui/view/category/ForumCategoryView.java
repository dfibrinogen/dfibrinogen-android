package com.dafian.android.dfibrinogen.ui.view.category;

import com.dafian.android.dfibrinogen.data.entity.ForumCategory;
import com.dafian.android.dfibrinogen.ui.base.BaseView;

import java.util.List;

/**
 * @author Dafian on 2/7/18
 */

public interface ForumCategoryView extends BaseView {

    void showCategoryList(List<ForumCategory> forumCategoryList);
}
