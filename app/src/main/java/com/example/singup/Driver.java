package com.example.singup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Driver extends AppCompatActivity {
    private Data data;
    Button btnAddBus;
    String driverId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        btnAddBus = (Button) findViewById(R.id.btnAddBus);
         //data    = (Data) getIntent().getSerializableExtra("veri");
        driverId = getIntent().getStringExtra("id");
    }
    public void AllPersonFun(View view){
        Intent intent = new Intent(Driver.this,PeopleList.class);

        intent.putExtra("driverId", driverId);
        startActivity(intent);
    }
    public void addBusFun(View view){
        Intent intent = new Intent(Driver.this, AddBus.class);
        intent.putExtra("id",driverId);
        startActivity(intent);
    }
}