package com.frontend.tutorcave.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.adapter.TutorListAdapter;
import com.frontend.tutorcave.model.TutorListItemModel;

import java.util.ArrayList;
import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class MenuTutorListFragment extends Fragment {

    public MenuTutorListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView;
        TutorListAdapter listAdapter;
        List<TutorListItemModel> tutorListItemModels;

        recyclerView = view.findViewById(R.id.frgTutorRecyclerVw);

        tutorListItemModels = new ArrayList<>();
        // TODO: below model assignment is for test purposes
        // retrieve actual data from backend api and delete below assignments
        tutorListItemModels.add(new TutorListItemModel(
                "Full Name #1",
                "username#1",
                "fwefwfwewfwefewffaf fsadf efdsf f wef",
                "jefwefwejleowflff",
                "1533",
                R.drawable.test_profile_pic_1
        ));
        tutorListItemModels.add(new TutorListItemModel(
                "Full Name #2",
                "username#2",
                "eıfw ef wefljwef wfjşojedf şwoefjfjs şofjoşew ",
                "profpışfsafhasdhıdlcrefuşsfiwcuşsdfhsidfhılhnfgvurehncjklnj hgfekrlh ndslnf lfjlwdjf lx sfjlsaişfjfhewilflkw",
                "97342",
                R.drawable.test_profile_pic_2
        ));
        tutorListItemModels.add(new TutorListItemModel(
                "Full Name #3",
                "username#3",
                "ıjper r ıe fwpj  pwjfpjw  pwşefpşwfş woşw",
                "osfhhfshfhsdchcjıphıwpcpefıhflopeıcvfıhvıehvclsvpervvcrveverv",
                "122",
                R.drawable.test_profile_pic_3
        ));
        tutorListItemModels.add(new TutorListItemModel(
                "Full Name #4",
                "username#4",
                "cewcwc wefewf ewf   we  fwef wefwe wefwefwefw   wef e fwe f wef wefwefwfw",
                "sdcsnclscıhıeclechlıesclıescıecopeclsecnlıesncıesncıencıelnscseıcleıcnslecn",
                "432",
                R.drawable.test_profile_pic_4
        ));

        listAdapter = new TutorListAdapter(tutorListItemModels, view.getContext());
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_tutor_list, container, false);
    }
}