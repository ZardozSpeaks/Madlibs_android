package com.example.guest.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PlayActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mViewResults;
    private EditText mEditTextNoun;
    private EditText mEditTextAdj;
    private EditText mEditTextVerb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

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
                Log.d(TAG, noun);
                Log.d(TAG, adj);
                Log.d(TAG, verb);
                Intent intent = new Intent(PlayActivity.this, ResultsActivity.class);
                startActivity(intent);
            }
        });
    }
}
