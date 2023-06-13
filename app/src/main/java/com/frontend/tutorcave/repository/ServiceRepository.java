package com.frontend.tutorcave.repository;

import android.content.Context;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatImageView;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public interface ServiceRepository {
    void redirect(AppCompatImageView component, Context context, Class<?> cls, String userId);
    void redirect(RelativeLayout component, Context context, Class<?> cls, String userId);
    void redirect(RelativeLayout component, Context context, String testMessage);
}