package com.mustafakurt.xml_design_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mustafakurt.xml_design_example.adapter.Adapter2;
import com.mustafakurt.xml_design_example.adapter.Adapter3;
import com.mustafakurt.xml_design_example.adapter.RecyclerViewAdapter;
import com.mustafakurt.xml_design_example.model.CountryModel;
import com.mustafakurt.xml_design_example.model.CovidModel;
import com.mustafakurt.xml_design_example.model.GlobalModel;
import com.mustafakurt.xml_design_example.service.CovidAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<CovidModel> covidModels;
    ArrayList<CountryModel> countryModels;
    ArrayList<GlobalModel> globalModels;
    private String BASE_URL = "https://api.covid19api.com/";
    Retrofit retrofit;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;

    RecyclerView recyclerView2;
    Adapter2 recyclerViewAdapter2;
    Adapter3 recyclerViewAdapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void ulkeGoster(View view) {
        ulkeCek();
    }
    public void veriGoster(View view) {
        ulkeVeriCek();
//        globalVeriCek();
    }

    private void loadData() {
        CovidAPI covidAPI = retrofit.create(CovidAPI.class);

        Call<List<CovidModel>> call = covidAPI.getData();
        call.enqueue(new Callback<List<CovidModel>>() {
            @Override
            public void onResponse(Call<List<CovidModel>> call, Response<List<CovidModel>> response) {
                if (response.isSuccessful()) {
                    List<CovidModel> responseList = response.body();
                    covidModels = new ArrayList<>(responseList);

                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerViewAdapter = new RecyclerViewAdapter(covidModels);
                    recyclerView.setAdapter(recyclerViewAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<CovidModel>> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }

    private void loadData2() {
        CovidAPI covidAPI = retrofit.create(CovidAPI.class);

        Call<List<CountryModel>> call = covidAPI.countriesgetData();
        call.enqueue(new Callback<List<CountryModel>>() {
            @Override
            public void onResponse(Call<List<CountryModel>> call, Response<List<CountryModel>> response) {
                if (response.isSuccessful()) {
                    List<CountryModel> responseList = response.body();
                    countryModels = new ArrayList<>(responseList);

                    recyclerView2.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerViewAdapter2 = new Adapter2(countryModels);
                    recyclerView2.setAdapter(recyclerViewAdapter2);

                }
            }

            @Override
            public void onFailure(Call<List<CountryModel>> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }

    //ülkeleri tıklandıkca getirecek data
    private void loadData3(){
        CovidAPI covidAPI=retrofit.create(CovidAPI.class);

        Call<List<GlobalModel>> call= covidAPI.globalgetData();
        call.enqueue(new Callback<List<GlobalModel>>() {
            @Override
            public void onResponse(Call<List<GlobalModel>> call, Response<List<GlobalModel>> response) {
                if (response.isSuccessful()){
                    List<GlobalModel> responseList=response.body();
                    globalModels=new ArrayList<>(responseList);

                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerViewAdapter3=new Adapter3(globalModels);
                    recyclerView.setAdapter(recyclerViewAdapter3);

                }
            }

            @Override
            public void onFailure(Call<List<GlobalModel>> call, Throwable t) {
                t.printStackTrace();

            }
        });

    }



    private void ulkeCek(){
        recyclerView2 = findViewById(R.id.recyclerView1);
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        loadData2();
    }
    private void ulkeVeriCek(){
        recyclerView = findViewById(R.id.recyclerView2);
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        loadData();
    }
    private void globalVeriCek(){
        recyclerView=findViewById(R.id.recyclerView2);
        Gson gson=new GsonBuilder().setLenient().create();
        retrofit= new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        loadData3();

    }

}