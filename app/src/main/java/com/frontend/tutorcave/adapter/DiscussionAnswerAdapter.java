package com.frontend.tutorcave.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.model.DiscussionAnswerModel;

import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class DiscussionAnswerAdapter extends RecyclerView.Adapter<DiscussionAnswerAdapter.ViewHolder> {

    private final List<DiscussionAnswerModel> models;
    private final Context context;

    public DiscussionAnswerAdapter(List<DiscussionAnswerModel> models, Context context) {
        this.models = models;
        this.context = context;
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
        holder.votes.setText(models.get(position).getVote());
        holder.title.setText(models.get(position).getTitle());
        holder.desc.setText(models.get(position).getDescription());
        holder.date.setText(models.get(position).getDateOfCreation());
        holder.username.setText(models.get(position).getOwnerUsername());
        holder.profilePic.setImageResource(models.get(position).getOwnerPP());

        holder.username.setOnClickListener(view -> {
            // TODO: below code is for test purposes, delete afterwards
            // and start a new intent for profile (others/view) screen
            Toast.makeText(view.getContext(), "Username #" + (holder.getAdapterPosition()+1), Toast.LENGTH_SHORT).show();
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
        TextView date;
        TextView username;
        ImageView profilePic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            votes = itemView.findViewById(R.id.dscAnswItmTxtVote);
            title = itemView.findViewById(R.id.dscAnswItmTxtTitle);
            desc = itemView.findViewById(R.id.dscAnswItmTxtDesc);
            date = itemView.findViewById(R.id.dscAnswItmTxtDate);
            username = itemView.findViewById(R.id.dscAnswItemTxtUsername);
            profilePic = itemView.findViewById(R.id.dscAnswItmImgVwPP);
        }
    }
}