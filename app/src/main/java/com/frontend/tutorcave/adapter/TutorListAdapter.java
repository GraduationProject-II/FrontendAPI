package com.frontend.tutorcave.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.activity.ViewProfileActivity;
import com.frontend.tutorcave.model.TutorListItemModel;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class TutorListAdapter extends RecyclerView.Adapter<TutorListAdapter.ViewHolder> {

    private final List<TutorListItemModel> models;
    private final Context context;

    public TutorListAdapter(List<TutorListItemModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.menu_tutor_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tutorName.setText(models.get(position).getFullName());
        holder.username.setText(models.get(position).getUsername());
        holder.fields.setText(models.get(position).getFieldOfSpecialization());
        holder.desc.setText(models.get(position).getAboutMe());
        holder.rep.setText(models.get(position).getReputation());
        holder.pp.setImageResource(models.get(position).getProfilePicture());

        holder.cardItem.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), ViewProfileActivity.class);
            // TODO: delete when backend api con. established
            intent.putExtra("name", holder.tutorName.getText());
            intent.putExtra("username", holder.username.getText());
            intent.putExtra("image", models.get(position).getProfilePicture());
            intent.putExtra("rep", holder.rep.getText());
            intent.putExtra("bio", holder.desc.getText());
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tutorName;
        TextView username;
        TextView fields;
        TextView desc;
        TextView rep;
        ImageView pp;
        MaterialCardView cardItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tutorName = itemView.findViewById(R.id.frgTutorListItemName);
            username = itemView.findViewById(R.id.frgTutorListItemUsername);
            fields = itemView.findViewById(R.id.frgTutorListItemFields);
            desc = itemView.findViewById(R.id.frgTutorListItemDesc);
            rep = itemView.findViewById(R.id.frgTutorListItemRep);
            pp = itemView.findViewById(R.id.frgTutorListItemPP);
            cardItem = itemView.findViewById(R.id.frgTutorListItemCard);
        }
    }
}