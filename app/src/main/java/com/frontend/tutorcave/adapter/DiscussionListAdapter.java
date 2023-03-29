package com.frontend.tutorcave.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.activity.DiscussionActivity;
import com.frontend.tutorcave.model.DiscussionListItemModel;

import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class DiscussionListAdapter extends RecyclerView.Adapter<DiscussionListAdapter.ViewHolder> {

    private final List<DiscussionListItemModel> models;
    private final Context context;

    public DiscussionListAdapter(List<DiscussionListItemModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.profile_selection_discussion_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(models.get(position).getTitle());
        holder.username.setText(models.get(position).getUsername());
        holder.dateOfCreation.setText(models.get(position).getDateOfCreation());
        holder.lastUpdated.setText(models.get(position).getLastUpdated());
        holder.vote.setText(models.get(position).getVote());

        holder.listItem.setOnClickListener(view -> {
            // TODO: pass only id when backend api con. established
            Intent intent = new Intent(view.getContext(), DiscussionActivity.class);
            intent.putExtra("vote", holder.vote.getText());
            intent.putExtra("title", holder.title.getText());
            intent.putExtra("username", holder.username.getText());
            intent.putExtra("date", holder.dateOfCreation.getText());
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView username;
        TextView dateOfCreation;
        TextView lastUpdated;
        TextView vote;
        CardView listItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.profileVwPgrObjDiscussionTitle);
            username = itemView.findViewById(R.id.profileVwPgrObjDiscussionUsername);
            dateOfCreation = itemView.findViewById(R.id.profileVwPgrObjDiscussionCreated);
            lastUpdated = itemView.findViewById(R.id.profileVwPgrObjDiscussionLastUpdated);
            vote = itemView.findViewById(R.id.profileVwPgrObjDiscussionVote);
            listItem = itemView.findViewById(R.id.profileVwPgrDiscussionCrdVw);
        }
    }
}