package com.frontend.tutorcave.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.model.MessageOtherModel;
import com.frontend.tutorcave.model.MessageOwnModel;

import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_TYPE_MSG_OWN = 0;
    private static final int ITEM_TYPE_MSG_OTHER = 1;
    private final List<Object> models;
    private final Context context;

    public ChatAdapter(List<Object> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;

        if (viewType == ITEM_TYPE_MSG_OWN) {
            view = inflater.inflate(R.layout.message_own_item, parent, false);
            return new ChatOwnViewHolder(view);
        }
        else {
            view = inflater.inflate(R.layout.message_others_item, parent, false);
            return new ChatOthersViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Object modelItm = models.get(position);

        if (holder instanceof ChatOwnViewHolder)
            ((ChatOwnViewHolder) holder).bind((MessageOwnModel) modelItm);
        else
            ((ChatOthersViewHolder) holder).bind((MessageOtherModel) modelItm);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (models.get(position) instanceof MessageOwnModel)
            return ITEM_TYPE_MSG_OWN;
        else
            return ITEM_TYPE_MSG_OTHER;
    }

    protected static class ChatOwnViewHolder extends RecyclerView.ViewHolder {

        TextView msgOwn;
        TextView msgOwnDate;

        public ChatOwnViewHolder(@NonNull View itemView) {
            super(itemView);
            msgOwn = itemView.findViewById(R.id.msgOwnItmContent);
            msgOwnDate = itemView.findViewById(R.id.msgOwnItmDate);
        }

        public void bind(MessageOwnModel model) {
            msgOwn.setText(model.getContent());
            msgOwnDate.setText(model.getDate());
        }
    }

    protected static class ChatOthersViewHolder extends RecyclerView.ViewHolder {

        TextView msgOther;
        TextView msgOtherDate;

        public ChatOthersViewHolder(@NonNull View itemView) {
            super(itemView);
            msgOther = itemView.findViewById(R.id.msgOtherItmContent);
            msgOtherDate = itemView.findViewById(R.id.msgOtherItmDate);
        }

        public void bind(MessageOtherModel model) {
            msgOther.setText(model.getContent());
            msgOtherDate.setText(model.getDate());
        }
    }
}