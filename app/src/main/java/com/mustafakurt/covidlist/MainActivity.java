package com.mustafakurt.covidlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mustafakurt.covidlist.adapter.RecyclerViewAdapter;
import com.mustafakurt.covidlist.model.CovidModel;
import com.mustafakurt.covidlist.service.CovidAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    //        https://api.covid19api.com/summary
    ArrayList<CovidModel> covidModels;
    private String BASE_URL = "https://api.covid19api.com/";
    Retrofit retrofit;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);


        Gson gson=new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        loadData();
    }
    private void loadData(){
        CovidAPI covidAPI=retrofit.create(CovidAPI.class);

        Call<List<CovidModel>> call= covidAPI.getData();
        call.enqueue(new Callback<List<CovidModel>>() {
            @Override
            public void onResponse(Call<List<CovidModel>> call, Response<List<CovidModel>> response) {
                if (response.isSuccessful()){
                    List<CovidModel> responseList=response.body();
                    covidModels=new ArrayList<>(responseList);

                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerViewAdapter=new RecyclerViewAdapter(covidModels);
                    recyclerView.setAdapter(recyclerViewAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<CovidModel>> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }

}