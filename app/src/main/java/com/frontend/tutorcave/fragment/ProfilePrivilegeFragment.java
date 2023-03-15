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
import com.frontend.tutorcave.adapter.PrivilegeListAdapter;
import com.frontend.tutorcave.model.PrivilegeListItemModel;

import java.util.ArrayList;
import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class ProfilePrivilegeFragment extends Fragment {

    public ProfilePrivilegeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView;
        PrivilegeListAdapter listAdapter;
        List<PrivilegeListItemModel> privilegeListItemModels;

        recyclerView = view.findViewById(R.id.profileFrgPrivListRecyclerVw);

        privilegeListItemModels = new ArrayList<>();
        // TODO: below model assignments are for test purposes
        // retrieve actual data from backend api and delete below assignments afterwards
        privilegeListItemModels.add(new PrivilegeListItemModel(
                "Centaurs",
                "The centaurs are icy comet-like bodies whose orbits have semi-major axes greater than Jupiter's and less than Neptune's. These are former Kuiper belt and scattered disc objects that were gravitationally perturbed closer to the Sun by the outer planets, and are expected to become comets or get ejected out of the Solar System.",
                PrivilegeListItemModel.STATUS.LOCKED
        ));
        privilegeListItemModels.add(new PrivilegeListItemModel(
                "Makemake",
                "Makemake, although smaller than Pluto, is the largest known object in the classical Kuiper belt. Makemake is the brightest object in the Kuiper belt after Pluto. Discovered in 2005, it was officially named in 2009. Its orbit is far more inclined than Pluto's, at 29°. It has one known moon.",
                PrivilegeListItemModel.STATUS.LOCKED
        ));
        privilegeListItemModels.add(new PrivilegeListItemModel(
                "Haumea",
                "Haumea is in an orbit similar to Makemake, except that it is in a temporary 7:12 orbital resonance with Neptune. Like Makemake, it was discovered in 2005. Uniquely among the dwarf planets, Haumea possess a ring system, two known moons named Hiʻiaka and Namaka, and rotates so quickly that it is stretched into an ellipsoid. It is part of a collisional family of Kuiper belt objects that share similar orbits, which suggests a giant collision took place on Haumea and ejected its fragments into space billions of years ago.",
                PrivilegeListItemModel.STATUS.UNLOCKED
        ));
        privilegeListItemModels.add(new PrivilegeListItemModel(
                "Quaoar",
                "Quaoar is the second-largest known object in the classical Kuiper belt, after Makemake. Its orbit is significantly less eccentric and inclined than those of Makemake or Haumea. It possesses a ring system and one known moon, Weywot.",
                PrivilegeListItemModel.STATUS.LOCKED
        ));
        privilegeListItemModels.add(new PrivilegeListItemModel(
                "Orcus",
                "Orcus is in the same 2:3 orbital resonance with Neptune as Pluto, and is the largest such object after Pluto itself. Its eccentricity and inclination are similar to Pluto's, but its perihelion lies about 120° from that of Pluto. Thus, the phase of Orcus's orbit is opposite to Pluto's",
                PrivilegeListItemModel.STATUS.UNLOCKED
        ));
        privilegeListItemModels.add(new PrivilegeListItemModel(
                "Charon",
                "Charon, known as Pluto I, is the largest of the five known natural satellites of the dwarf planet Pluto. It has a mean radius of 606 km. Charon is the sixth-largest known trans-Neptunian object after Pluto, Eris, Haumea, Makemake and Gonggong.",
                PrivilegeListItemModel.STATUS.UNLOCKED
        ));
        privilegeListItemModels.add(new PrivilegeListItemModel(
                "Sedna",
                "Sedna is a dwarf planet in the outermost reaches of the Solar System discovered in 2003. Spectroscopy has revealed that Sedna's surface composition is largely a mixture of water, methane, and nitrogen ices with tholins, similar to those of some other trans-Neptunian objects. Its surface is one of the reddest among Solar System objects.",
                PrivilegeListItemModel.STATUS.LOCKED
        ));

        listAdapter = new PrivilegeListAdapter(privilegeListItemModels, view.getContext());
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile_privilege, container, false);
    }
}