package com.gwinetttech.gigaloan.gigaloan.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ASHA on 4/13/2016.
 */
public class Utils {

    // validating email id
    public static  boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // validating password with retype password
    public static  boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 4) {
            return true;
        }
        return false;
    }

    // validating string
    public static  boolean isValidString(String value) {
        if(value!=null && !value.isEmpty()){
            return true;
        }
        return false;
    }

}
