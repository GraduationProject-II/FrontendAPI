package com.frontend.tutorcave.model;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class FeedbackListItemModel {
    private byte[] tutorPP;
    private String tutorUsername;
    private String tutorReputation;
    private String serviceTitle;
    private String serviceDescription;
    private String content;
    private String flag;

    public FeedbackListItemModel(
            byte[] tutorPP,
            String tutorUsername,
            String tutorReputation,
            String serviceTitle,
            String serviceDescription,
            String content,
            String flag
    ) {
        this.tutorPP = tutorPP;
        this.tutorUsername = tutorUsername;
        this.tutorReputation = tutorReputation;
        this.serviceTitle = serviceTitle;
        this.serviceDescription = serviceDescription;
        this.content = content;
        this.flag = flag;
    }

    public byte[] getTutorPP() {
        return tutorPP;
    }

    public void setTutorPP(byte[] tutorPP) {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}