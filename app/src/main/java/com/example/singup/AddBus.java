package com.example.singup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddBus extends AppCompatActivity {
    Retrofit client;
    EditText etName,etTotalPas,etRoute;
    TextView tvAlert;
    String name,route, driverId;
    int totalPas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bus);
        etName = (EditText) findViewById(R.id.etBusAddName);
        etTotalPas = (EditText) findViewById(R.id.etPersonNum);
        etRoute = (EditText) findViewById(R.id.etRoute);
        tvAlert = (TextView)  findViewById(R.id.tvAlert);
    }
    public void AddBus(View view){
        try{
            client = new Retrofit.Builder().baseUrl("https://transportation-backen.herokuapp.com").addConverterFactory(GsonConverterFactory.create()).build();
            GetDataService proxy = client.create(GetDataService.class);
            name= etName.getText().toString();
            totalPas = Integer.valueOf(etTotalPas.getText().toString());
            route = etRoute.getText().toString();
            System.out.println("Ne oluyor sana");
            if(!name.isEmpty() && !etTotalPas.getText().toString().isEmpty() && !route.isEmpty()){
                driverId = driverId = getIntent().getStringExtra("id");
                BusFeature bus = new BusFeature(name,route,totalPas,driverId);

                proxy.busFun(bus).enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        Toast.makeText(AddBus.this,"Added",Toast.LENGTH_LONG).show();
                        //System.out.println("response: " + response.message().toString() );
                        Integer busId = response.body();
                        System.out.println("busId: " + busId);
                        Intent intent = new Intent(AddBus.this,Driver.class);
                        intent.putExtra("busId",busId);
                        finish();
                        startActivity(intent);
                    }
                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                        Toast.makeText(AddBus.this, "Wrong",Toast.LENGTH_LONG).show();
                        Log.e("err",t.getMessage());
                    }

                });
            }
            else{
                tvAlert.setText("Fill all field");
                tvAlert.setVisibility(View.VISIBLE);

            }


    }
        catch (Error e){
            System.out.println("Catch err:" + e.getMessage().toString());
        }
    }
}