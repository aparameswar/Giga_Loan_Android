package com.gwinetttech.gigaloan.gigaloan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gwinetttech.gigaloan.gigaloan.util.Utils;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //create the variables
        final EditText etEmail=(EditText)findViewById(R.id.etEmail);
        final EditText etPassword=(EditText)findViewById(R.id.etPassword);
        final Button bSignin=(Button)findViewById(R.id.bSignin);
        final Button bRegister=(Button)findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        bSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check valid data

                if( Utils.isValidString(etEmail.getText().toString()) && Utils.isValidPassword(etPassword.getText().toString())) {

                    Intent thisIntent = getIntent();//get the current intent
                    Intent profileIntent = new Intent(LoginActivity.this, ProfileActivity.class);

                    //check if the login is come after a profile page
                    final String email = thisIntent.getStringExtra("email");
                    if (Utils.isValidString(email)) {
                        profileIntent.putExtra("email", email);
                    }
                    profileIntent.putExtra("name", etEmail.getText().toString());
                    LoginActivity.this.startActivity(profileIntent);
                }
            }
        });


    }




}
