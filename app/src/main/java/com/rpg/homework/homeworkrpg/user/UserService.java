package com.rpg.homework.homeworkrpg.user;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by scott on 10/20/2018.
 */

public class UserService {

    PostUserService userApi;

    UserService() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://us-central1-homework-rpg.cloudfunctions.net/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        userApi = retrofit.create(PostUserService.class);
    }

    interface PostUserService {
        @POST("createUser")
        Call<UserObject> createUser(@Body UserObject user);
    }

    public void createUser(String name, String description) {
        userApi.createUser(new UserObject(name, description));
    }


}