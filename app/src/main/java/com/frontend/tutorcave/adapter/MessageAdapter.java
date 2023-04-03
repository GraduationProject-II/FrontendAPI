package com.frontend.tutorcave.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.activity.ChatActivity;
import com.frontend.tutorcave.model.MessageItemModel;

import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private final List<MessageItemModel> models;
    private final Context context;

    public MessageAdapter(List<MessageItemModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.message_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.pp.setImageResource(models.get(position).getProfilePicture());
        holder.name.setText(models.get(position).getName());
        holder.msg.setText(models.get(position).getContent());

        holder.rootLayout.setOnClickListener(view -> {
            Intent intent = new Intent(context, ChatActivity.class);
            intent.putExtra("image", models.get(position).getProfilePicture());
            intent.putExtra("name", holder.name.getText());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout rootLayout;
        ImageView pp;
        TextView name;
        TextView msg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rootLayout = itemView.findViewById(R.id.messageItemLytRoot);
            pp = itemView.findViewById(R.id.messageItemPP);
            name = itemView.findViewById(R.id.messageItemName);
            msg = itemView.findViewById(R.id.messageItemMsg);
        }
    }
}