package com.frontend.tutorcave.model;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class DiscussionAnswerModel {
    private String id;
    private String title;
    private String description;
    private String ownerUsername;
    private byte[] ownerPP;
    private String dateOfCreation;
    private String vote;

    public DiscussionAnswerModel(
            String id,
            String title,
            String description,
            String ownerUsername,
            byte[] ownerPP,
            String dateOfCreation,
            String vote
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ownerUsername = ownerUsername;
        this.ownerPP = ownerPP;
        this.dateOfCreation = dateOfCreation;
        this.vote = vote;
    }

    public DiscussionAnswerModel() {
        // Empty constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public byte[] getOwnerPP() {
        return ownerPP;
    }

    public void setOwnerPP(byte[] ownerPP) {
        this.ownerPP = ownerPP;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }
}