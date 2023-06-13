package com.frontend.tutorcave.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.activity.ViewProfileActivity;
import com.frontend.tutorcave.model.HomeMenuDashboardItemModel;
import com.frontend.tutorcave.service.ApiService;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class HomeDashboardListAdapter extends RecyclerView.Adapter<HomeDashboardListAdapter.ViewHolder> {

    private final List<HomeMenuDashboardItemModel> models;
    private final Context context;
    private String actualUserId;

    public HomeDashboardListAdapter(List<HomeMenuDashboardItemModel> models, Context context, String actualUserId) {
        this.models = models;
        this.context = context;
        this.actualUserId = actualUserId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.menu_home_dashboard_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(
                models.get(position).getProfilePicture(),
                0,
                models.get(position).getProfilePicture().length
        );
        holder.username.setText(models.get(position).getUsername());
        holder.name.setText(models.get(position).getFullName());
        holder.rep.setText(models.get(position).getReputation());
        holder.pp.setImageBitmap(bitmap);

        holder.item.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), ViewProfileActivity.class);
            ApiService apiService = new ApiService();
            String id = apiService.getUserId(holder.username.getText().toString());

            intent.putExtra("name", holder.name.getText());
            intent.putExtra("username", holder.username.getText());
            intent.putExtra("rep", holder.rep.getText());
            intent.putExtra("image", models.get(position).getProfilePicture());
            intent.putExtra("accountType", apiService.getUserInfo(id).getAccType());
            intent.putExtra("userIdOther", id);
            intent.putExtra("userId", actualUserId);
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        MaterialCardView item;
        AppCompatImageView pp;
        TextView name;
        TextView username;
        TextView rep;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            item = itemView.findViewById(R.id.homeMenuDashboardItemClickable);
            pp = itemView.findViewById(R.id.homeMenuDashboardItemPP);
            name = itemView.findViewById(R.id.txtVwDashboardItemName);
            username = itemView.findViewById(R.id.txVwDashboardItemUsername);
            rep = itemView.findViewById(R.id.txtVwDashboardItemRep);
        }
    }
}