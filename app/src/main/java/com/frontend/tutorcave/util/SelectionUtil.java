package com.frontend.tutorcave.util;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.frontend.tutorcave.R;

import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public final class SelectionUtil {

    private SelectionUtil() {
        // no instance for utils
    }

    /**
     * @param context context of the current view
     * @param position position of the selection
     * @param options options for user selection
     * @return new Intent of the selected class
     * @apiNote Redirects to new screen regarding the selection
     */
    public static Intent cardSelection(
            final Context context,
            int position,
            List<Class<?>> options
    ) {
        Intent intent;
        switch (position) {
            case 0:
                intent = new Intent(context, options.get(0));
                break;
            case 1:
                intent = new Intent(context, options.get(1));
                break;
            case 2:
                // test
                intent = new Intent(context, options.get(2));

                // TODO: complete below task
                //intent = new Intent(WelcomeActivity.this, GuestMenuActivity.class);
                //startActivity(intent);
                break;
            default:
                Toast.makeText(context, R.string.selection_invalid, Toast.LENGTH_SHORT).show();
                intent = new Intent(context, context.getClass());
        }
        return intent;
    }
}