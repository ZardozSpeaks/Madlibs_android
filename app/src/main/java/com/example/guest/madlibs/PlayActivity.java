package com.example.guest.madlibs;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class PlayActivity extends AppCompatActivity {
    private Button mViewResults;
    private EditText mEditTextNoun;
    private EditText mEditTextAdj;
    private EditText mEditTextVerb;

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    public void setupUI(View view) {

        //Set up touch listener for non-text box views to hide keyboard.//
        if(!(view instanceof EditText)) {

            view.setOnTouchListener(new View.OnTouchListener() {

                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(PlayActivity.this);
                    return false;
                }

            });
        }

        //If a layout container, iterate over children and seed recursion.//
        if (view instanceof ViewGroup) {

            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {

                View innerView = ((ViewGroup) view).getChildAt(i);

                setupUI(innerView);
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        setupUI(findViewById(R.id.parentPlayActivity));

        mEditTextNoun = (EditText) findViewById(R.id.editTextNoun);
        mEditTextAdj = (EditText) findViewById(R.id.editTextAdj);
        mEditTextVerb = (EditText) findViewById(R.id.editTextVerb);
        mViewResults = (Button) findViewById(R.id.viewResultsButton);
        mViewResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noun = mEditTextNoun.getText().toString();
                String adj = mEditTextAdj.getText().toString();
                String verb = mEditTextVerb.getText().toString();
                Intent intent = new Intent(PlayActivity.this, ResultsActivity.class);
                intent.putExtra("noun", noun);
                intent.putExtra("adj", adj);
                intent.putExtra("verb", verb);
                startActivity(intent);
            }
        });
    }
}
