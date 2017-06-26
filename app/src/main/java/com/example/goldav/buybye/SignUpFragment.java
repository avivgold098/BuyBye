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

import com.example.goldav.buybye.model.Model;
import com.example.goldav.buybye.model.User;
import com.example.goldav.buybye.model.Validation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SignUpFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SignUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignUpFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    User user = new User();
    public SignUpFragment() {
    }


    public static SignUpFragment newInstance() {
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        MainActivity.CurrentFragment="SignUp";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       final View v =inflater.inflate(R.layout.fragment_sign_up, container, false);
       Button send= (Button) v.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText email = (EditText) v.findViewById(R.id.SignUpEmail);
                EditText pass = (EditText) v.findViewById(R.id.SignUpPass);
                final EditText firstName = (EditText) v.findViewById(R.id.SignUpFirstName);
                final EditText lastName = (EditText) v.findViewById(R.id.SignUpLastName);
                final EditText phone = (EditText) v.findViewById(R.id.SignUpPhone);
                Log.d("tag",""+(Validation.CheckEditTextsEmpty(new EditText[]{email, firstName, pass, phone, lastName})));
                if(!Validation.CheckEditTextsEmpty(new EditText[]{email, firstName, pass, phone, lastName}))
                {
                    if(Validation.validateEamil(email.getText().toString())) {
                        MainActivity.mAuth.createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            user.setUser(firstName.getText().toString(), lastName.getText().toString(),
                                                    email.getText().toString(), phone.getText().toString());
                                            // Sign in success, update UI with the signed-in user's information
                                            String []newEmail=email.getText().toString().split("@");
                                            String Email = newEmail[0]+newEmail[1];
                                            Log.d("TAG", "createUserWithEmail:success");
                                            MyAlert my = new MyAlert();
                                            my.Message = "success sing  up";
                                            my.show(getFragmentManager(), "");
                                            //FirebaseUser auth = MainActivity.mAuth.getCurrentUser();
                                            Model model = Model.instace;
                                            model.addUser(user);


                                        } else {
                                            // If sign in fails, display a message to the user.
                                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
                                            MyAlert my = new MyAlert();
                                            my.Message = "no work";
                                            my.show(getFragmentManager(), "");

                                        }

                                    }
                                });
                    }
                    else
                    {
                        email.setError("is current email format");
                    }

                }



            }
        });

        
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event


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
        void onFragmentInteraction();
    }
}

