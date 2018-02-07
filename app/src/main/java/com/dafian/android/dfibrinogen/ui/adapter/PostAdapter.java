package com.dafian.android.dfibrinogen.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dafian.android.dfibrinogen.R;
import com.dafian.android.dfibrinogen.data.entity.ForumPost;

import java.util.List;

import butterknife.ButterKnife;

/**
 * @author Dafian on 2/7/18
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    private Context context;
    private List<ForumPost> forumPostList;

    public PostAdapter(Context context, List<ForumPost> forumPostList) {
        this.context = context;
        this.forumPostList = forumPostList;
    }

    class PostHolder extends RecyclerView.ViewHolder {

        PostHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.row_forum_post, parent, false);
        return new PostHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostHolder holder, int position) {

        ForumPost post = forumPostList.get(position);
    }

    @Override
    public int getItemCount() {
        return forumPostList.size();
    }
}
