package com.example.week1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button views,viewsGroup,logout;
    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        views = findViewById(R.id.views);
        viewsGroup = findViewById(R.id.viewsGroup);
        logout = findViewById(R.id.logout);

        views.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewsIntent = new Intent(MainActivity.this,ViewActivity.class);
                startActivity(viewsIntent);
            }
        });

        viewsGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewsGroupIntent = new Intent(MainActivity.this,ViewGroupActivity.class);
                startActivity(viewsGroupIntent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedpreferences = getSharedPreferences(LoginActivity.MyPREFERENCES, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.commit();

                Intent logoutIntent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(logoutIntent);
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {

        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Press 'Back' again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }
}