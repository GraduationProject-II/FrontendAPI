package com.frontend.tutorcave.model;


//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class MessageItemModel {
    private int profilePicture;
    private String name;
    private String content;

    public MessageItemModel(int profilePicture, String name, String content) {
        this.profilePicture = profilePicture;
        this.name = name;
        this.content = content;
    }

    public int getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(int profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}