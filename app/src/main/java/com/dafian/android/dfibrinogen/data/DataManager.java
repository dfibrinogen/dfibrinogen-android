package com.dafian.android.dfibrinogen.data;

import com.dafian.android.dfibrinogen.data.api.RestService;
import com.dafian.android.dfibrinogen.data.entity.ForumCategory;
import com.dafian.android.dfibrinogen.data.entity.ForumPost;
import com.dafian.android.dfibrinogen.data.entity.Response;
import com.dafian.android.dfibrinogen.data.entity.UserAuth;
import com.dafian.android.dfibrinogen.data.entity.UserProfile;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author Dafian on 2/7/18
 */

public class DataManager {

    private RestService restService;

    public DataManager(RestService restService) {
        this.restService = restService;
    }

    public Observable<UserProfile> userLogin(UserAuth userAuth) {
        return restService.userLogin(userAuth);
    }

    public Observable<UserProfile> userRegister(UserAuth userAuth) {
        return restService.userRegister(userAuth);
    }

    public Observable<List<UserProfile>> getUserProfileAll() {
        return restService.getUserProfileAll();
    }

    public Observable<UserProfile> getUserProfileByID(Integer userId) {
        return restService.getUserProfileByID(userId);
    }

    public Observable<UserProfile> updateUserProfile(Integer userId, UserProfile userProfile) {
        return restService.updateUserProfile(userId, userProfile);
    }

    public Observable<List<ForumCategory>> getForumCategoryAll() {
        return restService.getForumCategoryAll();
    }

    public Observable<ForumCategory> getForumCategoryByID(Integer categoryId) {
        return restService.getForumCategoryByID(categoryId);
    }

    public Observable<ForumCategory> addForumCategory(ForumCategory forumCategory) {
        return restService.addForumCategory(forumCategory);
    }

    public Observable<ForumCategory> updateForumCategory(
            Integer categoryId, ForumCategory forumCategory) {
        return restService.updateForumCategory(categoryId, forumCategory);
    }

    public Observable<Response> deleteForumCategory(Integer categoryId) {
        return restService.deleteForumCategory(categoryId);
    }

    public Observable<List<ForumPost>> getForumPostAll() {
        return restService.getForumPostAll();
    }

    public Observable<ForumPost> getForumPostByID(Integer postId) {
        return restService.getForumPostByID(postId);
    }

    public Observable<ForumPost> addForumPost(ForumPost forumPost) {
        return restService.addForumPost(forumPost);
    }

    public Observable<ForumPost> updateForumPost(Integer postId, ForumPost forumPost) {
        return restService.updateForumPost(postId, forumPost);
    }

    public Observable<Response> deleteForumPost(Integer postId) {
        return restService.deleteForumPost(postId);
    }
}
