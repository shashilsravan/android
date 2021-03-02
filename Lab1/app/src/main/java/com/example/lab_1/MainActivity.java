package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText uname, upass;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname = findViewById(R.id.et1);
        upass = findViewById(R.id.et2);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!uname.getText().toString().equals("") &&
                    uname.getText().toString().equals("shashil") &&
                    !upass.getText().toString().equals("") &&
                    upass.getText().toString().equals("sravan")){
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Logged in as  " + uname.getText().toString() , Toast.LENGTH_LONG);
                        toast.show();
                        Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                        intent.putExtra("USERNAME", uname.getText().toString());
                        intent.putExtra("PASSWORD", upass.getText().toString());
                        startActivity(intent);
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Need valid inputs" , Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

    }
}
