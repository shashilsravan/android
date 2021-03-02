package com.example.lab9;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener {

    EditText editEmpid, editName, editSalary;
    Button addBtn, deleteBtn, modifyBtn, viewBtn, viewAllBtn;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmpid = findViewById(R.id.et1);
        editName = findViewById(R.id.et2);
        editSalary = findViewById(R.id.et3);

        addBtn = findViewById(R.id.addBtn);
        deleteBtn = findViewById(R.id.deleteBtn);
        modifyBtn = findViewById(R.id.modifyBtn);
        viewBtn = findViewById(R.id.viewBtn);
        viewAllBtn = findViewById(R.id.viewAllBtn);

        addBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        modifyBtn.setOnClickListener(this);
        viewBtn.setOnClickListener(this);
        viewAllBtn.setOnClickListener(this);

        db = openOrCreateDatabase("EmployeeDB", Context.MODE_PRIVATE,
                null);
        db.execSQL("CREATE TABLE IF NOT EXISTS "
                + "employee(empid VARCHAR, name VARCHAR, salary VARCHAR);");
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setTitle(title);
        myAlert.setCancelable(true);
        myAlert.setMessage(message);
        myAlert.show();
    }

    public void clearText(){
        editEmpid.setText("");
        editSalary.setText("");
        editName.setText("");
        editEmpid.requestFocus();
    }

    @Override
    public void onClick(View v) {
        if (v == addBtn){
            if (editEmpid.getText().toString().trim().length() == 0 ||
                editName.getText().toString().trim().length() == 0 ||
                editSalary.getText().toString().trim().length() == 0){
                showMessage("Error", "Please enter all values");
                return;
            }
            db.execSQL("INSERT INTO employee VALUES('" +
                    editEmpid.getText() + "', '"
                    + editName.getText() + "', '"
                    + editSalary.getText() + "');");
            showMessage("Success", "Record added");
            clearText();
        }
        if (v == deleteBtn){
            if (editEmpid.getText().toString().trim().length() == 0){
                showMessage("Error", "Please enter Employee id");
                return;
            }

            Cursor c = db.rawQuery("SELECT * FROM employee WHERE empid='" +
                    editEmpid.getText()+"'", null);

            if (c.moveToFirst()){
                db.execSQL("DELETE FROM employee WHERE empid='"
                        + editEmpid.getText()+"'");
                showMessage("Success", "Record deleted");
            }
            else{
                showMessage("Error", "Invalid Employee id");
            }
            clearText();
        }
        if (v == modifyBtn){
            if(editEmpid.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter Employee id");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM employee WHERE empid='"+editEmpid.getText()+"'",
                    null);
            if (c.moveToFirst()){
                db.execSQL("UPDATE employee SET name='"
                        + editName.getText()
                        + "',salary='"
                        + editSalary.getText()
                        + "' WHERE empid='"
                        + editEmpid.getText() + "'" );
                showMessage("Success", "Record Modified");
            }
            clearText();
        }
        if (v == viewBtn){

            if(editEmpid.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter Employee id");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM employee WHERE empid='"+editEmpid.getText()+"'",
                    null);
            if(c.moveToFirst())
            {
                editName.setText(c.getString(1));
                editSalary.setText(c.getString(2));
            }
            else
            {
                showMessage("Error", "Invalid Employee id");
                clearText();
            }
        }
        if (v == viewAllBtn){
            Cursor c=db.rawQuery("SELECT * FROM employee", null);
            if(c.getCount()==0)
            {
                showMessage("Error", "No records found");
                return;
            }
            StringBuffer buffer=new StringBuffer();
            while(c.moveToNext())
            {
                buffer.append("Employee id: "+c.getString(0)+"\n");
                buffer.append("Name: "+c.getString(1)+"\n");
                buffer.append("salary: "+c.getString(2)+"\n\n");
            }
            showMessage("Employee Details: ", buffer.toString());
        }
    }
}
