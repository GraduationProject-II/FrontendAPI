package com.frontend.tutorcave.model;

import android.view.MenuItem;

import androidx.fragment.app.Fragment;

import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class MenuSelectionModel {
    private MenuItem menuItem;
    private int homeId;
    private int discussionId;
    private int findTutorId;
    private int messagesId;
    private List<Fragment> itemList;

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public int getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(int discussionId) {
        this.discussionId = discussionId;
    }

    public int getFindTutorId() {
        return findTutorId;
    }

    public void setFindTutorId(int findTutorId) {
        this.findTutorId = findTutorId;
    }

    public int getMessagesId() {
        return messagesId;
    }

    public void setMessagesId(int messagesId) {
        this.messagesId = messagesId;
    }

    public List<Fragment> getItemList() {
        return itemList;
    }

    public void setItemList(List<Fragment> itemList) {
        this.itemList = itemList;
    }
}