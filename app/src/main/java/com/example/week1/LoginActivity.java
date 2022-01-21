package com.example.week1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText userName,password;
    Button login;

    SharedPreferences credentials;
    public static final String MyPREFERENCES = "User";

    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        credentials = getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);

        if(credentials.contains("Status")){
            Intent loginIntent = new Intent(LoginActivity.this,MainActivity.class);
            Toast.makeText(LoginActivity.this,"LogIn automatic",Toast.LENGTH_SHORT).show();
            startActivity(loginIntent);
        }

        setUpLogin();
    }

    private void setUpLogin() {

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        credentials = getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Username = userName.getText().toString();
                final String Password = password.getText().toString();

                if(Username.equals("admin") && Password.equals("admin123")){

                    SharedPreferences.Editor editor = credentials.edit();
                    editor.putString("UserName",Username);
                    editor.putString("Password",Password);
                    editor.putString("Status","True");
                    editor.commit();

                    Intent loginIntent = new Intent(LoginActivity.this,MainActivity.class);
                    Toast.makeText(LoginActivity.this,"LogIn Successful",Toast.LENGTH_SHORT).show();
                    startActivity(loginIntent);
                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this,"UserName/Password incorrect",Toast.LENGTH_SHORT).show();
                }
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