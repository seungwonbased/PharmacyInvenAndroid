package com.example.pharmacyinven;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.os.Bundle;
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
    ArrayList<Pharmacy> pharmacyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        fragmentManger = getFragmentManager();
        mapFragment = (MapFragment)fragmentManger.findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this::onMapReady);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        ArrayList<LocationList> locData = new ArrayList<>();



        for (int i = 0; i < 6; ++i) {
            LocationList loc = new LocationList();
            loc.setLatitude(Double.parseDouble(pharmacyList.get(i).getLatitude()));
            loc.setLongitude(Double.parseDouble(pharmacyList.get(i).getLongitude()));
            loc.setName(pharmacyList.get(i).getName());
            locData.add(loc);
            System.out.println(loc);
        }

        for(LocationList data : locData){
            System.out.println(data.getLatitude());
            System.out.println(data.getLongitude());
            System.out.println(data.getName());
        }

        for(LocationList data : locData){
            LatLng location = new LatLng(data.getLatitude(), data.getLongitude());
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.title(data.getName());
            markerOptions.snippet("제발");
            markerOptions.position(location);
            BitmapDrawable bitmap =(BitmapDrawable)getResources().getDrawable(R.drawable.marker);
            Bitmap b = bitmap.getBitmap();
            Bitmap smallMarker = Bitmap.createScaledBitmap(b, 100, 100, false);
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
            System.out.println(data.latitude);
            googleMap.addMarker(markerOptions);
        }


        LatLng location = new LatLng(37.278379, 127.045984);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("success");
        markerOptions.snippet("제발");
        markerOptions.position(location);
        BitmapDrawable bitmap =(BitmapDrawable)getResources().getDrawable(R.drawable.marker);
        Bitmap b = bitmap.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, 100, 100, false);
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));

        googleMap.addMarker(markerOptions);


        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,16));

        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                Intent intent = new Intent(getApplicationContext(), DrugListActivity.class);
                startActivity(intent);
                return false;
            }
        });
    }
}