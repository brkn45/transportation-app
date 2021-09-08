package com.example.singup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstPage extends AppCompatActivity {
    private Button buttonDriver;
    private Button buttonPassenger;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        database = this.openOrCreateDatabase("Service",MODE_PRIVATE,null);
        database.execSQL("CREATE TABLE IF NOT EXISTS Users (id INTEGER PRIMARY KEY,username VARCHAR,password VARCHAR,country VARCHAR,type VARCHAR,gender VARCHAR,serviceId INT) ");
    }
    public void clickDriver(View v){
        Intent intent = new Intent(FirstPage.this,Start.class);

        intent.putExtra("personType", "driver");

        startActivity(intent);
    }
    public void clickPassenger(View v){
        Intent intent = new Intent(FirstPage.this,Start.class);

        intent.putExtra("personType", "passenger");

        startActivity(intent);
    }

}