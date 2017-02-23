package com.example.joshua.mx_forum_app;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class SignUpActivity extends AppCompatActivity {

    private static final String url = "http://10.0.2.2:3000/api/users/create";

        @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sign_up);

            // set click listener to clear the default text when user clicks on the text field
            EditText fname = (EditText) findViewById(R.id.firstName);
            EditTextClickListener listener = new EditTextClickListener(fname);
            fname.setOnClickListener(listener);

            EditText lname = (EditText) findViewById(R.id.firstName);
            EditTextClickListener listener1 = new EditTextClickListener(lname);
            lname.setOnClickListener(listener1);

            EditText email = (EditText) findViewById(R.id.firstName);
            EditTextClickListener listener2 = new EditTextClickListener(email);
            email.setOnClickListener(listener2);

            EditText pword = (EditText) findViewById(R.id.firstName);
            EditTextClickListener listener3 = new EditTextClickListener(pword);
            pword.setOnClickListener(listener3);

            EditText confirmedpword = (EditText) findViewById(R.id.firstName);
            EditTextClickListener listener4 = new EditTextClickListener(confirmedpword);
            confirmedpword.setOnClickListener(listener4);

        }

//        //can do this with other fields if desired...will leave for now
//
////        text.setOnClickListener(this);
////        text = (EditText)findViewById(R.id.lastName);
////        text.setOnClickListener(this);
////        text = (EditText)findViewById(R.id.email);
////        text.setOnClickListener(this);
////        text = (EditText)findViewById(R.id.password);
////        text.setOnClickListener(this);
////        text = (EditText)findViewById(R.id.passwordConfirmation);
////        text.setOnClickListener(this);
//
//        //get intent that started this activity
//        Intent intent = getIntent();
//
//    }
//
//    /** Sends user data to API to attempt to sign up the user.
//     *  API will validate whether the user can be signed up or not and return
//     *  the result.
//     *
//     * @param view
//     */
    public void signUpUser(View view) {
    SignUpActivity.PostUserSignUp userSignUp = new SignUpActivity.PostUserSignUp(SignUpActivity.this);
        //userSignUp.setMessageLoading("Loading tasks...");
        //userSignUp.execute(url);
        String firstName = ((EditText) findViewById(R.id.firstName)).getText().toString();
        String lastName = ((EditText) findViewById(R.id.lastName)).getText().toString();
        String email = ((EditText) findViewById(R.id.email)).getText().toString();
        String password = ((EditText) findViewById(R.id.password)).getText().toString();
        String passwordConfirmation = ((EditText) findViewById(R.id.passwordConfirmation)).getText().toString();
        String[] args = new String[] {firstName,lastName,email,password,passwordConfirmation};
        userSignUp.execute(args);
    }

    private class PostUserSignUp extends AsyncTask<String, Void, String>{
        public PostUserSignUp(Context context) {

             }

        @Override
        protected String doInBackground(String... params) {

            //String details = firstName + " " + lastName + " " + email + " " + password + " " + passwordConfirmation;
            String firstName = params[0];
            String lastName = params[1];
            String email = params[2];
            String password = params[3];
            String passwordConfirmation = params[4];
            // Log.d("SignUpActivity", details);

            try {
                URL url = new URL("http://10.0.2.2:3000/api/users/create");
                HttpURLConnection urlConn = null;
                DataOutputStream printout;
                DataInputStream input;
                try {
                    urlConn = (HttpURLConnection) url.openConnection();
                    if (urlConn != null) {
                        urlConn.setDoInput(true);
                        urlConn.setDoOutput(true);
                        urlConn.setUseCaches(false);
                        urlConn.setRequestMethod("POST");
                        urlConn.setRequestProperty("Content-Type", "application/json");
                        urlConn.setRequestProperty("Accept", "application/json");
                        urlConn.connect();
                        //Create JSONObject here
                        JSONObject jsonParam = new JSONObject();
                        jsonParam.put("first_name", firstName);
                        jsonParam.put("last_name", lastName);
                        jsonParam.put("email", email);
                        jsonParam.put("password", password);
                        jsonParam.put("password_confirmation", passwordConfirmation);

                        //send data off to API
                        printout = new DataOutputStream(urlConn.getOutputStream());
                        printout.writeBytes(URLEncoder.encode(jsonParam.toString(), "UTF-8"));
                        printout.flush();
                        printout.close();
                        urlConn.disconnect();
                        return "success";
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    urlConn.disconnect();
                }
            } catch (MalformedURLException e) {

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "fail";
        }
    }

}