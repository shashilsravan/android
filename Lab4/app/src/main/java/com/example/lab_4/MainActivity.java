package com.example.lab_4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendAlert(View view){
        AlertDialog.Builder myAlert =
                new AlertDialog.Builder(MainActivity.this);
        myAlert.setTitle("Alert");
        myAlert.setMessage("Okay to continue, Cancel to stop");
        myAlert.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Clicked okay",
                        Toast.LENGTH_SHORT).show();
            }
        });
        myAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "clicked on Cancel", Toast.LENGTH_SHORT).show();
            }
        });
        myAlert.show();
    }
}
