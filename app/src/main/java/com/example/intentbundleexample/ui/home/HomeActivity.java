package com.example.intentbundleexample.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.intentbundleexample.R;
import com.example.intentbundleexample.ui.home.fragments.TestFragment;
import com.example.intentbundleexample.utils.Constants;

public class HomeActivity extends AppCompatActivity {

    //Just an empty activity. The test Fragment is placed over it.
    // Username from the MainActivity is retrieved via a intent and sent to the fragment by using a bundle.



    private static final String TAG = "HomeActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        String value = getIntent().getExtras().getString(Constants.MAIN_INTENT_KEY);
        Log.d(TAG, "onCreate:  " + value);

        initializeFragment(value);

    }

    private void initializeFragment(String username) {

        //Using the bundle to send the username
        Bundle bundle = new Bundle();
        bundle.putString(Constants.HOME_BUNDLE_KEY,username);



        //initializing the fragment and setting the bundle
        TestFragment testFragment = new TestFragment();
        testFragment.setArguments(bundle);


        //Replacing the fragment
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,testFragment);
        fragmentTransaction.commit();


    }
}
