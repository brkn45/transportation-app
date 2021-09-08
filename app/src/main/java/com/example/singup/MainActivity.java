package com.example.singup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private String name,email,password;
    private String address, personType,gender;
    private EditText tName, tMail, tPassword ,tAddress;
    RadioGroup radioGroup, radioTypePerson;
    Data data;
    //SQLiteDatabase newMember;
    private Retrofit client;
    private File file = new File("person.txt");
    int age;
    Intent comeIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            tName           = (EditText) findViewById(R.id.editTextName);
            tMail           = (EditText) findViewById(R.id.editTextMail);
            tPassword       = (EditText) findViewById(R.id.editTextPass);
            tAddress        = (EditText) findViewById(R.id.editTextAddress);
            //tAge          = (EditText) findViewById(R.id.editTextAge);
            radioGroup      = (RadioGroup) findViewById(R.id.radioGroup);
            radioTypePerson = (RadioGroup) findViewById(R.id.radioGroupType);
            //data = (Data) getIntent().getSerializableExtra("veri");


        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    /*public void dataBase(Context context){
        newMember = openOrCreateDatabase("Service",Context.MODE_PRIVATE,null);
    }*/
    public void save(View view){
        name       = tName.getText().toString();
        email      = tMail.getText().toString();
        password   = tPassword.getText().toString();
        address    = tAddress.getText().toString();
        //tmpAge    = tAge.getText().toString();

        int selectedId = radioGroup.getCheckedRadioButtonId();
        int radioTypeNumber = radioTypePerson.getCheckedRadioButtonId();
        System.out.println("arraylist ");

        if(!name.isEmpty() && !password.isEmpty() && !email.isEmpty() && !address.isEmpty()){

            if(selectedId==-1 || radioTypeNumber == -1){
                System.out.println("Empty text input area Gender not selected");
            }
            else{
                RadioButton genderRadioButton = (RadioButton) findViewById(selectedId);
                RadioButton personRadioButton = (RadioButton) findViewById(radioTypeNumber);
                gender = genderRadioButton.getText().toString();
                personType = personRadioButton.getText().toString();
                if(personType.equals("Driver")){
                    //add  Driver
                    //database.execSQL("INSERT INTO Users (id,username,password, counrty,type,gender,serviceId) VALUES ()");

                    personType = "driver";
                    ClientPostRequest();
                    System.out.println("Veri gitti");
                }
                else {
                    //add Passenger
                    ///database.execSQL("INSERT INTO Users (id,username,password, counrty,type,gender,serviceId)");

                    personType = "passenger";
                    ClientPostRequest();
                    System.out.println("Passenger Veri gitti");
                }
                Intent intent = new Intent(MainActivity.this,FirstPage.class);
                finish();
                startActivity(intent);

            }



        }
        else{
            System.out.println("Empty text input area");
        }

    }
    private void ClientPostRequest(){
        try{
            client = new Retrofit.Builder().baseUrl("https://transportation-backen.herokuapp.com").addConverterFactory(GsonConverterFactory.create()).build();
            GetDataService proxy = client.create(GetDataService.class);

            User us = new User(name,email,password,address,personType,gender);

            proxy.addUser(us).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    Toast.makeText(MainActivity.this,"Added",Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(MainActivity.this,"Wrong",Toast.LENGTH_LONG).show();
                    Log.e("err",t.getMessage());
                }
            });
        }
        catch (Error error){
            System.out.println(error.getMessage().toString());
        }

    }

}