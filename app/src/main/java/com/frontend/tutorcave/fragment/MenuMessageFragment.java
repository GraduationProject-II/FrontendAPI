package com.frontend.tutorcave.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.activity.UserMenuActivity;
import com.frontend.tutorcave.adapter.MessageAdapter;
import com.frontend.tutorcave.model.MessageItemModel;

import java.util.ArrayList;
import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class MenuMessageFragment extends Fragment {

    private static final int PP_ITEM_1 = R.drawable.test_profile_pic_1;
    private static final int PP_ITEM_2 = R.drawable.test_profile_pic_2;
    private static final int PP_ITEM_3 = R.drawable.test_profile_pic_3;
    private static final int PP_ITEM_4 = R.drawable.test_profile_pic_4;
    private static final String TEST_NAME = "Test name #";

    private List<MessageItemModel> modelList;
    private String userId;

    public MenuMessageFragment() {
        // Required empty public constructor
    }

    public MenuMessageFragment(String userId) {
        this.userId = userId;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        AppCompatImageView btnBackspace;
        RecyclerView recyclerView;
        MessageAdapter listAdapter;

        recyclerView = view.findViewById(R.id.frgMsgRecyclerVw);
        btnBackspace = view.findViewById(R.id.frgMsgBackspace);

        modelList = new ArrayList<>();
        assignModel(PP_ITEM_1, TEST_NAME+1, "slhgsıdghsldghslıghselghseılgselgneşgweohgşwdvlwwoşrvro");
        assignModel(PP_ITEM_2, TEST_NAME+2, "ıreghıdghndflnrtbvldıkbvdbvdbdbdr");
        assignModel(PP_ITEM_3, TEST_NAME+3, "fjılshfloıshglsşglırgshşlıdflıvırhsırgsgrsgsrg");
        assignModel(PP_ITEM_4, TEST_NAME+4, "pogjepbjılkrvnervbloırşhbrhbslbıbsbrlonrlnibırhjlvbkrnvilrılgehbrnelişvrıırşlodvsldrnvılnvb");
        assignModel(PP_ITEM_1, TEST_NAME+5, "ıvjherıpjvrmvşeorvıodsnvlşkdrmnbdnrbrinseibnmerşe");
        assignModel(PP_ITEM_2, TEST_NAME+6, "oıjvbpoejbrbebrpbeprb");
        assignModel(PP_ITEM_3, TEST_NAME+7, "kwerovwjovkjrıvgerklnvşlrvghebrpşıvnreınvberıoeınberibnerbnrberbre");
        assignModel(PP_ITEM_4, TEST_NAME+8, "nvıvnırnvpervbşltdsbtılhgtıonlkbnştflnfbtb");
        assignModel(PP_ITEM_1, TEST_NAME+9, "prvjeıovılsr");
        assignModel(PP_ITEM_2, TEST_NAME+10, "prjhvıslrvnlnvşrsarnlnvernbebtbhntrrtrtjrtjretjrt");
        assignModel(PP_ITEM_3, TEST_NAME+11, "ejpwfjıcmnlşrvnevanvrreişvgırngvlrenişlkrnlernblernberb");

        listAdapter = new MessageAdapter(modelList, view.getContext(), userId);
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

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
        return inflater.inflate(R.layout.fragment_menu_message, container, false);
    }

    private void assignModel(int ppId, String name, String msg) {
        modelList.add(new MessageItemModel(ppId, name, msg));
    }
}