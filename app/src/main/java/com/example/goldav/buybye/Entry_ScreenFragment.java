package com.example.goldav.buybye;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import com.example.goldav.buybye.model.Validation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

import static java.lang.Character.isLetter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Entry_ScreenFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Entry_ScreenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Entry_ScreenFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    private OnFragmentInteractionListener mListener;

    public Entry_ScreenFragment() {
    }


    // TODO: Rename and change types and number of parameters
    public static Entry_ScreenFragment newInstance() {
        Entry_ScreenFragment fragment = new Entry_ScreenFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       MainActivity.CurrentFragment="Entry";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view =inflater.inflate(R.layout.fragment_entry__screen, container, false);
        Button LogIn=(Button) view.findViewById(R.id.LogIn);




        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText Email = (EditText) view.findViewById(R.id.SignInEmail);
                EditText pass = (EditText) view.findViewById(R.id.SignInPass);
                if(!Validation.CheckEditTextsEmpty(new EditText[]{Email,pass})) {
                    FirebaseUser currentUser;
                    MainActivity.mAuth.createUserWithEmailAndPassword(Email.getText().toString(), pass.getText().toString())
                            .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d("TAG", "createUserWithEmail:success");
                                        MyAlert my = new MyAlert();
                                        my.Message = "work";
                                        my.show(getFragmentManager(), "");
                                        FirebaseUser user = MainActivity.mAuth.getCurrentUser();
                                        mListener.onFragmentInteraction(true);


                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w("TAG", "createUserWithEmail:failure", task.getException());
                                        MyAlert my = new MyAlert();
                                        my.Message = "no work";
                                        my.show(getFragmentManager(), "");

                                    }
                                }


                                // ...

                            });
                }

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

}
