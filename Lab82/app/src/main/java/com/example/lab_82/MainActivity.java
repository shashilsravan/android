package com.example.lab_82;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendEmail(View view){
        String[] to = {"n160247@rguktn.ac.in"};
        String[] cc = {"shashilsravan.ss.ss@gmail.com"};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setDataAndType(Uri.parse("mailto:"), "text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "mad lab");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "hello hello");

        try{
            startActivity(Intent.createChooser(emailIntent, "choose via..."));
            finish();
        }
        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(MainActivity.this,
                    "There is no email client installed.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
