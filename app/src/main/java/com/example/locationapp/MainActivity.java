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
        listLocation.add(new Location(1,"Phu Quoc","https://vcdn-dulich.vnecdn.net/2020/05/27/shutterstock-1355875478-3291-1-5462-7597-1590571669.jpg", "Phu Quoc",10.276024,104.013676));
        listLocation.add(new Location(2,"Ha Noi","https://i.ytimg.com/vi/FClS4ni4zfo/maxresdefault.jpg", "Ha Noi",21.045327, 105.845889));
        listLocation.add(new Location(3,"Ha Long","https://lh5.googleusercontent.com/p/AF1QipN6Oye0m_af1UW70ORKo9x2U1YxKxk3SmgGIwKU=w408-h544-k-no", "Ha Long",20.974220, 107.042584));
        listLocation.add(new Location(4,"Da Nang","https://vietsensetravel.com/view-1200/at_da-nang-thuoc-tinh-nao-thoi-diem-ly-tuong-de-du-lich-da-nang_92bba6f680d8edbcfef4923daee0f216.jpg", "Da Nang",16.127839, 108.247715));
        listLocation.add(new Location(5,"Da Lat","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/Xuan_Huong_Lake_11.jpg/1200px-Xuan_Huong_Lake_11.jpg", "Da Lat",11.915660, 108.443853));
        listLocation.add(new Location(6,"Sa pa","https://viettrekking.vn/wp-content/uploads/2020/01/30097580257_5b7be918f6_c-1.jpg", "Sa pa",22.365388, 103.815221));
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
