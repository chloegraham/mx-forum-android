package com.example.joshua.mx_forum_app;

import android.view.View;
import android.widget.EditText;

/**
 * Created by Joshua on 22/02/17.
 */

public class EditTextClickListener implements View.OnClickListener{

    EditText text;

    public EditTextClickListener(EditText text){
        this.text = text;
    }
    @Override
    public void onClick(View v) {
    text.getText().clear();
    }
}
