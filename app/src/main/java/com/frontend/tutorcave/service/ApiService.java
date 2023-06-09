package com.frontend.tutorcave.service;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.frontend.tutorcave.model.DiscussionAnswerModel;
import com.frontend.tutorcave.model.DiscussionListItemModel;
import com.frontend.tutorcave.model.DiscussionWithAnswersModel;
import com.frontend.tutorcave.model.FeedbackListItemModel;
import com.frontend.tutorcave.model.HomeMenuDashboardItemModel;
import com.frontend.tutorcave.model.UserInfoModel;
import com.frontend.tutorcave.util.UrlUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class ApiService {

    private static final String USER_ID = "userId";
    private static final String USERNAME = "username";
    private OkHttpClient client = new OkHttpClient();

    public Map<String, String> listAccolades(String userId) {
        Map<String, String> responseList = new HashMap<>();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.LIST_ACCOLADES).newBuilder();
        urlBuilder.addQueryParameter(USER_ID, userId);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).build();

        try {
            Response response = client.newCall(request).execute();
            JSONArray jsonArray = new JSONArray(response.body().string());

            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String badge = object.getString("badge");
                String desc = object.getString("description");
                responseList.put(badge, desc);
            }
        } catch (IOException | JSONException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return responseList;
    }

    public Map<String, String> listPrivileges(String userId) {
        Map<String, String> responseList = new HashMap<>();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.LIST_PRIVILEGES).newBuilder();
        urlBuilder.addQueryParameter(USER_ID, userId);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).build();

        try {
            Response response = client.newCall(request).execute();
            JSONArray jsonArray = new JSONArray(response.body().string());

            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String name = object.getString("name");
                String desc = object.getString("desc");
                responseList.put(name, desc);
            }
        } catch (IOException | JSONException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return responseList;
    }

    public List<DiscussionListItemModel> listDiscussions(String userId) {
        List<DiscussionListItemModel> responseList = new ArrayList<>();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.LIST_USER_DISCUSSIONS_OWNER).newBuilder();
        urlBuilder.addQueryParameter(USER_ID, userId);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).build();

        try {
            Response response = client.newCall(request).execute();
            JSONArray jsonArray = new JSONArray(response.body().string());

            for (int i=0; i< jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                responseList.add(new DiscussionListItemModel(
                        object.get("id").toString(),
                        object.getString("title"),
                        object.getString(USERNAME),
                        object.get("createdAt").toString(),
                        object.get("lastUpdatedAt").toString(),
                        object.get("vote").toString()
                ));
            }
        } catch (IOException |JSONException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return responseList;
    }

    public DiscussionWithAnswersModel viewDiscussionWithAnswers(String discussionId) {
        DiscussionWithAnswersModel responseModel = new DiscussionWithAnswersModel();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.VIEW_DISCUSSION).newBuilder();
        urlBuilder.addQueryParameter("discussionId", discussionId);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).build();

        try {
            Response response = client.newCall(request).execute();
            JSONObject object = new JSONObject(response.body().string());
            responseModel.setDiscussion(new DiscussionListItemModel(
                    "null",
                    object.getString("title"),
                    object.getString("desc"),
                    object.getString("ownerUsername"),
                    object.get("createdAt").toString(),
                    object.get("lastUpdated").toString(),
                    object.get("vote").toString()
                    ));

            JSONArray answersJSON = object.getJSONArray("answers");
            List<DiscussionAnswerModel> answerList = new ArrayList<>();
            for (int i=0; i< answersJSON.length(); i++) {
                JSONObject itemAnswer = answersJSON.getJSONObject(i);
                DiscussionAnswerModel  model = new DiscussionAnswerModel();
                model.setDescription(itemAnswer.getString("content"));
                model.setVote(itemAnswer.get("vote").toString());
                model.setOwnerUsername(itemAnswer.getString("ownerUsername"));
                answerList.add(model);
            }
            responseModel.setAnswerList(answerList);
        } catch (IOException | JSONException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return responseModel;
    }

    public List<FeedbackListItemModel> listUserFeedbacks(String userId) {
        List<FeedbackListItemModel> responseList = new ArrayList<>();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.LIST_FEEDBACKS_RECEIVED).newBuilder();
        urlBuilder.addQueryParameter(USER_ID, userId);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).build();

        try {
            Response response = client.newCall(request).execute();
            JSONArray jsonArray = new JSONArray(response.body().string());

            for (int i=0; i< jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String id = getUserId(object.getString(USERNAME));
                byte[] userImage = getUserImage(id);

                responseList.add(new FeedbackListItemModel(
                        userImage,
                        object.getString(USERNAME),
                        object.get("reputation").toString(),
                        object.getString("servicePrice"),
                        object.getString("serviceDesc")
                ));
            }
        } catch (JSONException | IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return responseList;
    }

    public UserInfoModel getUserInfo(String userId) {
        UserInfoModel responseItem = new UserInfoModel();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.GET_USER_INFO).newBuilder();
        urlBuilder.addQueryParameter(USER_ID, userId);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).build();

        try {
            Response response = client.newCall(request).execute();
            JSONObject object = new JSONObject(response.body().string());

            responseItem.setUsername(object.getString(USERNAME));
            responseItem.setFullName(object.getString("fullName"));
            responseItem.setAccType(object.getString("accountType"));
            responseItem.setReputation(object.get("reputation").toString());
            responseItem.setImage(getUserImage(userId));
        } catch (JSONException | IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return  responseItem;
    }

    public String getAccoladeCount(String userId) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.GET_ACCOLADE_COUNT).newBuilder();
        urlBuilder.addQueryParameter(USER_ID, userId);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).build();

        String responseItem = "";
        try {
            Response response = client.newCall(request).execute();
            responseItem = response.body().string();
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return responseItem;
    }

    public String getFeedbackCount(String userId) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.GET_FEEDBACK_GIVEN_COUNT).newBuilder();
        urlBuilder.addQueryParameter(USER_ID, userId);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).build();

        String responseItem = "";
        try {
            Response response = client.newCall(request).execute();
            responseItem = response.body().string();
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return responseItem;
    }

    public String getReputation(String username) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.GET_USER_REP).newBuilder();
        urlBuilder.addQueryParameter(USERNAME, username);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).build();

        String responseItem = "";
        try {
            Response response = client.newCall(request).execute();
            responseItem = response.body().string();
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return responseItem;
    }

    public List<HomeMenuDashboardItemModel> listHighRepUsers() {
        List<HomeMenuDashboardItemModel> responseList = new ArrayList<>();
        Request request = new Request.Builder().url(UrlUtil.LIST_USERS_HIGH_REP).build();
        try {
            Response response = client.newCall(request).execute();
            JSONArray jsonArray = new JSONArray(response.body().string());

            for (int i=0; i< jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                byte[] imageData = getUserImage(getUserId(object.getString(USERNAME)));
                responseList.add(new HomeMenuDashboardItemModel(
                        object.getString("fullName"),
                        object.getString(USERNAME),
                        object.get("reputation").toString(),
                        imageData
                ));
            }
        } catch (IOException | JSONException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return responseList;
    }

    public String getUserId(String username) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.GET_USER_ID).newBuilder();
        urlBuilder.addQueryParameter(USERNAME, username);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).build();

        String id = "";
        try {
            Response response = client.newCall(request).execute();
            id = response.body().string();
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return id;
    }

    public Map<String, String> getServiceList(String userId) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.LIST_SERVICES_GIVEN).newBuilder();
        urlBuilder.addQueryParameter(USER_ID, userId);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).build();

        Map<String, String> responseList = new HashMap<>();
        try {
            Response response = client.newCall(request).execute();
            responseList = new Gson().fromJson(
                    response.body().string(),
                    new TypeToken<HashMap<String, String>>() {}.getType()
            );
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return responseList;
    }

    private byte[] getUserImage(String userId) {
        byte[] data = null;

        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.GET_IMAGE).newBuilder();
        urlBuilder.addQueryParameter(USER_ID, userId);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).build();

        try {
            Response response = client.newCall(request).execute();
            data = response.body().bytes();
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return data;
    }
}