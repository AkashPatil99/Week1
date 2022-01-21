package com.example.week1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    TextView textChange;
    ImageView image;

    private int i = 1,j = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        setUpTextChange();
        setUpImageChange();
    }

    private void setUpImageChange() {
        image = findViewById(R.id.image);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (j == 1){
                    image.setColorFilter(Color.parseColor("#FF15A5E6"),android.graphics.PorterDuff.Mode.MULTIPLY);
                    j = 2;
                }
                else{
                    image.setColorFilter(Color.parseColor("#6796BC"),android.graphics.PorterDuff.Mode.MULTIPLY);
                    j = 1;
                }
            }
        });

    }

    private void setUpTextChange() {
        textChange = findViewById(R.id.textChange);

        textChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("I=", "onClick:"+i);
                if(i == 1){
                    textChange.setTextColor(Color.parseColor("#FF1201"));
                    textChange.setTypeface(null, Typeface.ITALIC);
                    i = 2;
                }
                else if(i == 2){
                    textChange.setTextColor(Color.parseColor("#FF38FF01"));
                    textChange.setTypeface(null, Typeface.BOLD);
                    i = 3;
                }
                else if(i == 3){
                    textChange.setTextColor(Color.parseColor("#FF2E91DF"));
                    textChange.setTypeface(null, Typeface.BOLD);
                    textChange.setTypeface(null, Typeface.ITALIC);
                    i = 1;
                }
            }
        });
    }
}