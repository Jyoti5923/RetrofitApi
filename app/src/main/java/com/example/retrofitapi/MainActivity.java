package com.example.retrofitapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<Hero> arrayList;
DataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

recyclerView= findViewById(R.id.recycler);
recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
recyclerView.setHasFixedSize(true);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Hero>> call = api.getHeros();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
//                List<Hero> heroes = response.body();
//                String[] heroNames = new String[heroes.size()];
//                for (int i = 0; i < heroes.size(); i++) {
//                    heroNames[i] = heroes.get(i).getName();
//                }
                arrayList = new ArrayList<>(response.body());
                dataAdapter = new DataAdapter(MainActivity.this,arrayList);
                recyclerView.setAdapter(dataAdapter);
            }
            @Override
            public void onFailure(Call<List <Hero>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });
    }
}