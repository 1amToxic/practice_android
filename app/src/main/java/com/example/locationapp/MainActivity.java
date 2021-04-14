package com.example.locationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.locationapp.adapter.LocationAdapter;
import com.example.locationapp.fragment.FragmentDetail;
import com.example.locationapp.model.Location;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<Location> listLocation;
    LocationAdapter locationAdapter;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        setUpFragment();
    }

    private void setUpFragment(Location location) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("location",location);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentDetail fragment_detail = new FragmentDetail();
        fragment_detail.setArguments(bundle);
        fragmentTransaction.add(R.id.fragment_container,fragment_detail, null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void initView() {
        listView = findViewById(R.id.list_location);
        listLocation = new ArrayList<>();
        listLocation.add(new Location(1,"Phu Quoc","https://vcdn-dulich.vnecdn.net/2020/05/27/shutterstock-1355875478-3291-1-5462-7597-1590571669.jpg", "Phu Quoc"));
        listLocation.add(new Location(2,"Phu Quoc","https://vcdn-dulich.vnecdn.net/2020/05/27/shutterstock-1355875478-3291-1-5462-7597-1590571669.jpg", "Phu Quoc"));
        listLocation.add(new Location(3,"Phu Quoc","https://vcdn-dulich.vnecdn.net/2020/05/27/shutterstock-1355875478-3291-1-5462-7597-1590571669.jpg", "Phu Quoc"));
        listLocation.add(new Location(4,"Phu Quoc","https://vcdn-dulich.vnecdn.net/2020/05/27/shutterstock-1355875478-3291-1-5462-7597-1590571669.jpg", "Phu Quoc"));
        listLocation.add(new Location(5,"Phu Quoc","https://vcdn-dulich.vnecdn.net/2020/05/27/shutterstock-1355875478-3291-1-5462-7597-1590571669.jpg", "Phu Quoc"));
        listLocation.add(new Location(6,"Phu Quoc","https://vcdn-dulich.vnecdn.net/2020/05/27/shutterstock-1355875478-3291-1-5462-7597-1590571669.jpg", "Phu Quoc"));
        locationAdapter = new LocationAdapter();
        locationAdapter.setListLocation(listLocation);

        listView.setAdapter(locationAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setUpFragment(listLocation.get(position));
            }
        });

    }
}
