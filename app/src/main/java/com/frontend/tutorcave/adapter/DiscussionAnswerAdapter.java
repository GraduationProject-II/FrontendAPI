package com.frontend.tutorcave.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.activity.ViewProfileActivity;
import com.frontend.tutorcave.model.DiscussionAnswerModel;
import com.frontend.tutorcave.model.UserInfoModel;
import com.frontend.tutorcave.service.ApiService;
import com.frontend.tutorcave.util.TimerUtil;

import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class DiscussionAnswerAdapter extends RecyclerView.Adapter<DiscussionAnswerAdapter.ViewHolder> {

    private final List<DiscussionAnswerModel> models;
    private final Context context;
    private final ApiService apiService = new ApiService();
    private String actualUserId;

    public DiscussionAnswerAdapter(List<DiscussionAnswerModel> models, Context context, String actualUserId) {
        this.models = models;
        this.context = context;
        this.actualUserId = actualUserId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.discussion_answer_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        byte[] imageData = models.get(position).getOwnerPP();
        Bitmap bitmap = BitmapFactory.decodeByteArray(imageData, 0, imageData.length);

        holder.profilePic.setImageBitmap(bitmap);
        holder.votes.setText(models.get(position).getVote());
        holder.title.setText(models.get(position).getTitle());
        holder.desc.setText(models.get(position).getDescription());
        holder.username.setText(models.get(position).getOwnerUsername());

        holder.username.setOnClickListener(view -> {
            String userId = apiService.getUserId(models.get(position).getOwnerUsername());
            UserInfoModel userModel = apiService.getUserInfo(userId);
            Intent intent = new Intent(view.getContext(), ViewProfileActivity.class);
            intent.putExtra("image", userModel.getImage());
            intent.putExtra("username", userModel.getUsername());
            intent.putExtra("accountType", userModel.getAccType());
            intent.putExtra("rep", userModel.getReputation());
            intent.putExtra("name", userModel.getFullName());
            intent.putExtra("userIdOther", userId);
            intent.putExtra("userId", actualUserId);
            view.getContext().startActivity(intent);
        });

        holder.cardImage.setOnClickListener(view -> {
            String userId = apiService.getUserId(models.get(position).getOwnerUsername());
            UserInfoModel userModel = apiService.getUserInfo(userId);
            Intent intent = new Intent(view.getContext(), ViewProfileActivity.class);
            intent.putExtra("image", userModel.getImage());
            intent.putExtra("username", userModel.getUsername());
            intent.putExtra("accountType", userModel.getAccType());
            intent.putExtra("rep", userModel.getAccType());
            intent.putExtra("name", userModel.getFullName());
            intent.putExtra("userIdOther", userId);
            intent.putExtra("userId", actualUserId);
            view.getContext().startActivity(intent);
        });

        holder.voteUp.setOnClickListener(view -> {
            String newVote = apiService.voteUpAnswer(models.get(position).getId());
            holder.votes.setText(newVote);
            Toast.makeText(context, "Operation successful", Toast.LENGTH_SHORT).show();
            TimerUtil.disableVote(holder.voteUp, view.getClass().getName());
            holder.voteUp.setEnabled(true);
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        TextView votes;
        TextView title;
        TextView desc;
        TextView username;
        ImageView profilePic;
        AppCompatImageView voteUp;
        CardView cardImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            votes = itemView.findViewById(R.id.dscAnswItmTxtVote);
            title = itemView.findViewById(R.id.dscAnswItmTxtTitle);
            desc = itemView.findViewById(R.id.dscAnswItmTxtDesc);
            username = itemView.findViewById(R.id.dscAnswItemTxtUsername);
            profilePic = itemView.findViewById(R.id.dscAnswItmImgVwPP);
            voteUp = itemView.findViewById(R.id.dscAnswItmImgVwVote);
            cardImage = itemView.findViewById(R.id.discAnswVwCrdUser);
        }
    }
}