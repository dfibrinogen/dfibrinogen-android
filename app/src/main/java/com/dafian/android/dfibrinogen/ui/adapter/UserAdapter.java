package com.dafian.android.dfibrinogen.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dafian.android.dfibrinogen.R;
import com.dafian.android.dfibrinogen.data.entity.UserProfile;

import java.util.List;

import butterknife.ButterKnife;

/**
 * @author Dafian on 2/7/18
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    private Context context;
    private List<UserProfile> userProfileList;

    public UserAdapter(Context context, List<UserProfile> userProfileList) {
        this.context = context;
        this.userProfileList = userProfileList;
    }

    class UserHolder extends RecyclerView.ViewHolder {

        UserHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.row_user, parent, false);
        return new UserHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {

        UserProfile profile = userProfileList.get(position);
    }

    @Override
    public int getItemCount() {
        return userProfileList.size();
    }
}
