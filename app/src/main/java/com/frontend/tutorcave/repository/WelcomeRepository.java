package com.frontend.tutorcave.repository;

import android.content.Context;

import androidx.viewpager.widget.ViewPager;

import com.frontend.tutorcave.adapter.WelcomeAdapter;

import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public interface WelcomeRepository {
    void redirect(final Context context, int position, List<Class<?>> options);
    void setCardBackground(
            ViewPager viewPager,
            WelcomeAdapter adapter,
            int position,
            float positionOffSet,
            Integer[] colors
    );
}