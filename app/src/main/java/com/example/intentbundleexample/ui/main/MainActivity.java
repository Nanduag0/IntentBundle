package com.example.intentbundleexample.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.intentbundleexample.ui.home.HomeActivity;
import com.example.intentbundleexample.R;
import com.example.intentbundleexample.utils.Constants;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {


    TextInputEditText etUserName;
    Button btnNextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        clickHandler();



    }

    //Initializing the views
    private void initViews() {

        etUserName = findViewById(R.id.et_username);
        btnNextActivity = findViewById(R.id.btn_next);

    }

    //Method to handle the button click
    private void clickHandler(){

        btnNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = etUserName.getText().toString();

                //Do a check whether a username is given or not
                if (!username.isEmpty()){
                    goToHomeActivity(username);
                }else{
                    Toast.makeText(MainActivity.this, "Enter Some Text", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    //Method for intent
    private void goToHomeActivity(String username) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra(Constants.MAIN_INTENT_KEY,username);
        startActivity(intent);
    }

}
