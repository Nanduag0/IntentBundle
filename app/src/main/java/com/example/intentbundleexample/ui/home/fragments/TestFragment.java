package com.example.intentbundleexample.ui.home.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.intentbundleexample.R;
import com.example.intentbundleexample.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends Fragment {


    TextView userName;

    public TestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_test, container, false);

        //Initializing the textview
        userName = view.findViewById(R.id.user_name);


        //Getting the stored string through the bundle
        String string = getArguments().getString(Constants.HOME_BUNDLE_KEY);

        //Setting the string in the textView
        userName.setText(string);


        return view;
    }

}
