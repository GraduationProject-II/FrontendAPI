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
import com.frontend.tutorcave.adapter.AccoladeListAdapter;
import com.frontend.tutorcave.model.AccoladeListItemModel;

import java.util.ArrayList;
import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class ProfileAccoladeFragment extends Fragment {

    public ProfileAccoladeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView;
        AccoladeListAdapter listAdapter;
        List<AccoladeListItemModel> accoladeListItemModels;

        recyclerView = view.findViewById(R.id.profileFrgAccoladeListRecyclerVw);

        accoladeListItemModels = new ArrayList<>();
        // TODO: below model assignments are for test purposes
        // retrieve actual data from backend api and delete below assignments afterwards
        accoladeListItemModels.add(new AccoladeListItemModel(
                "Badge 1",
                "fsdsgdfgfsdfksdfughsdckcukgeshfkusdgfkusdgfkudfukgsdkufsgdkufghsdkufhgkusdfhgkusdgfuksdfksuf",
                "Req 1"
        ));
        accoladeListItemModels.add(new AccoladeListItemModel(
                "Badge 2",
                "sjdfohfsdlfılhwheıfopwhfsdkfnsıfgheofhpoehfıphpwhıfıehfıwfpwefwhefowehgfıgwsefwsegfuwgfuw",
                "Req 2"
        ));
        accoladeListItemModels.add(new AccoladeListItemModel(
                "Badge 3",
                "fıweohrwefıwejehwefhoıurjhf8ohurfvskujbcvjkbcsbbvksubvksubvsvdsv",
                "Req 3"
        ));
        accoladeListItemModels.add(new AccoladeListItemModel(
                "Badge 4",
                "vfbva gfv fdv dfbgsdfgfcdgggafghsthsfgvhytjdjsfdghsthtyjhyjsfghfr",
                "Req 4"
        ));
        accoladeListItemModels.add(new AccoladeListItemModel(
                "Badge 5",
                "sgvehthephpekspdkrojşocvmjşvkierfvrfvksdşojcvılhfcıulehflsdnfujrbfslndjcvnvrubefgsoadnfınlfsınfıs",
                "Req 5"
        ));

        listAdapter = new AccoladeListAdapter(accoladeListItemModels, view.getContext());
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile_accolade, container, false);
    }
}