package com.frontend.tutorcave.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.model.WelcomeModel;

import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class WelcomeAdapter extends PagerAdapter {

    private List<WelcomeModel> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public WelcomeAdapter(List<WelcomeModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, container, false);

        ImageView image;
        TextView header;
        TextView desc;

        image = view.findViewById(R.id.imgVwItem);
        header = view.findViewById(R.id.txtItemHeader);
        desc = view.findViewById(R.id.txtItemDesc);

        image.setImageResource(models.get(position).getImage());
        header.setText(models.get(position).getHeader());
        desc.setText(models.get(position).getDescription());

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}