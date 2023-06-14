package com.frontend.tutorcave.model;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class NewDiscussionPayload {
    private String discussionTitle;
    private String discussionDescription;

    public NewDiscussionPayload() {
        // Empty constructor
    }

    public String getDiscussionTitle() {
        return discussionTitle;
    }

    public void setDiscussionTitle(String discussionTitle) {
        this.discussionTitle = discussionTitle;
    }

    public String getDiscussionDescription() {
        return discussionDescription;
    }

    public void setDiscussionDescription(String discussionDescription) {
        this.discussionDescription = discussionDescription;
    }
}