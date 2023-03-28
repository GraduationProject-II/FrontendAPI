package com.frontend.tutorcave.util;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.model.MenuSelectionModel;

import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public final class SelectionUtil {

    private SelectionUtil() {
        // no instance for utils
    }

    /**
     * @param context Context of the current view
     * @param position Position of the selection
     * @param options Options for user selection
     * @return New Intent of the selected class
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

    /**
     * @param model The model which contains selected item's ID, list of items and their IDs
     * @return Returns a fragment of choice
     * @apiNote Redirects to the selected fragment's screen
     */
    public static Fragment menuSelection(MenuSelectionModel model) {
        Fragment fragment = model.getItemList().get(0);

        if (isID(model.getMenuItem().getItemId(), model.getHomeId())) fragment = model.getItemList().get(0);
        if (isID(model.getMenuItem().getItemId(), model.getDiscussionId())) fragment = model.getItemList().get(1);
        if (isID(model.getMenuItem().getItemId(), model.getFindTutorId())) fragment = model.getItemList().get(2);
        if (isID(model.getMenuItem().getItemId(), model.getMessagesId())) fragment = model.getItemList().get(3);

        return fragment;
    }

    /**
     * @param itemSelectedId Selected item's ID
     * @param itemId ID of the option
     * @return True if IDs match or false otherwise
     * @apiNote Comparison of two IDs
     */
    private static boolean isID(int itemSelectedId, int itemId) {
        return itemSelectedId == itemId;
    }
}