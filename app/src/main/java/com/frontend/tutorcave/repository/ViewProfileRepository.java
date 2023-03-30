package com.frontend.tutorcave.repository;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public interface ViewProfileRepository {
    Fragment setFragment(@NonNull MenuItem item);
}