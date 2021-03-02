package com.example.lab_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    EditText et1, et2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.num1);
        et2 = (EditText) findViewById(R.id.num2);
        result = (TextView) findViewById(R.id.result);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMul.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        float num1 = 0;
        float num2 = 0;
        float res = 0;
        String oper = "";


        if(TextUtils.isEmpty(et1.getText().toString()) ||
            TextUtils.isEmpty(et2.getText().toString())) {
            Toast.makeText(this, "Please enter both numbers",
                    Toast.LENGTH_LONG).show();
        }
        else{
            num1 = Float.parseFloat(et1.getText().toString());
            num2 = Float.parseFloat(et2.getText().toString());

            switch (v.getId()){
                case R.id.btnAdd:
                    oper = "+";
                    res = num1 + num2;
                    break;
                case R.id.btnSub:
                    oper = "-";
                    res = num1 - num2;
                    break;
                case R.id.btnMul:
                    oper = "*";
                    res = num1 * num2;
                    break;
                case R.id.btnDiv:
                    oper = "/";
                    res = num1 / num2;
                    break;
                default:
                    break;
            }

            String temp = num1 + " " + oper + " " + num2 + " = " + res;
            result.setText(temp);
        }
    }
}
