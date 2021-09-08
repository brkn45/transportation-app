package com.example.singup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Show extends AppCompatActivity {
    Data data;
    TextView name,surname,country,age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        data    = (Data) getIntent().getSerializableExtra("veri");


        name    = (TextView) findViewById(R.id.txtName);
        surname = (TextView) findViewById(R.id.txtSurname);
        country = (TextView) findViewById(R.id.txtCountry);
        age     = (TextView) findViewById(R.id.txtAge);

        name.setText(data.getName().get(data.getIndex()));
        surname.setText(data.getSurname().get(data.getIndex()));
        country.setText(data.getCountry().get(data.getIndex()));
        //age.setText(data.getAge().get(data.getIndex()));
    }
}