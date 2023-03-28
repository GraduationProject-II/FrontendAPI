package com.frontend.tutorcave.util;

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
}