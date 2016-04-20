package com.gwinetttech.gigaloan.gigaloan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gwinetttech.gigaloan.gigaloan.util.Utils;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        //create the variables
        final TextView etName=(TextView)findViewById(R.id.etName);
        final TextView etEmail=(TextView)findViewById(R.id.etEmail);


        Intent thisIntent = getIntent();//get the current intent
         //check if the login is come after a profile page
        final String email = thisIntent.getStringExtra("email");
        final String name = thisIntent.getStringExtra("name");

        etName.setText(name);
        etEmail.setText(email);

    }
}
