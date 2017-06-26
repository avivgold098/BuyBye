package com.example.goldav.buybye;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.example.goldav.buybye.model.Item;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends Activity implements Entry_ScreenFragment.OnFragmentInteractionListener,
        SignUpFragment.OnFragmentInteractionListener, AddItemFragment.OnFragmentInteractionListener {
    public static  String CurrentFragment="";
    public static FirebaseAuth mAuth= FirebaseAuth.getInstance();
    FragmentTransaction tran;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String str = "aviv";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tran =  getFragmentManager().beginTransaction();
        Entry_ScreenFragment listFragment = Entry_ScreenFragment.newInstance();
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
        SignUpFragment listFragment = SignUpFragment.newInstance();
         tran = getFragmentManager().beginTransaction() ;
        tran.replace(R.id.main_container,listFragment);
        tran.addToBackStack("");

        tran.commit();


    }



   @Override
    public void onFragmentInteraction() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public void onFragmentInteraction(Item item) {

    }
}
