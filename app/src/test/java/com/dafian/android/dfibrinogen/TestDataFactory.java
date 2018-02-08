package com.dafian.android.dfibrinogen;

import com.dafian.android.dfibrinogen.data.entity.ForumCategory;
import com.dafian.android.dfibrinogen.data.entity.ForumPost;
import com.dafian.android.dfibrinogen.data.entity.UserProfile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dafian on 2/8/18
 */

public class TestDataFactory {

    public static List<UserProfile> makeUser() {

        List<UserProfile> userProfileList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            UserProfile userProfile = new UserProfile();
            userProfile.setId(i);
            userProfile.setFullName("Name " + i);

            userProfileList.add(userProfile);
        }

        return userProfileList;
    }

    public static List<ForumCategory> makeForumCategory() {

        List<ForumCategory> forumCategoryList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            ForumCategory category = new ForumCategory();
            category.setId(i);
            category.setName("Category " + i);

            forumCategoryList.add(category);
        }

        return forumCategoryList;
    }

    public static List<ForumPost> makeForumPost() {

        List<ForumPost> forumPostList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            ForumPost post = new ForumPost();
            post.setId(i);
            post.setTitle("Judul " + i);
            post.setContent("Isi " + i);

            forumPostList.add(post);
        }

        return forumPostList;
    }
}
