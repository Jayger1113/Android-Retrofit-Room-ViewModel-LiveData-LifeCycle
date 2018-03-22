package com.android_retrofit_room_viewmodel_livedata_lifecycle.retrofit.service;


import com.android_retrofit_room_viewmodel_livedata_lifecycle.retrofit.pojo.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}