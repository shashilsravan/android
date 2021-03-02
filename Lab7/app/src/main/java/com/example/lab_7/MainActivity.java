package com.example.lab_7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText Edate, Etime;
    TextView tvTime;
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Edate = findViewById(R.id.etDate);
        Etime = findViewById(R.id.etTime);
        tvTime = findViewById(R.id.tv1);
        tvDate = findViewById(R.id.tv2);
    }

    public void chooseDate(View view){
        DialogFragment newFragment = new myDateFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void dateResult(View v,int year,int month,int day){
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String date=year_string+"/"+month_string+"/"+day_string;
        Edate.setText(date);
        tvDate.setText(date);
        Toast.makeText(this, ""+date, Toast.LENGTH_SHORT).show();
    }

    public void chooseTime(View view){
        DialogFragment newFragment = new timepicker();
        newFragment.show(getSupportFragmentManager(),"timePicker");
    }

    public void timeResult(View v,int hour,int min){
        String hr_string = Integer.toString(hour);
        String min_string = Integer.toString(min);
        String time=hr_string+":"+min_string;
        Etime.setText(time);
        tvTime.setText("Time :\t"+time);
        Toast.makeText(this, ""+time, Toast.LENGTH_SHORT).show();
    }


}
