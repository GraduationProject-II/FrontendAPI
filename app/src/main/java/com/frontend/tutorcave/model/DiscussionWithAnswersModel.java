package com.frontend.tutorcave.model;

import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class DiscussionWithAnswersModel {
    private DiscussionListItemModel discussion;
    private List<DiscussionAnswerModel> answerList;

    public DiscussionWithAnswersModel() {
        // Empty public constructor
    }

    public DiscussionListItemModel getDiscussion() {
        return discussion;
    }

    public void setDiscussion(DiscussionListItemModel discussion) {
        this.discussion = discussion;
    }

    public List<DiscussionAnswerModel> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<DiscussionAnswerModel> answerList) {
        this.answerList = answerList;
    }
}