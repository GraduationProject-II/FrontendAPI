package com.frontend.tutorcave.util;

import androidx.appcompat.widget.AppCompatImageView;

import java.util.logging.Level;
import java.util.logging.Logger;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public final class TimerUtil {

    private TimerUtil() {
        // no instance for utils
    }

    /**
     * @param name name of the relevant class
     * @apiNote Sleep for 8000 milliseconds
     */
    public static void sleep(String name) {
        Thread timer = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(8000);
                } catch (InterruptedException exception) {
                    Logger.getLogger(name).log(Level.WARNING, "Interrupted!: ", exception);
                    Thread.currentThread().interrupt();
                }
            }
        };
        timer.start();
    }

    /**
     * @param component component to be disabled
     * @param className name of the class which this method invoked from
     */
    public static void disableVote(AppCompatImageView component, String className) {
        Thread timer = new Thread() {
            @Override
            public void run() {
                try {
                    component.setEnabled(false);
                    sleep(120000);
                } catch (InterruptedException exception) {
                    Logger.getLogger(className).log(Level.WARNING, "Interrupted!: ", exception);
                }
            }
        };
        timer.start();
    }
}