package com.dafian.android.dfibrinogen.data.api;

import com.dafian.android.dfibrinogen.data.entity.ForumCategory;
import com.dafian.android.dfibrinogen.data.entity.ForumPost;
import com.dafian.android.dfibrinogen.data.entity.Response;
import com.dafian.android.dfibrinogen.data.entity.UserAuth;
import com.dafian.android.dfibrinogen.data.entity.UserProfile;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * @author Dafian on 2/7/18
 */

public interface RestService {

    //--- Auth Group

    @POST("auth/login")
    Observable<UserProfile> userLogin(@Body UserAuth userAuth);

    @POST("auth/register")
    Observable<UserProfile> userRegister(@Body UserAuth userAuth);

    //--- User Group

    @GET("api/v1/users")
    Observable<List<UserProfile>> getUserProfileAll();

    @GET("api/v1/profiles/{id}")
    Observable<UserProfile> getUserProfileByID(@Path("id") Integer userId);

    @PUT("api/v1/profiles/{id}")
    Observable<UserProfile> updateUserProfile(
            @Path("id") Integer userId, @Body UserProfile userProfile);

    //--- Forum Category Group

    @GET("api/v1/categories")
    Observable<List<ForumCategory>> getForumCategoryAll();

    @GET("api/v1/categories/{id}")
    Observable<ForumCategory> getForumCategoryByID(@Path("id") Integer categoryId);

    @POST("api/v1/categories")
    Observable<ForumCategory> addForumCategory(@Body ForumCategory forumCategory);

    @PUT("api/v1/categories/{id}")
    Observable<ForumCategory> updateForumCategory(
            @Path("id") Integer categoryId, @Body ForumCategory forumCategory);

    @DELETE("api/v1/categories/{id}")
    Observable<Response> deleteForumCategory(@Path("id") Integer categoryId);

    //--- Forum Post Group

    @GET("api/v1/posts")
    Observable<List<ForumPost>> getForumPostAll();

    @GET("api/v1/posts/{id}")
    Observable<ForumPost> getForumPostByID(@Path("id") Integer postId);

    @POST("api/v1/posts")
    Observable<ForumPost> addForumPost(@Body ForumPost forumPost);

    @PUT("api/v1/posts/{id}")
    Observable<ForumPost> updateForumPost(
            @Path("id") Integer postId, @Body ForumPost forumPost);

    @DELETE("api/v1/posts/{id}")
    Observable<Response> deleteForumPost(@Path("id") Integer postId);
}
