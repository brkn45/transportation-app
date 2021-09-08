package com.example.singup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeopleList extends AppCompatActivity {
    private ListView peopleList;
    private PersonAdapter personAdapter;
    private ArrayList<User> user;
    private Retrofit client;
    private String driverId;
    private void init(){
        User tmp = new User("ahmet","beko336@gmail","car123","kasaba","passenger","male");

        user.add(tmp);
        personAdapter = new PersonAdapter(this,user);
        peopleList.setAdapter(personAdapter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_list);
        //data    = (Data) getIntent().getSerializableExtra("veri");
        driverId = (String) getIntent().getStringExtra("driverId");
        peopleList = (ListView) findViewById(R.id.PeopleList);
        user = new ArrayList<User>();


        try{
            client = new Retrofit.Builder().baseUrl("https://transportation-backen.herokuapp.com").addConverterFactory(GsonConverterFactory.create()).build();
            GetDataService proxy = client.create(GetDataService.class);
            DriverId driver = new DriverId(driverId,"gereksiz");

            proxy.requestAllPerson(driver).enqueue(new Callback<ArrayList<User>>() {
                @Override
                public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                    Toast.makeText(PeopleList.this,"Added",Toast.LENGTH_LONG).show();
                    //System.out.println("response: " + response.message().toString() );
                    System.out.println(response.body());
                    user.addAll((ArrayList<User>) response.body()) ;
                    init();


                }

                @Override
                public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                    Toast.makeText(PeopleList.this, "Wrong",Toast.LENGTH_LONG).show();
                    Log.e("err",t.getMessage());
                }
            });
        }
        catch (Error error){
            System.out.println(error.getMessage().toString());
        }
    }

}