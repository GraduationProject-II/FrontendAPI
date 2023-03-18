package com.frontend.tutorcave.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.model.HomeMenuDashboardItemModel;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class HomeDashboardListAdapter extends RecyclerView.Adapter<HomeDashboardListAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<HomeMenuDashboardItemModel> models;
    private Context context;

    public HomeDashboardListAdapter(List<HomeMenuDashboardItemModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.home_dashboard_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.username.setText(models.get(position).getUsername());
        holder.name.setText(models.get(position).getFullName());
        holder.rep.setText(models.get(position).getReputation());
        holder.pp.setImageResource(models.get(position).getProfilePicture());

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: uncomment below code when profile for view is created
                //Intent intent = new Intent(view.getContext(), SomeActivity.class);
                //view.getContext().startActivity(intent);

                // TODO: below is for test purposes, delete afterwards
                Toast.makeText(view.getContext(), "It works for item " + (holder.getAdapterPosition()+1) + "!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    // maybe static
    protected class ViewHolder extends RecyclerView.ViewHolder {

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