package com.frontend.tutorcave.util;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public final class UrlUtil {

    private UrlUtil() {
        // no instance for utils
    }

    private static final String URL = "http://10.0.2.2:8080/tutorcave";

    // GET
    public static final String GET_USER_ID = URL + "/get/user";
    public static final String LIST_USERS_HIGH_REP = URL + "/list/users_all";
    public static final String GET_USER_REP = URL + "/user/list/reputation";
    public static final String LIST_USER_FEEDBACKS = URL + "/user/list/feedbacks?userId=";
    public static final String GET_FEEDBACK_GIVEN_COUNT = URL + "/user/get/feedback";
    public static final String LIST_ACCOLADES = URL + "/user/list/accolade";
    public static final String GET_UP_VOTES_RECEIVED = URL + "/user/get/votes_received";
    public static final String LIST_TUTORS_HIGH_REP = URL + "/list/tutor/by_reputation";
    public static final String LIST_TUTORS_TRENDING = URL + "/list/tutor/trending";
    public static final String LIST_TUTOR_NEWCOMER = URL + "/list/tutor/newcomer";
    public static final String SEARCH_TUTOR = URL + "/search/tutor";
    public static final String GET_IMAGE = URL + "/user/image/get";
    public static final String GET_USER_INFO = URL + "/user/get/info";
    public static final String GET_ACCOLADE_COUNT = URL + "/user/get/accolade";
    public static final String LIST_FEEDBACKS_RECEIVED = URL + "/user/list/feedback/received";
    public static final String LIST_SERVICES_GIVEN = URL + "/user/list/services";
    public static final String LIST_PRIVILEGES = URL + "/user/list/privilege";
    public static final String GET_DISCUSSIONS_INVOLVED_COUNT = URL + "/get/discussion/involved";
    public static final String SEARCH_DISCUSSION = URL + "/discussion/search";
    public static final String GET_ALL_DISCUSSION_COUNT = URL + "/get/discussion/all";
    public static final String LIST_USER_DISCUSSIONS_OWNER = URL + "/user/list/discussion";
    public static final String VIEW_DISCUSSION = URL + "/discussion/view";
    public static final String LIST_DISCUSSIONS_HIGH_VOTE = URL + "/list/discussion";

    // POST
    public static final String APPLY_TUTOR = URL + "/user/apply";
    public static final String NEW_DISCUSSION = URL + "/discussion/save";
    public static final String NEW_ANSWER = URL + "/discussion/answer";
    public static final String LOGIN = URL + "/login";
    public static final String REGISTER = URL + "/register";
    public static final String SAVE_IMAGE = URL + "/user/image/save";
    public static final String GIVE_FEEDBACK = URL + "/user/feedback/new?userId=";
    public static final String GIVE_FEEDBACK_2 = "&serviceId=";
    public static final String TEST_SET_RESET_TOKEN = URL + "/test/set_token";

    // PUT
    public static final String VOTE_UP_ANSWER = URL + "/answer/vote/up";
    public static final String VOTE_DOWN_ANSWER = URL + "/answer/vote/down";
    public static final String DELETE_DISCUSSION = URL + "/discussion/delete?discussionId=";
    public static final String DELETE_DISCUSSION_2 = "&userId=";
    public static final String VOTE_UP = URL + "/discussion/vote/up";
    public static final String VOTE_DOWN = URL + "/discussion/vote/down?discussionId=";
    public static final String RESET_PASSWORD = URL + "/password/reset";
    public static final String EDIT_IMAGE = URL + "/user/edit/pp?userId=";
}