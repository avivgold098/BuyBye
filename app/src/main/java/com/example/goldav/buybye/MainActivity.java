package com.example.goldav.buybye;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.example.goldav.buybye.model.User;

public class MainActivity extends Activity implements Entry_Screen.OnFragmentInteractionListener, SignUp.OnFragmentInteractionListener {
    public static  String CurrentFragment="";
    FragmentTransaction tran;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tran =  getFragmentManager().beginTransaction();
        Entry_Screen listFragment = Entry_Screen.newInstance();
        tran.add(R.id.main_container, listFragment);
        tran.commit();
    }

    @Override
    //log in button
    public void onFragmentInteraction(boolean ok) {
        Log.d("tag",""+ok);
    }

    @Override
    public void SignUp() {
        SignUp listFragment = SignUp.newInstance();
         tran = getFragmentManager().beginTransaction() ;
        tran.replace(R.id.main_container,listFragment);
        tran.addToBackStack("");

        tran.commit();


    }



   @Override
    public void onFragmentInteraction() {

    }
}
