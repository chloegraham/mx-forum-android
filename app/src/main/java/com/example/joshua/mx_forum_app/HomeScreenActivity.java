package com.example.joshua.mx_forum_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.joshua.mx_forum_app.R;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }
    /**
     * Action listener for the sign up button on home screen
     *
     * @param view
     */
    public void takeUserToSignUpActivity(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
//        EditText editText = (EditText) findViewById(R.id.);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
    }

    /**
     * Action listener for the login button on home screen
     *
     * @param view
     */
    public void takeUserToLoginActivity(View view) {
       Intent intent = new Intent(this, LogInActivity.class);
//        EditText editText = (EditText) findViewById(R.id.edit_message);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
