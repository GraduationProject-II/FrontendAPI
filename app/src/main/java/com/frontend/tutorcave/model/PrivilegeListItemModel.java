package com.frontend.tutorcave.model;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.

import java.util.Locale;

/** @author Samet Vural Üstün */

public class PrivilegeListItemModel {
    private String name;
    private String desc;
    private STATUS status;

    public PrivilegeListItemModel(String name, String desc, STATUS status) {
        this.name = name;
        this.desc = desc;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status.toString().toLowerCase(Locale.ROOT);
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public enum STATUS {
        LOCKED,
        UNLOCKED
    }
}