package com.example.pharmacyinven;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.action.BasketAdapter;
import com.example.server.Cart;
import com.example.server.Drug;
import com.example.server.Member;
import com.example.server.Pharmacy;
import com.example.server.RetrofitClient;
import com.example.server.RetrofitInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BasketActivity extends AppCompatActivity {

    private List<Cart> cart;
    private ListView listView;
    RetrofitClient retrofitClient;
    RetrofitInterface retrofitInterface;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        listView = findViewById(R.id.basket);
        cart = new ArrayList<>();
        

//        retrofitClient = RetrofitClient.getInstance();
//        retrofitInterface = RetrofitClient.getRetrofitInterface();
//        retrofitInterface.getCart("bsw1234").enqueue(new Callback<List<Cart>>() {
//            @Override
//            public void onResponse(Call<List<Cart>> call, Response<List<Cart>> response) {
//                cart = response.body();
//                System.out.println(cart);
//                BasketAdapter adapter = new BasketAdapter(getLayoutInflater(), cart);
//                listView.setAdapter(adapter);
//                Log.d("sss", "성공");
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Cart>> call, Throwable t) {
//                Log.e("ss", t.getMessage().toString());
//            }
//        });



    }


}
