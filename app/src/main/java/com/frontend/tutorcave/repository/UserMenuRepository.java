package com.frontend.tutorcave.repository;

import android.view.MenuItem;

import androidx.fragment.app.Fragment;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public interface UserMenuRepository {
    Fragment setFragment(MenuItem item);
}