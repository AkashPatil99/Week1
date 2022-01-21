package com.example.week1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class ViewGroupActivity extends AppCompatActivity {

    ImageView profileImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_group);

        setProfileImage();
    }

    private void setProfileImage() {
        profileImage = findViewById(R.id.profile);
        profileImage.setImageDrawable(getResources().getDrawable(R.drawable.harry));
    }
}