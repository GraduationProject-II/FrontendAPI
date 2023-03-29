package com.frontend.tutorcave.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.model.FeedbackListItemModel;

import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class FeedbackListAdapter extends RecyclerView.Adapter<FeedbackListAdapter.ViewHolder> {

    private final List<FeedbackListItemModel> models;
    private final Context context;

    public FeedbackListAdapter(List<FeedbackListItemModel> models, Context context) {
        this.models = models;
        this.context = context;
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
        holder.profilePic.setImageResource(models.get(position).getTutorPP());
        holder.username.setText(models.get(position).getTutorUsername());
        holder.reputation.setText(models.get(position).getTutorReputation());
        holder.title.setText(models.get(position).getServiceTitle());
        holder.desc.setText(models.get(position).getServiceDescription());

        holder.itemClickable.setOnClickListener(view -> {
            // TODO: uncomment below code when Tutoring service's screen is created
            //Intent intent = new Intent(view.getContext(), TutorServiceActivity.class);
            //view.getContext().startActivity(intent);

            // TODO: below is for test purposes, delete afterwards
            Toast.makeText(view.getContext(), "It works for item " + (holder.getAdapterPosition()+1) + "!!!", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        CardView itemClickable;
        ImageView profilePic;
        TextView username;
        TextView reputation;
        TextView title;
        TextView desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemClickable = itemView.findViewById(R.id.profileObjFeedbackCrdVw);
            profilePic = itemView.findViewById(R.id.profileObjFeedbackPP);
            username = itemView.findViewById(R.id.profileObjFeedbackUsername);
            reputation = itemView.findViewById(R.id.profileObjFeedbackRep);
            title = itemView.findViewById(R.id.profileObjFeedbackServiceTitle);
            desc = itemView.findViewById(R.id.profileObjFeedbackServiceDesc);
        }
    }
}