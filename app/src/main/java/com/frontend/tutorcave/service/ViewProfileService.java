package com.frontend.tutorcave.service;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.fragment.ProfileDiscussionFragment;
import com.frontend.tutorcave.fragment.ProfileFeedbackFragment;
import com.frontend.tutorcave.fragment.ServicesFragment;
import com.frontend.tutorcave.repository.ViewProfileRepository;
import com.frontend.tutorcave.util.SelectionUtil;

import java.util.ArrayList;
import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class ViewProfileService implements ViewProfileRepository {

    public ViewProfileService() {
        // required empty public constructor
    }

    @Override
    public Fragment setFragment(@NonNull MenuItem item, String userId, String userIdOther) {

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new ProfileDiscussionFragment(userId, userIdOther));
        fragmentList.add(new ProfileFeedbackFragment(userId, userIdOther));
        fragmentList.add(new ServicesFragment(userId, userIdOther));

        int itmDiscussionsId = R.id.vwPrfDiscNav;
        int itmFeedbacksId = R.id.vwPrfFdbNav;
        int itmServicesId = R.id.vwPrfSrvNav;

        return SelectionUtil.bottomNavSelection(
                item,
                itmDiscussionsId,
                itmFeedbacksId,
                itmServicesId,
                fragmentList
        );
    }
}
