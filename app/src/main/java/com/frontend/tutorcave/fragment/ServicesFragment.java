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
import com.frontend.tutorcave.adapter.ServiceListAdapter;
import com.frontend.tutorcave.model.ServiceListItemModel;

import java.util.ArrayList;
import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class ServicesFragment extends Fragment {

    public ServicesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        RecyclerView recyclerView;
        ServiceListAdapter listAdapter;
        List<ServiceListItemModel> modelList;

        recyclerView = view.findViewById(R.id.frgServicesRecyclerVw);

        // TODO: below model assignment is for test purposes
        // retrieve actual data from backend api
        // delete below afterwards
        modelList = new ArrayList<>();
        modelList.add(new ServiceListItemModel("Service name #1", "dflhgdıfhlfhghdlındlndlınhbldnlhdhgjhfjf"));
        modelList.add(new ServiceListItemModel("Service name #2", "hdfhdfhdfhdfhdfhdfh"));
        modelList.add(new ServiceListItemModel("Service name #3", "dfghsoşsoglısgsşldgnşsdgsşdgşsodgsodgmjsgnjsoıgşosdmgşdsgsoşdgşosdgoşsgsdgsdgsgsdgs"));
        modelList.add(new ServiceListItemModel("Service name #4", "sgesegsrherhrehrhrehrhehrehrherherhe"));
        modelList.add(new ServiceListItemModel("Service name #5", "eıhperjhpreegrogpe5pehjrgjergjerghjpergrejgpergjpıjgperıjgıperjgpıerjpgıerjgerjpgerjpgıejrpıgjepırgjeprıogjpeırjgperjgıpejrıgerıgjpegregeg"));
        modelList.add(new ServiceListItemModel("Service name #6", "ergrehgrepıgpreıjfgpıerjgpıerjgıpejrpgjerpgerjgerpg"));

        listAdapter = new ServiceListAdapter(modelList, view.getContext());
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_services, container, false);
    }
}