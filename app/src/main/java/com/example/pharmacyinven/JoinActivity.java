package com.example.pharmacyinven;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.server.Member;
import com.example.server.RetrofitClient;
import com.example.server.RetrofitInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class JoinActivity extends AppCompatActivity {

    TextView back;
    EditText name, id, pw, phone;
    Button submit;
    RetrofitClient retrofitClient;
    RetrofitInterface retrofitInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        //뒤로 가기 버튼
        back = findViewById(R.id.back);
        back.setOnClickListener(v -> onBackPressed() );

        //기입 항목
        name = findViewById(R.id.signName);
        id = findViewById(R.id.signID);
        pw = findViewById(R.id.signPW);
        phone = findViewById(R.id.signNumber);

        //회원가입 완료 버튼
        submit = findViewById(R.id.signupbutton);
        submit.setOnClickListener(v -> {

            String resultName = name.getText().toString();
            String resultId = id.getText().toString();
            String resultPw = pw.getText().toString();
            String resultPhone = phone.getText().toString();

            System.out.println(resultId + resultName + resultPw + resultPhone);

            retrofitClient = RetrofitClient.getInstance();
            retrofitInterface = RetrofitClient.getRetrofitInterface();
            retrofitInterface.registerMember(resultId, resultPw, resultName, resultPhone).enqueue(new Callback<Member>() {

                @Override
                public void onResponse(Call<Member> call, Response<Member> response) {

                    System.out.println(resultId + resultName + resultPw + resultPhone);

                    Log.d("Retrofit register PUT", "성공");
                }

                @Override
                public void onFailure(Call<Member> call, Throwable t) {
                    Log.e("Retrofit register PUT", t.getMessage().toString());
                }

            });

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);

        });



    }
}