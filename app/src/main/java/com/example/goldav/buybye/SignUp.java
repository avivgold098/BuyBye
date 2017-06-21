package com.example.goldav.buybye;

import android.app.Activity;
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

import com.example.goldav.buybye.model.Model;
import com.example.goldav.buybye.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SignUp.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SignUp#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignUp extends Fragment {

    private OnFragmentInteractionListener mListener;
    User user = new User();
    public SignUp() {
    }


    public static SignUp newInstance() {
        SignUp fragment = new SignUp();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       final View v =inflater.inflate(R.layout.fragment_sign_up, container, false);
       Button send= (Button) v.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText email = (EditText) v.findViewById(R.id.SignUpEmail);
                EditText pass = (EditText) v.findViewById(R.id.SignUpPass);
                EditText firstName = (EditText) v.findViewById(R.id.SignUpFirstName);
                EditText lastName = (EditText) v.findViewById(R.id.SignUpLastName);
                EditText phone = (EditText) v.findViewById(R.id.SignUpPhone);
                EditText userName = (EditText) v.findViewById(R.id.SignUpUserName);
                Log.d("tag",firstName.getText().toString());
                Log.d("tag",lastName.getText().toString());
                Log.d("tag",pass.getText().toString());
                Log.d("tag",email.getText().toString());
                Log.d("tag",phone.getText().toString());

                Log.d("tag",""+(CheckEditTextsEmpty(new EditText[]{email, firstName, pass, phone, lastName})));
                if(CheckEditTextsEmpty(new EditText[]{email, firstName, pass, phone, lastName,userName}))
                {
                    MyAlert al = new MyAlert();
                    al.Message="You cannot leavy any cell empty";
                    al.show(getFragmentManager(),"tag");

                }
                else if(!Entry_Screen.onlyLettersAndNumbers(userName.getText().toString()))
                    userName.setError("only letters and numbers");
                else
                {
                    user.setUser(firstName.getText().toString(),lastName.getText().toString(),
                            email.getText().toString(),phone.getText().toString(),userName.getText().toString());
                    MainActivity.mAuth.createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                            .addOnCompleteListener(getActivity() , new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d("TAG", "createUserWithEmail:success");
                                        MyAlert my = new MyAlert();
                                        my.Message="work";
                                        my.show(getFragmentManager(),"");
                                        //FirebaseUser auth = MainActivity.mAuth.getCurrentUser();
                                        Model model = Model.instace;
                                        model.addUser(user);



                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w("TAG", "createUserWithEmail:failure", task.getException());
                                        MyAlert my = new MyAlert();
                                        my.Message="no work";
                                        my.show(getFragmentManager(),"");

                                    }

                                }
                            });

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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public static boolean CheckEditTextsEmpty(EditText [] texts)
    {
        for (EditText text :texts) {
            if (text!=null)
            {
                if(text.getText().toString().equals(""))
                    return true;
            }
            else
                return true;

        }
        return false;
    }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction();
    }
}

