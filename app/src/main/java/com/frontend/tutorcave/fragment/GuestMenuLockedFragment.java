package com.frontend.tutorcave.fragment;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.adapter.GuestHomeListAdapter;
import com.frontend.tutorcave.model.HomeMenuDashboardItemModel;
import com.frontend.tutorcave.service.ApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class GuestMenuLockedFragment extends Fragment {

    private final ApiService apiService = new ApiService();
    private Drawable windowDrawable;

    public GuestMenuLockedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView;
        GuestHomeListAdapter listAdapter;

        recyclerView = view.findViewById(R.id.frgGstLckRecyclerVw);

        windowDrawable = requireActivity().getDrawable(R.drawable.round_menu_home);
        Window window = requireActivity().getWindow();
        window.setBackgroundDrawable(windowDrawable);

        if (buildIsAtLeastS()) {
            window.addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
            setupWindowBlurListener();
        }
        else updateWindowForBlurs(false);
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        List<HomeMenuDashboardItemModel> dashboardItemModels = new ArrayList<>(apiService.listHighRepUsers());
        listAdapter = new GuestHomeListAdapter(dashboardItemModels, view.getContext());
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_guest_menu_locked, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.S)
    private void setupWindowBlurListener() {
        Consumer<Boolean> windowBlurEnabledListener = this::updateWindowForBlurs;
        requireActivity().getWindow().getDecorView()
                .addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                    @Override
                    public void onViewAttachedToWindow(@NonNull View view) {
                        requireActivity().getWindowManager()
                                .addCrossWindowBlurEnabledListener(windowBlurEnabledListener);
                    }

                    @Override
                    public void onViewDetachedFromWindow(@NonNull View view) {
                        requireActivity().getWindowManager()
                                .removeCrossWindowBlurEnabledListener(windowBlurEnabledListener);
                    }
                });
    }

    private void updateWindowForBlurs(boolean blursEnabled) {
        windowDrawable.setAlpha(blursEnabled && 80 > 0 ?
                170 : 255);
        requireActivity().getWindow().setDimAmount(blursEnabled && 20 > 0 ?
                0.1f : 0.4f);

        if (buildIsAtLeastS()) {
            requireActivity().getWindow().setBackgroundBlurRadius(80);
            requireActivity().getWindow().getAttributes().setBlurBehindRadius(20);
            requireActivity().getWindow().setAttributes(requireActivity().getWindow().getAttributes());
        }
    }

    private static boolean buildIsAtLeastS() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.S;
    }
}