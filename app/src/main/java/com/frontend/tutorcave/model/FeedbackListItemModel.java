package com.frontend.tutorcave.model;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class FeedbackListItemModel {
    // test purposes, change to ImageView afterwards
    private int tutorPP;
    private String tutorUsername;
    // might change type with int after backend establishment
    private String tutorReputation;
    private String serviceTitle;
    private String serviceDescription;

    public FeedbackListItemModel(
            int tutorPP,
            String tutorUsername,
            String tutorReputation,
            String serviceTitle,
            String serviceDescription
    ) {
        this.tutorPP = tutorPP;
        this.tutorUsername = tutorUsername;
        this.tutorReputation = tutorReputation;
        this.serviceTitle = serviceTitle;
        this.serviceDescription = serviceDescription;
    }

    public int getTutorPP() {
        return tutorPP;
    }

    public void setTutorPP(int tutorPP) {
        this.tutorPP = tutorPP;
    }

    public String getTutorUsername() {
        return tutorUsername;
    }

    public void setTutorUsername(String tutorUsername) {
        this.tutorUsername = tutorUsername;
    }

    public String getTutorReputation() {
        return tutorReputation;
    }

    public void setTutorReputation(String tutorReputation) {
        this.tutorReputation = tutorReputation;
    }

    public String getServiceTitle() {
        return serviceTitle;
    }

    public void setServiceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }
}