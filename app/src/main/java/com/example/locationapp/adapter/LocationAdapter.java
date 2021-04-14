package com.example.locationapp.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.locationapp.R;
import com.example.locationapp.model.Location;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LocationAdapter extends BaseAdapter {
    List<Location> listLocation;
    TextView tvName;
    public LocationAdapter() {
        listLocation = new ArrayList<>();
    }
    public void setListLocation(List<Location> list){
        this.listLocation.addAll(list);
    }

    @Override
    public int getCount() {
        return listLocation.size();
    }

    @Override
    public Object getItem(int position) {
        return listLocation.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listLocation.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewLocation;
        if(convertView == null){
            viewLocation = View.inflate(parent.getContext(), R.layout.item_location,null);
        }else viewLocation = convertView;
        Location location = listLocation.get(position);
        tvName = viewLocation.findViewById(R.id.tv_name);
        tvName.setText(location.getName());
        return viewLocation;
    }
}
