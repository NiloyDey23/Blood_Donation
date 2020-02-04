package com.example.user.projectdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class signupform extends AppCompatActivity implements View.OnClickListener {


    databases databases;
    EditText edit_name, edit_num;
    Button btncnfrm;
    Spinner spingroup,spinarea;
    CheckBox check;
    String str = "";
    String[] groups;
    String [] areas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupform);


        groups= getResources().getStringArray(R.array.Groups);
        areas = getResources().getStringArray(R.array.Areas);


        btncnfrm = findViewById(R.id.confirmbtn);
        edit_name = findViewById(R.id.namebox);
        edit_num = findViewById(R.id.numbox);
        check = findViewById(R.id.agreecheck);
        spingroup = findViewById(R.id.spinnergrp);
        spinarea = findViewById(R.id.spinnerarea);


        btncnfrm.setOnClickListener(this);
        check.setOnClickListener(this);


        databases = new databases(this);


        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, R.layout.spinnerview, R.id.spinview, groups);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, R.layout.spinnerview, R.id.spinview, areas);
        spingroup.setAdapter(adapter1);
        spinarea.setAdapter(adapter2);

    }




    public void onClick(View view) {

        if (view.getId()==R.id.agreecheck)
        {
            if(check.isChecked())
            btncnfrm.setEnabled(true);

            else
                btncnfrm.setEnabled(false);
        }


        String name = edit_name.getText().toString();
        String num = edit_num.getText().toString();
        String grpvalue = spingroup.getSelectedItem().toString();
        String areavalue = spinarea.getSelectedItem().toString();


        if(name.isEmpty() && num.isEmpty()){

            Toast.makeText(getApplicationContext(), "please enter your informations", Toast.LENGTH_LONG).show();

        }
        else
        {


            if (view.getId() == R.id.confirmbtn) {

                long res = databases.InsertData(name, grpvalue, num, areavalue);


                if (res == -1) {
                    Toast.makeText(getApplicationContext(), "Sign Up Failed. Please Try Again", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Thank you! Sign Up Completed", Toast.LENGTH_LONG).show();

                    edit_name.setText(str);
                    edit_num.setText(str);

                }

            }

        }
    }
}
