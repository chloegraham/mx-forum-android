package com.example.joshua.mx_forum_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.joshua.mx_forum_app.R;
public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // set click listener to clear the default text when user clicks on the text field
        EditText fname = (EditText)findViewById(R.id.firstName);
        EditTextClickListener listener = new EditTextClickListener(fname);
        fname.setOnClickListener(listener);

        //can do this with other fields if desired...will leave for now

//        text.setOnClickListener(this);
//        text = (EditText)findViewById(R.id.lastName);
//        text.setOnClickListener(this);
//        text = (EditText)findViewById(R.id.email);
//        text.setOnClickListener(this);
//        text = (EditText)findViewById(R.id.password);
//        text.setOnClickListener(this);
//        text = (EditText)findViewById(R.id.passwordConfirmation);
//        text.setOnClickListener(this);

        //get intent that started this activity
        Intent intent = getIntent();

    }

    /** Sends user data to API to attempt to sign up the user.
     *  API will validate whether the user can be signed up or not and return
     *  the result.
     *
     * @param view
     */
    public void signUpUser(View view) {
        String firstName = ((EditText)findViewById(R.id.firstName)).getText().toString();
        String lastName = ((EditText)findViewById(R.id.lastName)).getText().toString();
        String email = ((EditText)findViewById(R.id.email)).getText().toString();
        String password = ((EditText)findViewById(R.id.password)).getText().toString();
        String passwordConfirmation = ((EditText)findViewById(R.id.passwordConfirmation)).getText().toString();

        String details = firstName+" "+lastName+" "+email+" "+password+" "+passwordConfirmation;

        Log.d("SignUpActivity", details);

        //send data off to API
    }

}
