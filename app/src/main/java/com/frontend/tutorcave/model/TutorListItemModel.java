package com.frontend.tutorcave.model;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class TutorListItemModel {
    private String fullName;
    private String username;
    private String fieldOfSpecialization;
    private String aboutMe;
    private String reputation; // consider int after backend api con.
    private int profilePicture; // consider type after backend api con.

    public TutorListItemModel(
            String fullName,
            String username,
            String fieldOfSpecialization,
            String aboutMe,
            String reputation,
            int profilePicture
    ) {
        this.fullName = fullName;
        this.username = username;
        this.fieldOfSpecialization = fieldOfSpecialization;
        this.aboutMe = aboutMe;
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

    public String getFieldOfSpecialization() {
        return fieldOfSpecialization;
    }

    public void setFieldOfSpecialization(String fieldOfSpecialization) {
        this.fieldOfSpecialization = fieldOfSpecialization;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public int getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(int profilePicture) {
        this.profilePicture = profilePicture;
    }
}