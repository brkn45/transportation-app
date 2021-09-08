package com.example.singup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Passenger extends AppCompatActivity {
    Button btnJoinBus;
    Retrofit client;
    String passengerId;
    TextView tvAlert,etBusId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger);
        btnJoinBus = (Button) findViewById(R.id.btnAddBus);
        passengerId = getIntent().getStringExtra("id");
        etBusId = (EditText) findViewById(R.id.etBusId);
        tvAlert = (TextView) findViewById(R.id.tvPassAlert);
    }
    public void joinBus(View view){
        try {
            String busId = etBusId.getText().toString();
            if(!etBusId.getText().toString().isEmpty()){
                client = new Retrofit.Builder().baseUrl("https://transportation-backen.herokuapp.com").addConverterFactory(GsonConverterFactory.create()).build();
                GetDataService proxy = client.create(GetDataService.class);

                JoinBus joinBus = new JoinBus(busId,passengerId);

                proxy.joinBus(joinBus).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(Passenger.this,"Gitti",Toast.LENGTH_LONG).show();
                        System.out.println("response: ");
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(Passenger.this,"Wrong",Toast.LENGTH_LONG).show();
                        Log.e("err",t.getMessage());
                    }
                });
            }
            else{
                tvAlert.setText("Please Enter BusId");
                tvAlert.setVisibility(View.VISIBLE);
            }
        }
        catch (Error e){
            System.out.println(e.getMessage().toString());
        }
    }
    public void deregister(View view){

    }
}