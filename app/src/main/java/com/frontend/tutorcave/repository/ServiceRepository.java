package com.frontend.tutorcave.repository;

import android.content.Context;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import com.frontend.tutorcave.model.SaveSettingsServiceModel;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public interface ServiceRepository {
    void redirect(AppCompatImageView component, Context context, Class<?> cls);
    void redirect(RelativeLayout component, Context context, Class<?> cls);
    void redirect(RelativeLayout component, Context context, String testMessage);
    void redirect(AppCompatButton component, Context context, String testMessage);
    void saveSettings(AppCompatButton button, SaveSettingsServiceModel saveSettingsServiceModel);
}