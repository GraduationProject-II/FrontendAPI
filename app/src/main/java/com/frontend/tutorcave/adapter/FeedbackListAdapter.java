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

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.activity.ViewProfileActivity;
import com.frontend.tutorcave.model.FeedbackListItemModel;
import com.frontend.tutorcave.model.UserInfoModel;
import com.frontend.tutorcave.service.ApiService;

import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class FeedbackListAdapter extends RecyclerView.Adapter<FeedbackListAdapter.ViewHolder> {

    private final List<FeedbackListItemModel> models;
    private final Context context;
    private final ApiService apiService = new ApiService();
    private String actualUserId;

    public FeedbackListAdapter(List<FeedbackListItemModel> models, Context context, String actualUserId) {
        this.models = models;
        this.context = context;
        this.actualUserId = actualUserId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.profile_selection_feedback_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(
                models.get(position).getTutorPP(),
                0,
                models.get(position).getTutorPP().length
        );
        holder.profilePic.setImageBitmap(bitmap);
        holder.username.setText(models.get(position).getTutorUsername());
        holder.reputation.setText(models.get(position).getTutorReputation());
        holder.price.setText(models.get(position).getServiceTitle());
        holder.desc.setText(models.get(position).getServiceDescription());
        holder.content.setText(models.get(position).getContent());
        holder.flag.setText(setFeedbackFlag(models.get(position).getFlag()));

        holder.profilePic.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), ViewProfileActivity.class);
            String id = apiService.getUserId(models.get(position).getTutorUsername());
            UserInfoModel userModel = apiService.getUserInfo(id);

            intent.putExtra("username", userModel.getUsername());
            intent.putExtra("rep", userModel.getReputation());
            intent.putExtra("image", userModel.getImage());
            intent.putExtra("name", userModel.getFullName());
            intent.putExtra("accountType", userModel.getAccType());
            intent.putExtra("userIdOther", id);
            intent.putExtra("userId", actualUserId);
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    private String setFeedbackFlag(String flag) {
        final String POSITIVE = "Positive";
        final String NEGATIVE = "Negative";
        String result = "";
        if (flag.equals("+"))
            result = POSITIVE;
        else result = NEGATIVE;
        return result;
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        CardView itemClickable;
        ImageView profilePic;
        TextView username;
        TextView reputation;
        TextView price;
        TextView desc;
        TextView content;
        TextView flag;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemClickable = itemView.findViewById(R.id.profileObjFeedbackCrdVw);
            profilePic = itemView.findViewById(R.id.profileObjFeedbackPP);
            username = itemView.findViewById(R.id.profileObjFeedbackUsername);
            reputation = itemView.findViewById(R.id.profileObjFeedbackRep);
            price = itemView.findViewById(R.id.profileObjFeedbackServicePrice);
            desc = itemView.findViewById(R.id.profileObjFeedbackServiceDesc);
            content = itemView.findViewById(R.id.prfSelFdbItmContent);
            flag = itemView.findViewById(R.id.prfSelFdbItmFlag);
        }
    }
}