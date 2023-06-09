package com.frontend.tutorcave.model;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class DiscussionListItemModel {
    private String id;
    private String title;
    private String desc;
    private String username;
    private String dateOfCreation;
    private String lastUpdated;
    private String vote;

    public DiscussionListItemModel(
            String id,
            String title,
            String username,
            String dateOfCreation,
            String lastUpdated,
            String vote
    ) {
        this.id = id;
        this.title = title;
        this.username = username;
        this.dateOfCreation = dateOfCreation;
        this.lastUpdated = lastUpdated;
        this.vote = vote;
    }

    public DiscussionListItemModel(
            String id,
            String title,
            String desc,
            String username,
            String dateOfCreation,
            String lastUpdated,
            String vote)
    {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.username = username;
        this.dateOfCreation = dateOfCreation;
        this.lastUpdated = lastUpdated;
        this.vote = vote;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }
}