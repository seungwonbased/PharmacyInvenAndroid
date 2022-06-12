package com.example.pharmacyinven;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.view.Menu;
import android.os.Bundle;
import android.view.MenuItem;
import android.util.Log;

import com.example.server.Pharmacy;
import com.example.server.RetrofitClient;
import com.example.server.RetrofitInterface;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private FragmentManager fragmentManger;
    private MapFragment mapFragment;
    private RetrofitClient retrofitClient;
    private RetrofitInterface retrofitInterface;
    private String memberId;
    ArrayList<Pharmacy> pharmacyList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Intent intent = getIntent();
        memberId = intent.getStringExtra("memberId");

        fragmentManger = getFragmentManager();
        mapFragment = (MapFragment) fragmentManger.findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this::onMapReady);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        Pharmacy pharmacy1 = new Pharmacy("1", "원천약국", "37.278502", "127.045571", "0312190000");
        Pharmacy pharmacy2 = new Pharmacy("2", "도병원약국", "37.278379", "127.045984", "0312190001");
        Pharmacy pharmacy3 = new Pharmacy("3", "메디온우리대학약국", "37.278659", "127.045211", "0312190002");
        Pharmacy pharmacy4 = new Pharmacy("4", "지민약국", "37.276667", "127.041173", "0312190003");
        Pharmacy pharmacy5 = new Pharmacy("5", "그린약국", "37.276135", "127.040973", "0312190004");
        Pharmacy pharmacy6 = new Pharmacy("6", "아주메디약국", "37.277197", "127.048156", "0312190005");

        pharmacyList = new ArrayList<>();

        pharmacyList.add(pharmacy1);
        pharmacyList.add(pharmacy2);
        pharmacyList.add(pharmacy3);
        pharmacyList.add(pharmacy4);
        pharmacyList.add(pharmacy5);
        pharmacyList.add(pharmacy6);

        ArrayList<LocationList> locData = new ArrayList<>();

        for (int i = 0; i < 6; ++i) {
            LocationList loc = new LocationList();
            loc.setLatitude(Double.parseDouble(pharmacyList.get(i).getLatitude()));
            loc.setLongitude(Double.parseDouble(pharmacyList.get(i).getLongitude()));
            loc.setName(pharmacyList.get(i).getName());
            locData.add(loc);
        }

        for (LocationList data : locData) {
            LatLng location = new LatLng(data.getLatitude(), data.getLongitude());
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.title(data.getName());
            markerOptions.position(location);
            BitmapDrawable bitmap = (BitmapDrawable) getResources().getDrawable(R.drawable.marker);
            Bitmap b = bitmap.getBitmap();
            Bitmap smallMarker = Bitmap.createScaledBitmap(b, 100, 100, false);
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
            googleMap.addMarker(markerOptions);
        }

        LatLng location = new LatLng(37.278379, 127.045984);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 17));

        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                Intent intent = new Intent(getApplicationContext(), DrugListActivity.class);
                System.out.println(marker.getTitle());
                intent.putExtra("pharmName", marker.getTitle());
                intent.putExtra("memberId", memberId);
                startActivity(intent);
                return false;
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