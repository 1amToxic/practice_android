package com.example.locationapp.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.locationapp.R;
import com.example.locationapp.model.Location;


public class FragmentDetail extends Fragment implements View.OnClickListener {

    TextView tvNameDetail, tvDesDetail;
    ImageView imageView;
    Location location;
    Button btnMap;

    public FragmentDetail() {
        // Required empty public constructor
    }

    public static FragmentDetail newInstance(String param1, String param2) {
        FragmentDetail fragment = new FragmentDetail();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        location = (Location) getArguments().getSerializable("location");
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        initView(view);
        return view;

    }

    private void initView(View view) {
        tvDesDetail = view.findViewById(R.id.tv_des_dt);
        tvNameDetail = view.findViewById(R.id.tv_name_dt);
        imageView = view.findViewById(R.id.image_location);
        btnMap = view.findViewById(R.id.btn_map);
        //set data for view



        tvDesDetail.setText(location.getDescription());
        tvNameDetail.setText(location.getName());

        Glide.with(view.getContext())
                .load(location.getImageSource())
                .centerCrop()
                .into(imageView);
        btnMap.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Uri gmmIntentUri = Uri.parse("google.navigation:q=10.276024,104.013676");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        getContext().startActivity(mapIntent);
    }
}
