package com.example.singup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Start extends AppCompatActivity {
    Data data = new Data();
    EditText editTextName, editTextSurname;
    TextView textViewMain ,textAlert;
    String mail,password;
    private Retrofit client;
    String driver = "driver" , passenger = "passenger";
    private  String personType ;  //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        editTextName = (EditText) findViewById(R.id.sEditTextName);
        editTextSurname =(EditText) findViewById(R.id.sEditTextSurname);
        textViewMain =(TextView) findViewById(R.id.TextViewMain);
        textAlert = (TextView) findViewById((R.id.textViewAlert));
        personType = getIntent().getStringExtra("personType").toString();
        if(personType.equals(driver)){
            textViewMain.setText("Driver");
        }
        else if(personType.equals(passenger)){
            textViewMain.setText("Passenger");
        }
    }
    public void singUp(View view){
        Intent intent = new Intent(Start.this,MainActivity.class);

        intent.putExtra("veri", data);
        finish();
        startActivity(intent);
    }
    public void singin(View view){
        int i=0;
        String mail = editTextName.getText().toString();
        String password = editTextSurname.getText().toString();
        authRequest(mail,password);

    }
    private void authRequest(String mail, String password) {
        try{
            client = new Retrofit.Builder().baseUrl("https://transportation-backen.herokuapp.com").addConverterFactory(GsonConverterFactory.create()).build();
            GetDataService proxy = client.create(GetDataService.class);

            Auth auth = new Auth(mail,password,personType);

            proxy.AuthFun(auth).enqueue(new Callback<SuccessEntity>() {
                @Override
                public void onResponse(Call<SuccessEntity> call, Response<SuccessEntity> response) {
                    Toast.makeText(Start.this,"Added",Toast.LENGTH_LONG).show();
                   //System.out.println("response: " + response.message().toString() );
                    SuccessEntity success = response.body();
                    if(success.getSuccess() == true){
                        if(personType.equals(driver)){
                            Intent intent = new Intent(Start.this,Driver.class);
                            intent.putExtra("id",String.valueOf(success.getId()));
                            finish();
                            startActivity(intent);
                        }
                        else if(personType.equals(passenger)){
                            Intent intent = new Intent(Start.this,Passenger.class);
                            intent.putExtra("id",String.valueOf(success.getId()));
                            finish();
                            startActivity(intent);
                        }

                    }
                    else{
                        textAlert.setText("Wrong Email or Password");
                        textAlert.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onFailure(Call<SuccessEntity> call, Throwable t) {
                    Toast.makeText(Start.this, "Wrong",Toast.LENGTH_LONG).show();
                    Log.e("err",t.getMessage());
                }
            });
        }
        catch (Error error){
            System.out.println(error.getMessage().toString());
        }
    }
}