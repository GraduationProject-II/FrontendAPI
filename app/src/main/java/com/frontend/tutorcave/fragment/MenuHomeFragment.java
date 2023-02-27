package com.frontend.tutorcave.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.frontend.tutorcave.R;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class MenuHomeFragment extends Fragment {

    private TextView viewStats;
    private AppCompatImageView btnProfile;

    private static final String ARG_PARAM1 = "param1"; // rename
    private static final String ARG_PARAM2 = "param2"; // rename

    private String mParam1; // rename
    private String mParam2; // rename

    public MenuHomeFragment() {
        // Required empty public constructor
    }

    /**
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuHomeFragment.
     */
    public static MenuHomeFragment newInstance(String param1, String param2) {
        MenuHomeFragment fragment = new MenuHomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        viewStats = (TextView) requireView().findViewById(R.id.frgHomeBtnViewAllStats);
        btnProfile = (AppCompatImageView) requireView().findViewById(R.id.frgHomeBtnProfile);

        viewStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: complete below task
                Intent intent;
                //intent = new Intent(MenuHomeFragment.this, AccoladeActivity.class);
                //startActivity(intent);
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: complete below task
                Intent intent;
                //intent = new Intent(MenuHomeFragment.this, ProfileActivity.class);
                //startActivity(intent);
            }
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
        return inflater.inflate(R.layout.fragment_menu_home, container, false);
    }
}