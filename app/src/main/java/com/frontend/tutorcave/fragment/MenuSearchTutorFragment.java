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
    private Chip chipTopRated, chipTrending, chipNewcomer;

    // TODO: set anim

    // TODO: check usage of below variables, safe-delete
    private static final String ARG_PARAM1 = "param1"; // rename
    private static final String ARG_PARAM2 = "param2"; // rename
    private String mParam1; // rename
    private String mParam2; // rename

    public MenuSearchTutorFragment() {
        // Required empty public constructor
    }

    // TODO: check usage and safe-delete
    /**
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuSearchTutorFragment.
     */
    public static MenuSearchTutorFragment newInstance(String param1, String param2) {
        MenuSearchTutorFragment fragment = new MenuSearchTutorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        chipTopRated = (Chip) requireView().findViewById(R.id.frgSearchTutorChipTopRated);
        chipTrending = (Chip) requireView().findViewById(R.id.frgSearchTutorChipTrending);
        chipNewcomer = (Chip) requireView().findViewById(R.id.frgSearchTutorChipNewcomers);

        // 1st Chip
        chipTopRated.setOnCheckedChangeListener((cmpButtonView, isChecked) -> {
            if (isChecked) {
                // TODO: test purposes, delete later
                Toast.makeText(MenuSearchTutorFragment.this.getContext(), R.string.test1, Toast.LENGTH_SHORT).show();
            }
            // TODO: add else statement
        });

        // 2nd Chip
        chipTrending.setOnCheckedChangeListener((cmpButtonView, isChecked) -> {
            if (isChecked) {
                // TODO: test purposes, delete later
                Toast.makeText(MenuSearchTutorFragment.this.getContext(), R.string.test2, Toast.LENGTH_SHORT).show();
            }
            // TODO: add else statement
        });

        //3rd Chip
        chipNewcomer.setOnCheckedChangeListener((cmpButtonView, isChecked) -> {
            if (isChecked) {
                // TODO: test purposes, delete later
                Toast.makeText(MenuSearchTutorFragment.this.getContext(), R.string.test3, Toast.LENGTH_SHORT).show();
            }
            // TODO: add else statement
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_search_tutor, container, false);
    }
}