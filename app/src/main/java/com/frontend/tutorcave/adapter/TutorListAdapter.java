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
            // TODO: uncomment below code when profile (tutor) for view is created
            //Intent intent = new Intent(view.getContext(), SomeActivity.class);
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