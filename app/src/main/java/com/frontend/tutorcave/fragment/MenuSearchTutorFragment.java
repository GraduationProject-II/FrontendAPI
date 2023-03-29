package com.frontend.tutorcave.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.frontend.tutorcave.R;
import com.google.android.material.chip.Chip;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class MenuSearchTutorFragment extends Fragment {

    // TODO: searchView.clearFocus(), onQueryTextListener()

    // TODO: set anim

    public MenuSearchTutorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        getParentFragmentManager().beginTransaction().replace(R.id.frgSearchTutorListVw, new MenuTutorListFragment()).commit();

        Chip chipTopRated;
        Chip chipTrending;
        Chip chipNewcomer;

        chipTopRated = (Chip) requireView().findViewById(R.id.frgSearchTutorChipTopRated);
        chipTrending = (Chip) requireView().findViewById(R.id.frgSearchTutorChipTrending);
        chipNewcomer = (Chip) requireView().findViewById(R.id.frgSearchTutorChipNewcomers);

        // 1st Chip
        chipTopRated.setOnCheckedChangeListener((cmpButtonView, isChecked) -> {
            // TODO: test purposes, delete later
            testToast(isChecked, R.string.test1);
            // TODO: add else statement
        });

        // 2nd Chip
        chipTrending.setOnCheckedChangeListener((cmpButtonView, isChecked) -> {
            // TODO: test purposes, delete later
            testToast(isChecked, R.string.test2);
            // TODO: add else statement
        });

        //3rd Chip
        chipNewcomer.setOnCheckedChangeListener((cmpButtonView, isChecked) -> {
            // TODO: test purposes, delete later
            testToast(isChecked, R.string.test3);
            // TODO: add else statement
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_search_tutor, container, false);
    }

    private void testToast(boolean isChecked, int messageId) {
        if (isChecked)
            Toast.makeText(MenuSearchTutorFragment.this.getContext(), messageId, Toast.LENGTH_SHORT).show();
    }
}