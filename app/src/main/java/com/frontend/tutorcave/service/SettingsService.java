package com.frontend.tutorcave.service;

import android.content.Context;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import com.frontend.tutorcave.model.SaveSettingsServiceModel;
import com.frontend.tutorcave.repository.ServiceRepository;
import com.frontend.tutorcave.util.ComponentUtil;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class SettingsService implements ServiceRepository {

    public SettingsService() {
        // required empty public constructor
    }

    @Override
    public void redirect(AppCompatImageView component, Context context, Class<?> cls) {
        ComponentUtil.onClickNewActivity(component, context, cls);
    }

    @Override
    public void redirect(RelativeLayout component, Context context, Class<?> cls) {
        ComponentUtil.onClickNewActivity(component, context, cls);
    }

    @Override
    public void redirect(RelativeLayout component, Context context, String testMessage) {
        ComponentUtil.onClickNewActivity(component, context, testMessage);
    }

    @Override
    public void redirect(AppCompatButton component, Context context, String testMessage) {
        ComponentUtil.onClickNewActivity(component, context, testMessage);
    }

    @Override
    public void saveSettings(AppCompatButton button, SaveSettingsServiceModel saveSettingsServiceModel) {
        ComponentUtil.saveSettings(button, saveSettingsServiceModel);
    }
}