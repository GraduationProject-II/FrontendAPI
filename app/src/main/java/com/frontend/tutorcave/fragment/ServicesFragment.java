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
import com.frontend.tutorcave.service.ApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class ServicesFragment extends Fragment {

    private ApiService apiService = new ApiService();

    public ServicesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        RecyclerView recyclerView;
        ServiceListAdapter listAdapter;

        recyclerView = view.findViewById(R.id.frgServicesRecyclerVw);


        Map<String, String> services = apiService.getServiceList("104");
        List<ServiceListItemModel> modelList = new ArrayList<>(validateList(services));
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

    private List<ServiceListItemModel> validateList(Map<String, String> rawList) {
        List<ServiceListItemModel> returnList = new ArrayList<>();
        rawList.forEach((k, v) -> {
            returnList.add(new ServiceListItemModel(k, v));
        });
        return returnList;
    }
}