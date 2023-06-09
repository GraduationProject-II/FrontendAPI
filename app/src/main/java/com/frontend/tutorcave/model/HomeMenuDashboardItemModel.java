package com.frontend.tutorcave.model;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class HomeMenuDashboardItemModel {
    private String fullName;
    private String username;
    // may change to int/Integer after backend establishment
    private String reputation;
    // may change from int after backend establishment
    private byte[] profilePicture;

    public HomeMenuDashboardItemModel(String fullName, String username, String reputation, byte[] profilePicture) {
        this.fullName = fullName;
        this.username = username;
        this.reputation = reputation;
        this.profilePicture = profilePicture;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }
}