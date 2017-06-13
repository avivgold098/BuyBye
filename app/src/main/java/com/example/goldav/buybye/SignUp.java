package com.example.goldav.buybye;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.goldav.buybye.model.User;


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
        View view =inflater.inflate(R.layout.fragment_sign_up, container, false);
       Button send= (Button) view.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText email = (EditText) view.findViewById(R.id.SignInEmail);
                EditText pass = (EditText) view.findViewById(R.id.SignInPass);
                EditText firstName = (EditText) view.findViewById(R.id.SignUpFirstName);
                EditText lastName = (EditText) view.findViewById(R.id.SignUpLastName);
                EditText phone = (EditText) view.findViewById(R.id.SignUpPhone);
                Log.d("tag",""+(CheckEditTextsEmpty(new EditText[]{email, firstName, pass, phone, lastName})));
                if(CheckEditTextsEmpty(new EditText[]{email, firstName, pass, phone, lastName}))
                {
                    MyAlert al = new MyAlert();
                    al.Message="You cannot leavy any cell empty";
                    al.show(getFragmentManager(),"tag");
                }
                User user = new User();
                user.setUser(firstName.getText().toString(),lastName.getText().toString(),pass.getText().toString(),
                        email.getText().toString(),phone.getText().toString());
                //Todo send data to the server
                mListener.onFragmentInteraction();

            }
        });

        
        return view;
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

