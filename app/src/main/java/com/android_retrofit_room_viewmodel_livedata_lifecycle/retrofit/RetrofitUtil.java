package com.android_retrofit_room_viewmodel_livedata_lifecycle.retrofit;

import android.util.Log;

import com.android_retrofit_room_viewmodel_livedata_lifecycle.retrofit.pojo.Repo;
import com.android_retrofit_room_viewmodel_livedata_lifecycle.retrofit.service.GitHubService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitUtil {

    private static final String TAG = RetrofitUtil.class.getSimpleName();

    public static void getGitHubInfo(Callback<List<Repo>> callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubService service = retrofit.create(GitHubService.class);
        Call<List<Repo>> repos = service.listRepos("garyckhsu");
        repos.enqueue(callback);
    }


}
