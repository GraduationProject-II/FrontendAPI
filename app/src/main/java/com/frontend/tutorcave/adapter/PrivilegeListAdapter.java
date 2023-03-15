package com.frontend.tutorcave.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.model.PrivilegeListItemModel;

import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class PrivilegeListAdapter extends RecyclerView.Adapter<PrivilegeListAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<PrivilegeListItemModel> models;
    private Context context;

    public PrivilegeListAdapter(List<PrivilegeListItemModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.profile_selection_privilege_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(models.get(position).getName());
        holder.description.setText(models.get(position).getDesc());
        holder.status.setText(models.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    // maybe static
    protected class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView description;
        TextView status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.profileObjPrivName);
            description = itemView.findViewById(R.id.profileObjPrivDesc);
            status = itemView.findViewById(R.id.profileObjPrivStatus);
        }
    }
}