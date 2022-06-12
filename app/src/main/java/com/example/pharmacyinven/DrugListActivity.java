package com.example.pharmacyinven;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.action.DrugAdapter;
import com.example.server.Drug;
import com.example.server.RetrofitClient;
import com.example.server.RetrofitInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DrugListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter drugAdapter;
    private ArrayAdapter arrayAdapter;
    private ListView listView;
    private Button drug_btn;
    private List<Drug> drugList;
    private RetrofitClient retrofitClient;
    private RetrofitInterface retrofitInterface;
    private String pharmName;
    private String memberId;
    private Toast toast;

    DrugAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug_list);

        Intent intent = getIntent();
        String pharmName = intent.getStringExtra("pharmName");
        String memberId = intent.getStringExtra("memberId");

        listView = findViewById(R.id.druglistview);
        drugList = new ArrayList<>();
        DrugAdapter adapter1 = new DrugAdapter(getLayoutInflater(),drugList);
        listView.setAdapter(adapter1);

        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        retrofitInterface.getDrugList("1").enqueue(new Callback<List<Drug>>() {
            @Override
            public void onResponse(Call<List<Drug>> call, Response<List<Drug>> response) {
                drugList = response.body();
                adapter = new DrugAdapter(getLayoutInflater(), drugList);
                listView.setAdapter(adapter);
                Log.d("Retrofit drug list GET", "성공");
            }

            @Override
            public void onFailure(Call<List<Drug>> call, Throwable t) {
                Log.e("Retrofit drug list GET", t.getMessage().toString());
            }
        });






    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.basketmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items

        switch (item.getItemId()) {
            case R.id.basketbtn:

                Intent intent = new Intent(getApplicationContext(), BasketActivity.class);
                startActivity(intent);


                return true;
        }

        return false;
    }

}