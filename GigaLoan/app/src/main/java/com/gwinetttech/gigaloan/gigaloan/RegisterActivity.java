package com.gwinetttech.gigaloan.gigaloan;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.gwinetttech.gigaloan.gigaloan.util.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class RegisterActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //create the variables
        final EditText etFirstName = (EditText) findViewById(R.id.etFirstName);
        //final EditText etLastName = (EditText) findViewById(R.id.etLastName);
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final EditText etVerifyPassword = (EditText) findViewById(R.id.etVerifyPassword);

        final Button bRegister = (Button) findViewById(R.id.bRegister);

        final Switch sClient= (Switch) findViewById(R.id.sClient);
        final Switch sStudent= (Switch) findViewById(R.id.sStudent);
        sClient.setChecked(true);
        final TextView tvCancel = (TextView) findViewById(R.id.tvCancel);
       tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoginPage();
            }
        });

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String userName = etFirstName.getText().toString();
                final String password = etPassword.getText().toString();
                final String email = etEmail.getText().toString();
                final Date birthDate=new Date();

                if (!Utils.isValidEmail(email)) {
                    etEmail.setError("Invalid Email");
                }


                if (!Utils.isValidPassword(password)) {
                    etPassword.setError("Invalid Password");
                }


                String sex = "";
     //          if (rbMale.isSelected()) {
    /*                 sex = "M";
                } else {
                    sex = "F";
                }

         */       Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);



                            boolean success = jsonResponse.getBoolean("success");
                            if(success){

                                AlertDialog.Builder builder=new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Registration Success. Please login to continue")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();

                                showLoginPage();
                            }else{
                                AlertDialog.Builder builder=new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Registration Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                };

                RegisterRequest regiserRequest = new RegisterRequest(userName, password, email, sex, birthDate, responseListener);
  //              RequestQueue queue= Volley.newRequestQueue(RegisterActivity.this);
   //             queue.add(regiserRequest);

                    /* remove this code after fixing the service and uncomment the two lines above*/


                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);

                loginIntent.putExtra("userName",userName);
                loginIntent.putExtra("email",email);

                RegisterActivity.this.startActivity(loginIntent);

                  /* end - remove this code */

            }

        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void showLoginPage(){
        Intent registerIntent = new Intent(RegisterActivity.this, LoginActivity.class);
        RegisterActivity.this.startActivity(registerIntent);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Register Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.gwinetttech.gigaloan.gigaloan/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Register Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.gwinetttech.gigaloan.gigaloan/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
