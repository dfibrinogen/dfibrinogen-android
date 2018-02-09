package com.dafian.android.dfibrinogen.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dafian.android.dfibrinogen.R;
import com.dafian.android.dfibrinogen.data.entity.UserProfile;
import com.dafian.android.dfibrinogen.ui.extension.TextDrawable;
import com.dafian.android.dfibrinogen.util.ColorGenerator;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

import butterknife.BindView;
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

        @BindView(R.id.iv_user_photo)
        ImageView ivUserPhoto;
        @BindView(R.id.tv_user_name)
        TextView tvUserName;
        @BindView(R.id.tv_user_join_since)
        TextView tvUserJoinSince;

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

        holder.tvUserName.setText(profile.getFullName());
        holder.tvUserJoinSince.setText(profile.getCreatedAt());

        if (TextUtils.isEmpty(profile.getUrlImage())) {

            String name = profile.getFullName().substring(0, 1);
            ColorGenerator generator = ColorGenerator.RANDOM;
            TextDrawable textDrawable = TextDrawable.builder()
                    .buildRound(name, generator.getRandomColor());

            holder.ivUserPhoto.setImageDrawable(textDrawable);
            return;
        }

        Picasso.with(context)
                .load(profile.getUrlImage())
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        holder.ivUserPhoto.setImageBitmap(bitmap);
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {

                        String name = profile.getFullName().substring(0, 1);
                        ColorGenerator generator = ColorGenerator.RANDOM;
                        TextDrawable textDrawable = TextDrawable.builder()
                                .buildRound(name, generator.getRandomColor());

                        holder.ivUserPhoto.setImageDrawable(textDrawable);
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
                });
    }

    @Override
    public int getItemCount() {
        return userProfileList.size();
    }
}
