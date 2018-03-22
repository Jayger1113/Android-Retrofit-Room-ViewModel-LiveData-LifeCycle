package com.android_retrofit_room_viewmodel_livedata_lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android_retrofit_room_viewmodel_livedata_lifecycle.retrofit.RetrofitUtil;
import com.android_retrofit_room_viewmodel_livedata_lifecycle.retrofit.pojo.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<List<Repo>> {


    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView mRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRetrofit = (TextView) findViewById(R.id.retrofit_demo);
        RetrofitUtil.getGitHubInfo(this);
    }

    @Override
    public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
        String info = "";
        if(response != null && response.body() != null){
            for(Repo repo:response.body()){
                String id = String.valueOf(repo.getId());
                String name = String.valueOf(repo.getName());
                Log.v(TAG,"id = " + id);
                Log.v(TAG,"name = " + name);
                info += "id = " + id + "\n" + "name = " + name + "\n";
            }
        }
        mRetrofit.setText(info);
    }

    @Override
    public void onFailure(Call<List<Repo>> call, Throwable t) {
    }
}
