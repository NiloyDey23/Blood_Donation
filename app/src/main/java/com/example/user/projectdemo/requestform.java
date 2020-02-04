package com.example.user.projectdemo;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class requestform extends AppCompatActivity implements View.OnClickListener{


    databases databases;
    Button searchbtn;
    Spinner area, bloodgroup;
   // CheckBox check;
    String[] reqgroups;
    String [] reqareas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestform);

        databases = new databases(this);


        reqgroups= getResources().getStringArray(R.array.Groups);
        reqareas = getResources().getStringArray(R.array.Areas);

        searchbtn = findViewById(R.id.search);
        //check = findViewById(R.id.areacheck);
        area = findViewById(R.id.areaspin);
        bloodgroup =  findViewById(R.id.groupspin);

        searchbtn.setOnClickListener(this);
     //   check.setOnClickListener( this);


        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, R.layout.spinnerview, R.id.spinview, reqgroups);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, R.layout.spinnerview, R.id.spinview, reqareas);
        bloodgroup.setAdapter(adapter1);
        area.setAdapter(adapter2);


    }


    @Override
    public void onClick(View view) {

        String grpvalue = bloodgroup.getSelectedItem().toString();
        String areavalue = area.getSelectedItem().toString();

        if (view.getId()==R.id.search)
        {

            Cursor res = databases.getquery(grpvalue,areavalue);

            if(res.getCount() == 0)
            {
                show("Error", "No one's found");


            }

            else
            {
                StringBuffer buffer = new StringBuffer();

                while (res.moveToNext())
                {
                    buffer.append("Contact: "+ res.getString(0)+ "\n\n");
                }
                show("matched", buffer.toString());
            }
        }
    }



    public void show( String title, String message ){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
