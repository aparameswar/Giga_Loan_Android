package com.gwinetttech.gigaloan.gigaloan;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;
import java.util.Map;
import java.util.HashMap;

import java.util.Date;

/**
 * Created by ASHA on 4/11/2016.
 */
public class RegisterRequest extends StringRequest {

    //TODO UPDATE THE URL HERE
    private static final String REGISTER_REQUEST_URL="http://jumpcreek.com/gtc_spring/api/user/signup";
    private Map<String, String> params;

public RegisterRequest(String userName,String password,  String email,String sex, Date birthDate,Listener<String> listener){


    super(Request.Method.POST,REGISTER_REQUEST_URL,listener,null);
    params=new HashMap<>();
    params.put("name",userName);
    params.put("password",userName);
    params.put("sex",sex);
    params.put("email",email);
    params.put("birthDate",birthDate.toString());

    /* create a json like this and send to server. Need a service.

    {

  "name": "string",
  "password": "string",
  "email": "string",
  "birthdate": "string",
  "password": "string",
  }

     */
}

}

