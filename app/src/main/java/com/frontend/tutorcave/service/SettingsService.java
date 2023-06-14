package com.frontend.tutorcave.service;

import android.content.Context;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatImageView;

import com.frontend.tutorcave.repository.ServiceRepository;
import com.frontend.tutorcave.util.ComponentUtil;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class SettingsService implements ServiceRepository {

    public SettingsService() {
        // required empty public constructor
    }

    @Override
    public void redirect(AppCompatImageView component, Context context, Class<?> cls, String userId) {
        ComponentUtil.onClickNewActivity(component, context, cls, userId);
    }

    @Override
    public void redirect(RelativeLayout component, Context context, Class<?> cls, String userId) {
        ComponentUtil.onClickNewActivity(component, context, cls, userId);
    }
}