package com.example.locationapp.gridlayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.locationapp.R;

import javax.xml.transform.Result;

public class GridActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int IMAGE_CODE = 240;
    ImageView imageAvatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        initView();
        imageAvatar.setOnClickListener(this);
    }

    private void initView() {
        imageAvatar = findViewById(R.id.image_avatar);
    }

    @Override
    public void onClick(View v) {
        Intent imageIntent = new Intent(Intent.ACTION_PICK);
        imageIntent.setType("image/*");
        startActivityForResult(imageIntent, 240);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            switch (requestCode){
                case IMAGE_CODE:{
                    assert data != null;
                    Uri uri = data.getData();
                    imageAvatar.setImageURI(uri);
                    break;
                }
            }
        }
    }
}