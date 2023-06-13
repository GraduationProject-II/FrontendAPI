package com.frontend.tutorcave.util;

import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatImageView;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public final class ComponentUtil {

    private ComponentUtil() {
        // no instance for utils
    }

    /**
     * @param context context of the current view
     * @param goToClass class to be initiated
     * @param name name of the relevant class
     * @apiNote Go to new screen after 8000 milliseconds
     */
    public static void redirectAfterSleep(Context context, Class<?> goToClass, String name) {
        Intent intent = new Intent(context, goToClass);
        TimerUtil.sleep(name);
        context.startActivity(intent);

    }

    /**
     * @param button clickable component
     * @param context context of the current view
     * @param goToClass class to be initiated
     * @apiNote An onClick event to start a new activity
     */
    public static void onClickNewActivity(AppCompatImageView button, Context context, Class<?> goToClass, String userId) {
        button.setOnClickListener(view -> {
            Intent intent = new Intent(context, goToClass);
            intent.putExtra("userId", userId);
            context.startActivity(intent);
        });
    }

    /**
     * @param button clickable component
     * @param context context of the current view
     * @param goToClass class to be initiated
     * @apiNote An onClick event to start a new activity
     */
    public static void onClickNewActivity(RelativeLayout button, Context context, Class<?> goToClass, String userId) {
        button.setOnClickListener(view -> {
            Intent intent = new Intent(context, goToClass);
            intent.putExtra("userId", userId);
            context.startActivity(intent);
        });
    }

    /**
     * @param button clickable component
     * @param context context of the current view
     * @param message test message to be shown
     * @apiNote An onClick event to start a new activity
     * @implNote Current implementation is for test purposes. Apply appropriate changes afterwards
     */
    public static void onClickNewActivity(RelativeLayout button, Context context, String message) {
        button.setOnClickListener(view -> {
            // TODO: impl logic
            // TODO: below task is for test purposes, delete afterwards
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        });
    }
}