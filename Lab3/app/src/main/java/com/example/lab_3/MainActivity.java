package com.example.lab_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2, et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);

    }

    public void openWebsite(View view){
        String url = et1.getText().toString();

        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else{
            Log.d("Implicit Intents", "Can't handle this");
        }
    }

    public void openLocation(View view){
        String loc = et2.getText().toString();

        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else{
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void shareText(View view){
        String text = et3.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder.from(this)
                .setType(mimeType)
                .setChooserTitle("Title here")
                .setText(text)
                .startChooser();
    }

}
