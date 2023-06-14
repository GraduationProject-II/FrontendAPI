package com.frontend.tutorcave.service;

import com.frontend.tutorcave.model.DiscussionAnswerModel;
import com.frontend.tutorcave.model.DiscussionListItemModel;
import com.frontend.tutorcave.model.DiscussionWithAnswersModel;
import com.frontend.tutorcave.model.FeedbackListItemModel;
import com.frontend.tutorcave.model.HomeMenuDashboardItemModel;
import com.frontend.tutorcave.model.LoginModel;
import com.frontend.tutorcave.model.NewDiscussionPayload;
import com.frontend.tutorcave.model.RegisterModel;
import com.frontend.tutorcave.model.TutorListItemModel;
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
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class ApiService {

    private static final String USER_ID = "userId";
    private static final String USERNAME = "username";
    private static final String OWNER_USERNAME = "ownerUsername";
    private static final String TITLE = "title";
    private static final String REPUTATION = "reputation";
    private static final String CREATED_AT = "createdAt";
    private static final String LAST_UPDATED = "lastUpdatedAt";
    private OkHttpClient client = new OkHttpClient();

    public String login(LoginModel payload) {
        String jsonPayload = "{\r\n" +
                " \"username\" : \"" + payload.getUsername() + "\",\r\n" +
                "\"password\" : \"" + payload.getPassword() + "\"\r\n" +
                "}";

        MediaType mJSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(mJSON, jsonPayload);
        Request request = new Request.Builder().url(UrlUtil.LOGIN).post(requestBody).build();

        String returnedId = "";
        try {
            Response response = client.newCall(request).execute();
            JSONObject object = new JSONObject(response.body().string());
            returnedId = object.get(USER_ID).toString();
        } catch (IOException | JSONException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return returnedId;
    }

    public void register(RegisterModel payload) {
        String fullName = payload.getFirstName() + " " + payload.getLastName();
        String jsonPayload = "{\r\n" +
                " \"username\" : \"" + payload.getUsername() + "\",\r\n" +
                " \"password\" : \"" + payload.getPassword() + "\",\r\n" +
                " \"email\" : \"" + payload.getEmail() + "\",\r\n" +
                " \"fullName\" : \"" + fullName + "\"\r\n" +
                "}";

        MediaType mJSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(mJSON, jsonPayload);
        Request request = new Request.Builder().url(UrlUtil.REGISTER).post(requestBody).build();

        try {
            client.newCall(request).execute();
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

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
                        object.getString(TITLE),
                        object.getString(USERNAME),
                        validateDate(object.get(CREATED_AT).toString()),
                        validateDate(object.get(LAST_UPDATED).toString()),
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
                    object.get("id").toString(),
                    object.getString(TITLE),
                    object.getString("desc"),
                    object.getString(OWNER_USERNAME),
                    validateDate(object.get(CREATED_AT).toString()),
                    validateDate(object.get("lastUpdated").toString()),
                    object.get("vote").toString()
                    ));

            JSONArray answersJSON = object.getJSONArray("answers");
            List<DiscussionAnswerModel> answerList = new ArrayList<>();
            for (int i=0; i< answersJSON.length(); i++) {
                JSONObject itemAnswer = answersJSON.getJSONObject(i);
                DiscussionAnswerModel  model = new DiscussionAnswerModel();
                String id = getUserId(itemAnswer.getString(OWNER_USERNAME));
                model.setId(itemAnswer.get("answerId").toString());
                model.setOwnerPP(getUserImage(id));
                model.setDescription(itemAnswer.getString("content"));
                model.setVote(itemAnswer.get("vote").toString());
                model.setOwnerUsername(itemAnswer.getString(OWNER_USERNAME));
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
                        object.get(REPUTATION).toString(),
                        object.getString("servicePrice"),
                        object.getString("serviceDesc"),
                        object.getString("feedbackContent"),
                        object.getString("feedbackFlag")
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
            responseItem.setReputation(object.get(REPUTATION).toString());
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
                        object.get(REPUTATION).toString(),
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

    public String getAllDiscCount() {
        Request request = new Request.Builder().url(UrlUtil.GET_ALL_DISCUSSION_COUNT).build();
        String responseItem = "";
        try {
            Response response = client.newCall(request).execute();
            responseItem = response.body().string();
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return responseItem;
    }

    public String getDiscussionsInvolved(String userId) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.GET_DISCUSSIONS_INVOLVED_COUNT).newBuilder();
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

    public String getVotesReceived(String userId) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.GET_UP_VOTES_RECEIVED).newBuilder();
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

    public List<DiscussionListItemModel> searchDiscussion(String keyword) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.SEARCH_DISCUSSION).newBuilder();
        urlBuilder.addQueryParameter("keyword", keyword);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).build();
        List<DiscussionListItemModel> responseList = new ArrayList<>();

        try {
            Response response = client.newCall(request).execute();
            JSONArray jsonArray = new JSONArray(response.body().string());

            for (int i=0; i< jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                responseList.add(new DiscussionListItemModel(
                        object.get("id").toString(),
                        object.getString(TITLE),
                        object.getString(USERNAME),
                        validateDate(object.get(CREATED_AT).toString()),
                        validateDate(object.get(LAST_UPDATED).toString()),
                        object.get("vote").toString()
                ));
            }
        } catch (IOException | JSONException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return responseList;
    }

    public List<TutorListItemModel> searchTutor(String keyword) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.SEARCH_TUTOR).newBuilder();
        urlBuilder.addQueryParameter("keyword", keyword);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).build();

        List<TutorListItemModel> responseList = new ArrayList<>();
        try {
            Response response = client.newCall(request).execute();
            JSONArray jsonArray = new JSONArray(response.body().string());

            for (int i=0; i< jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                responseList.add(validateTutorInfo(object));
            }
        } catch (IOException | JSONException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return responseList;
    }

    public List<TutorListItemModel> listTutorWithHighRep() {
        Request request = new Request.Builder().url(UrlUtil.LIST_TUTORS_HIGH_REP).build();
        List<TutorListItemModel> responseList = new ArrayList<>();

        try {
            Response response = client.newCall(request).execute();
            JSONArray jsonArray = new JSONArray(response.body().string());

            for (int i=0; i< jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                responseList.add(validateTutorInfo(object));
            }
        } catch (IOException | JSONException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return responseList;
    }

    public List<TutorListItemModel> listTutorTrending() {
        Request request = new Request.Builder().url(UrlUtil.LIST_TUTORS_TRENDING).build();
        List<TutorListItemModel> responseList = new ArrayList<>();

        try {
            Response response = client.newCall(request).execute();
            JSONArray jsonArray = new JSONArray(response.body().string());
            for (int i=0; i< jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                responseList.add(validateTutorInfo(object));
            }
        } catch (IOException | JSONException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return responseList;
    }

    public List<TutorListItemModel> listTutorNewcomer() {
        Request request = new Request.Builder().url(UrlUtil.LIST_TUTOR_NEWCOMER).build();
        List<TutorListItemModel> responseList = new ArrayList<>();
        try {
            Response response = client.newCall(request).execute();
            JSONArray jsonArray = new JSONArray(response.body().string());
            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                responseList.add(validateTutorInfo(object));
            }
        } catch (IOException | JSONException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return responseList;
    }

    public void saveImage(String userId, byte[] imageData, String fileName) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.SAVE_IMAGE).newBuilder();
        urlBuilder.addQueryParameter(USER_ID, userId);
        String url = urlBuilder.build().toString();

        RequestBody requestBody = new MultipartBody.Builder()
                .addFormDataPart(
                        "file",
                        fileName,
                        RequestBody.create(
                                MediaType.parse("image/jpeg"),
                                imageData))
                .setType(MultipartBody.FORM)
                .build();
        Request request = new Request.Builder().url(url).post(requestBody).build();

        try {
            client.newCall(request).execute();
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    public byte[] getUserImage(String userId) {
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

    public int applyTutor(String userId) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.APPLY_TUTOR).newBuilder();
        urlBuilder.addQueryParameter(USER_ID, userId);
        String url = urlBuilder.build().toString();
        RequestBody requestBody = RequestBody.create(null, new byte[0]);
        Request request = new Request.Builder().url(url).post(requestBody).build();

        int returnCode = 1;
        try {
            Response response = client.newCall(request).execute();
            String responseStatus = response.body().string();
            if (!isStatus(responseStatus))
                returnCode = 0;
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return returnCode;
    }

    public String voteUpAnswer(String answerId) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.VOTE_UP_ANSWER).newBuilder();
        urlBuilder.addQueryParameter("answerId", answerId);
        String url = urlBuilder.build().toString();
        RequestBody requestBody = RequestBody.create(null, new byte[0]);
        Request request = new Request.Builder().url(url).put(requestBody).build();

        String newVote = "";
        try {
            Response response = client.newCall(request).execute();
            newVote = response.body().string();
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return newVote;
    }

    public String voteUpDiscussion(String discussionId) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.VOTE_UP).newBuilder();
        urlBuilder.addQueryParameter("discussionId", discussionId);
        String url = urlBuilder.build().toString();
        RequestBody requestBody = RequestBody.create(null, new byte[0]);
        Request request = new Request.Builder().url(url).put(requestBody).build();

        String newVote = "";
        try {
            Response response = client.newCall(request).execute();
            newVote = retrieveVote(response.body().string());
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return newVote;
    }

    public int newDiscussion(String userId, NewDiscussionPayload payload) {

        String jsonPayload = "{\r\n" +
                " \"title\" : \"" + payload.getDiscussionTitle() + "\",\r\n" +
                " \"description\" : \"" + payload.getDiscussionDescription() + "\"\r\n" +
                "}";
        MediaType mJSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(mJSON, jsonPayload);

        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.NEW_DISCUSSION).newBuilder();
        urlBuilder.addQueryParameter(USER_ID, userId);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).post(requestBody).build();

        int status = 0;
        try {
            client.newCall(request).execute();
            status = 1;
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return status;
    }

    public int newAnswer(String userId, String discussionId, String content) {
        String jsonPayload = "{\r\n" +
                " \"content\": \"" + content + "\"\r\n" +
                "}";
        MediaType mJSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(mJSON, jsonPayload);

        HttpUrl.Builder urlBuilder = HttpUrl.parse(UrlUtil.NEW_ANSWER).newBuilder();
        urlBuilder.addQueryParameter(USER_ID, userId);
        urlBuilder.addQueryParameter("discussionId", discussionId);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).post(requestBody).build();

        int status = 0;
        try {
            client.newCall(request).execute();
            status = 1;
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return status;
    }

    private String retrieveVote(String body) {
        int bIndex = body.indexOf(">") + 2;
        return body.substring(bIndex);
    }

    private boolean isStatus(String param) {
        boolean result = false;
        if (!param.contains("failed"))
            result = true;
        return result;
    }

    private String validateDate(String date) {
        int endIndex = date.indexOf("T", 0);
        return date.substring(0, endIndex);
    }

    private TutorListItemModel validateTutorInfo(JSONObject object) throws JSONException{
        TutorListItemModel newItem = new TutorListItemModel();
        String userId = getUserId(object.getString(USERNAME));
        byte[] imageData = getUserImage(userId);
        newItem.setProfilePicture(imageData);
        newItem.setUserId(userId);
        newItem.setUsername(object.getString(USERNAME));
        newItem.setAccType(object.getString("accountType"));
        newItem.setFullName(object.getString("fullName"));
        newItem.setReputation(object.getString(REPUTATION));
        return newItem;
    }
}