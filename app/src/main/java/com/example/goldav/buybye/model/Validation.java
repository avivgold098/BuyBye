package com.example.goldav.buybye.model;

import android.util.Log;
import android.widget.EditText;

import static java.lang.Character.isLetter;

/**
 * Created by Aviv Gold on 6/26/2017.
 */

public class Validation {
    public static boolean onlyLettersAndNumbers(String str)
    {
        for (int i=0;i<str.length();i++)
        {
            Log.d("tag",""+str.charAt(i));
            if(!(isLetter(str.charAt(i))||(Character.isDigit(str.charAt(i)))))
                return false;

        }
        return true;
    }
    public static boolean CheckEditTextsEmpty(EditText[] texts)
    {
        boolean check = false;
        for (EditText text :texts) {
            if (text!=null)
            {
                if(text.getText().toString().equals("")) {
                    check = true;
                    text.setError("please fill");
                }
            }
            else {
                check = true;
                text.setError("please fill");
            }

        }
        return check;
    }
    public static boolean validateEamil(String email)
    {
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(EMAIL_REGEX);
    }
}
