package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        tv = findViewById(R.id.tv1);
        String temp = "Hi! " + getIntent().getStringExtra("USERNAME")
                + " "
                + getIntent().getStringExtra("PASSWORD");
        tv.setText(temp);
    }
}
