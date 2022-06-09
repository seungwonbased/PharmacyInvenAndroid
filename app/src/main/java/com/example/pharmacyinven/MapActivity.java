package com.example.pharmacyinven;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private FragmentManager fragmentManger;
    private MapFragment mapFragment;

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
        ArrayList<LocationList> locdata = new ArrayList<>();

        LocationList loc = new LocationList();
        loc.setLatitude(37.278379);
        loc.setLongitude(127.045984);
        loc.setName("도병원약국");
        locdata.add(loc);

        loc = new LocationList();
        loc.setLatitude(37.278659);
        loc.setLongitude(127.045211);
        loc.setName("메디온우리대학약국");
        locdata.add(loc);

        for(LocationList data : locdata){
            System.out.println(data.getLatitude());
            System.out.println(data.getLongitude());
            System.out.println(data.getName());
        }

        //위에는 반복문으로 진행 승원이가 만들어준 데이터로 객체로 ArrayList add

        for(LocationList data : locdata){
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
//        MarkerOptions markerOptions = new MarkerOptions();
//        markerOptions.title("success");
//        markerOptions.snippet("제발");
//        markerOptions.position(location);
//        BitmapDrawable bitmap =(BitmapDrawable)getResources().getDrawable(R.drawable.marker);
//        Bitmap b = bitmap.getBitmap();
//        Bitmap smallMarker = Bitmap.createScaledBitmap(b, 100, 100, false);
//        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
//
//        googleMap.addMarker(markerOptions);


        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,16));

        //Marker 클릭 시 다음 레이아웃으로 넘어가기
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