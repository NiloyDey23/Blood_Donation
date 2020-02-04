package com.example.user.projectdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements  OnClickListener {

    databases db;
    //signupform sign;

    private  static Button button_login;
    private  static Button button_admin;
    private  static Button button_signup;
    private  static Button button_request;


    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new databases(this);


        button_login = findViewById(R.id.login);
        button_admin = findViewById(R.id.admin);
        button_signup = findViewById(R.id.signup);
        button_request = findViewById(R.id.request);

        button_login.setOnClickListener(this);
        button_admin.setOnClickListener(this);
        button_signup.setOnClickListener(this);
        button_request.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){

            case R.id.login:
               intent = new Intent("android.intent.action.Login");
                startActivity(intent);
                break;

            case R.id.admin:
               intent = new Intent("android.intent.action.admin");
                startActivity(intent);
                break;

            case R.id.signup:
                intent = new Intent("android.intent.action.signupform");
                startActivity(intent);
                break;

            case R.id.request:
                intent = new Intent("android.intent.action.requestform");
                startActivity(intent);
                break;

        }

    }

}

