package com.frontend.tutorcave.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.activity.UserMenuActivity;
import com.frontend.tutorcave.service.ApiService;
import com.google.android.material.chip.Chip;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class MenuSearchTutorFragment extends Fragment {

    private final ApiService apiService = new ApiService();
    private String userId;

    public MenuSearchTutorFragment() {
        // Required empty public constructor
    }

    public MenuSearchTutorFragment(String userId) {
        this.userId = userId;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        getParentFragmentManager().beginTransaction().replace(R.id.frgSearchTutorListVw, new MenuTutorListFragment(userId)).commit();

        AppCompatImageView btnBackspace;
        Chip chipTopRated;
        Chip chipTrending;
        Chip chipNewcomer;
        SearchView searchView;

        btnBackspace = view.findViewById(R.id.frgMenuSrcTtrBackspace);
        chipTopRated = requireView().findViewById(R.id.frgSearchTutorChipTopRated);
        chipTrending = requireView().findViewById(R.id.frgSearchTutorChipTrending);
        chipNewcomer = requireView().findViewById(R.id.frgSearchTutorChipNewcomers);
        searchView = view.findViewById(R.id.frgSearchTutorSearchVw);

        // 1st Chip
        chipTopRated.setOnCheckedChangeListener((cmpButtonView, isChecked) -> {
            if (isChecked) {
                chipTrending.setChecked(false);
                chipNewcomer.setChecked(false);
            }
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frgSearchTutorListVw, new MenuTutorListFragment(apiService.listTutorWithHighRep(), userId))
                    .commit();
        });

        // 2nd Chip
        chipTrending.setOnCheckedChangeListener((cmpButtonView, isChecked) -> {
            if (isChecked) {
                chipTopRated.setChecked(false);
                chipNewcomer.setChecked(false);
            }
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frgSearchTutorListVw, new MenuTutorListFragment(apiService.listTutorTrending(), userId))
                    .commit();
        });

        //3rd Chip
        chipNewcomer.setOnCheckedChangeListener((cmpButtonView, isChecked) -> {
            if (isChecked) {
                chipTopRated.setChecked(false);
                chipTrending.setChecked(false);
            }
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frgSearchTutorListVw, new MenuTutorListFragment(apiService.listTutorNewcomer(), userId))
                    .commit();
        });

        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frgSearchTutorListVw, new MenuTutorListFragment(
                                apiService.searchTutor(query),
                                userId))
                        .commit();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frgSearchTutorListVw, new MenuTutorListFragment(
                                apiService.searchTutor(newText),
                                userId))
                        .commit();
                return false;
            }
        });

        btnBackspace.setOnClickListener(view1 -> {
            Intent intent = new Intent(view.getContext(), UserMenuActivity.class);
            intent.putExtra("userId", userId);
            startActivity(intent);
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
}