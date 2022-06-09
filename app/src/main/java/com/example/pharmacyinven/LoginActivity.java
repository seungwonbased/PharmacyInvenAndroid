package com.example.pharmacyinven;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.server.RetrofitClient;
import com.example.server.RetrofitInterface;


public class LoginActivity extends AppCompatActivity {

    EditText id;
    EditText pw;
    RetrofitClient retrofitClient;
    RetrofitInterface retrofitInterface;

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id = findViewById(R.id.editID);
        pw = findViewById(R.id.signID);








    }
}