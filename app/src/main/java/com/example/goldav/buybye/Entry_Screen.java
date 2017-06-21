package com.example.goldav.buybye;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

import static android.content.ContentValues.TAG;
import static java.lang.Character.isLetter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Entry_Screen.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Entry_Screen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Entry_Screen extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    private OnFragmentInteractionListener mListener;

    public Entry_Screen() {
    }


    // TODO: Rename and change types and number of parameters
    public static Entry_Screen newInstance() {
        Entry_Screen fragment = new Entry_Screen();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainActivity.CurrentFragment="Entry";
        final View view =inflater.inflate(R.layout.fragment_entry__screen, container, false);
        Button LogIn=(Button) view.findViewById(R.id.LogIn);




        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText Email = (EditText) view.findViewById(R.id.SignInEmail);
                EditText pass = (EditText) view.findViewById(R.id.SignInPass);
                FirebaseUser currentUser;
                MainActivity.mAuth.createUserWithEmailAndPassword(Email.getText().toString(), pass.getText().toString())
                        .addOnCompleteListener(getActivity() , new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("TAG", "createUserWithEmail:success");
                                    MyAlert my = new MyAlert();
                                    my.Message="work";
                                    my.show(getFragmentManager(),"");
                                    FirebaseUser user = MainActivity.mAuth.getCurrentUser();
                                    mListener.onFragmentInteraction(true);


                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("TAG", "createUserWithEmail:failure", task.getException());
                                    MyAlert my = new MyAlert();
                                    my.Message="no work";
                                    my.show(getFragmentManager(),"");

                                }

                                // ...
                            }
                        });

            }
        });
        Button SignUp=(Button) view.findViewById(R.id.SignUp);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.SignUp();
            }
        });

        return view;
    }


    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(boolean ok);
        void SignUp();
    }
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
    public static boolean isNumber(char ch)
    {
        if(((ch>'a'&&ch<'z'))||(ch<'Z'&&ch>'A'))
            return true;
        return false;
    }
}
