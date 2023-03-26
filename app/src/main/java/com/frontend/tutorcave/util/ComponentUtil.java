package com.frontend.tutorcave.util;

import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import com.frontend.tutorcave.activity.SettingsActivity;
import com.frontend.tutorcave.model.SaveSettingsServiceModel;

import java.util.logging.Level;
import java.util.logging.Logger;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public final class ComponentUtil {

    private ComponentUtil() {
        // no instance for utils
    }

    /**
     * @param button clickable component
     * @param context context of the current view
     * @param goToClass class to be initiated
     * @apiNote An onClick event to start a new activity
     */
    public static void onClickNewActivity(AppCompatImageView button, Context context, Class<?> goToClass) {
        button.setOnClickListener(view -> {
            Intent intent = new Intent(context, goToClass);
            context.startActivity(intent);
        });
    }

    /**
     * @param button clickable component
     * @param context context of the current view
     * @param goToClass class to be initiated
     * @apiNote An onClick event to start a new activity
     */
    public static void onClickNewActivity(RelativeLayout button, Context context, Class<?> goToClass) {
        button.setOnClickListener(view -> {
            Intent intent = new Intent(context, goToClass);
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

    /**
     * @param button clickable component
     * @param context context of the current view
     * @param message test message to be shown
     * @apiNote An onClick event to start a new activity
     * @implNote Current implementation is for test purposes. Apply appropriate changes afterwards
     */
    public static void onClickNewActivity(AppCompatButton button, Context context, String message) {
        button.setOnClickListener(view -> {
            // TODO: impl logic
            // TODO: below task is for test purposes, delete afterwards
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        });
    }

    /**
     * @param button clickable button
     * @param serviceModel model that has the required parameters
     * @apiNote Save the modified settings
     * @implNote Current implementation is for test purposes. Apply appropriate changes afterwards
     */
    public static void saveSettings(AppCompatButton button, SaveSettingsServiceModel serviceModel) {
        button.setOnClickListener(view -> {
            // TODO: implement logic
            // TODO: below task till end of the method is for test purposes, delete afterwards
            boolean isNightTheme;
            boolean isNotification;
            boolean isAccPrivacy;

            isNightTheme = serviceModel.getNightTheme().isChecked();
            isNotification = serviceModel.getNotifications().isChecked();
            isAccPrivacy = serviceModel.getAccountPrivacy().isChecked();

            isSettings(
                    isNightTheme,
                    serviceModel.getContext(),
                    serviceModel.getNightThemeOn(),
                    serviceModel.getNightThemeOff()
            );
            isSettings(
                    isNotification,
                    serviceModel.getContext(),
                    serviceModel.getNotificationsOn(),
                    serviceModel.getNotificationsOff()
            );
            isSettings(
                    isAccPrivacy,
                    serviceModel.getContext(),
                    serviceModel.getAccountPrivacyOn(),
                    serviceModel.getAccountPrivacyOff()
            );

            sleep();
            Toast.makeText(serviceModel.getContext(), "Saved changes", Toast.LENGTH_SHORT).show();
            // delete till here
        });
    }

    /**
     * @param isChecked status of SwitchCompat
     * @param context context of the current view
     * @param messageOn message for ON status
     * @param messageOff message for OFF status
     */
    private static void isSettings(boolean isChecked, Context context, String messageOn, String messageOff) {
        if (isChecked)
            Toast.makeText(context, messageOn, Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, messageOff, Toast.LENGTH_SHORT).show();
    }

    /**
     * @apiNote A timer to wait for 8000 milliseconds
     */
    private static void sleep() {
        Thread timer = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(8000);
                }
                catch (InterruptedException exception) {
                    Logger.getLogger(SettingsActivity.class.getName()).log(Level.WARNING, "Interrupted!: " , exception);
                    Thread.currentThread().interrupt();
                }
            }
        };
        timer.start();
    }
}