package com.example.goldav.buybye;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


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
        View view =inflater.inflate(R.layout.fragment_entry__screen, container, false);
        Button LogIn=(Button) view.findViewById(R.id.LogIn);
        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAlert al = new MyAlert();
                al.Message="ag is the king";
                al.show(getFragmentManager(),"tag");
               mListener.onFragmentInteraction(true);
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
