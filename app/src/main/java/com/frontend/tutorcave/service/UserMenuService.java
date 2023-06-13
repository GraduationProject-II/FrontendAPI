package com.frontend.tutorcave.service;

import android.view.MenuItem;

import androidx.fragment.app.Fragment;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.fragment.MenuDiscussionFragment;
import com.frontend.tutorcave.fragment.MenuHomeFragment;
import com.frontend.tutorcave.fragment.MenuMessageFragment;
import com.frontend.tutorcave.fragment.MenuSearchTutorFragment;
import com.frontend.tutorcave.model.MenuSelectionModel;
import com.frontend.tutorcave.repository.UserMenuRepository;
import com.frontend.tutorcave.util.SelectionUtil;

import java.util.ArrayList;
import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class UserMenuService implements UserMenuRepository {

    public UserMenuService() {
        // required empty public constructor
    }

    @Override
    public Fragment setFragment(MenuItem menuItem, String userId) {

        MenuSelectionModel selectionModel = new MenuSelectionModel();
        List<Fragment> fragmentList = new ArrayList<>();

        fragmentList.add(new MenuHomeFragment(userId));
        fragmentList.add(new MenuDiscussionFragment(userId));
        fragmentList.add(new MenuSearchTutorFragment(userId));
        fragmentList.add(new MenuMessageFragment());

        selectionModel.setItemList(fragmentList);
        selectionModel.setMenuItem(menuItem);
        selectionModel.setHomeId(R.id.nav_home);
        selectionModel.setDiscussionId(R.id.nav_discussion);
        selectionModel.setFindTutorId(R.id.nav_search_tutor);
        selectionModel.setMessagesId(R.id.nav_message);

        return SelectionUtil.menuSelection(selectionModel);
    }
}