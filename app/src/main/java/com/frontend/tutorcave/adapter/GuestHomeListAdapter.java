package com.frontend.tutorcave.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

public class GuestHomeListAdapter extends RecyclerView.Adapter<GuestHomeListAdapter.ViewHolder> {

    private final List<HomeMenuDashboardItemModel> models;
    private final Context context;

    public GuestHomeListAdapter(List<HomeMenuDashboardItemModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.menu_home_dashboard_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(
                models.get(position).getProfilePicture(),
                0,
                models.get(position).getProfilePicture().length);
        holder.username.setText(models.get(position).getUsername());
        holder.name.setText(models.get(position).getFullName());
        holder.rep.setText(models.get(position).getReputation());
        holder.pp.setImageBitmap(bitmap);

        holder.item.setOnClickListener(view ->
                Toast.makeText(context, view.getContext().getString(R.string.login_to_access), Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
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