package com.example.pharmacyinven;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.server.Member;
import com.example.server.Pharmacy;
import com.example.server.RetrofitClient;
import com.example.server.RetrofitInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    EditText id;
    EditText pw;
    RetrofitClient retrofitClient;
    RetrofitInterface retrofitInterface;
    Button login;
    Button register;

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id = findViewById(R.id.editID);
        pw = findViewById(R.id.ediPassword);
        login = findViewById(R.id.loginbutton);
        register = findViewById(R.id.signin);

        register.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
            startActivity(intent);
        });

        login.setOnClickListener(view -> {

            String resultId = id.getText().toString();
            String resultPw = pw.getText().toString();

            retrofitClient = RetrofitClient.getInstance();
            retrofitInterface = RetrofitClient.getRetrofitInterface();
            retrofitInterface.login(resultId, resultPw).enqueue(new Callback<Member>() {

                @Override
                public void onResponse(Call<Member> call, Response<Member> response) {
                    if (response.body().equals(null)) {
                        Log.d("Retrofit login", "로그인 실패");
                    } else {
                        Log.d("Retrofit login", "로그인 성공");
                        Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                        intent.putExtra("memberId", resultId);
                        startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<Member> call, Throwable t) {
                    Log.e("Retrofit login", "통신 실패");
                }

            });

        });

    }
}