package com.frontend.tutorcave.model;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class AccoladeListItemModel {
    // id - payload
    private String badge;
    private String description;
    // prerequisitePrivilegeId - payload
    private String prerequisitePrivilege;

    public AccoladeListItemModel(String badge, String description, String prerequisitePrivilege) {
        this.badge = badge;
        this.description = description;
        this.prerequisitePrivilege = prerequisitePrivilege;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrerequisitePrivilege() {
        return prerequisitePrivilege;
    }

    public void setPrerequisitePrivilege(String prerequisitePrivilege) {
        this.prerequisitePrivilege = prerequisitePrivilege;
    }
}