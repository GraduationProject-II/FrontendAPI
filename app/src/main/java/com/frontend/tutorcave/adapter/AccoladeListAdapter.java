package com.frontend.tutorcave.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.model.AccoladeListItemModel;

import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class AccoladeListAdapter extends RecyclerView.Adapter<AccoladeListAdapter.ViewHolder> {

    private final List<AccoladeListItemModel> models;
    private final Context context;

    public AccoladeListAdapter(List<AccoladeListItemModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.profile_selection_accolade_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.badge.setText(models.get(position).getBadge());
        holder.desc.setText(models.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        TextView badge;
        TextView desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            badge = itemView.findViewById(R.id.profileObjAccoladeBadge);
            desc = itemView.findViewById(R.id.profileObjAccoladeDesc);
        }
    }
}