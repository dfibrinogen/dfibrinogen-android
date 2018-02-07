package com.dafian.android.dfibrinogen.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dafian.android.dfibrinogen.R;
import com.dafian.android.dfibrinogen.data.entity.ForumCategory;

import java.util.List;

import butterknife.ButterKnife;

/**
 * @author Dafian on 2/7/18
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    private Context context;
    private List<ForumCategory> forumCategoryList;

    public CategoryAdapter(Context context, List<ForumCategory> forumCategoryList) {
        this.context = context;
        this.forumCategoryList = forumCategoryList;
    }

    class CategoryHolder extends RecyclerView.ViewHolder {

        CategoryHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.row_forum_category, parent, false);
        return new CategoryHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryHolder holder, int position) {

        ForumCategory category = forumCategoryList.get(position);
    }

    @Override
    public int getItemCount() {
        return forumCategoryList.size();
    }
}
