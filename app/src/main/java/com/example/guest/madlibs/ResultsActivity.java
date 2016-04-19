package com.example.guest.madlibs;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    private TextView mResultsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mResultsTextView = (TextView) findViewById(R.id.resultsTextView);

        Intent intent = getIntent();
        String noun = intent.getStringExtra("noun");
        String adj = intent.getStringExtra("adj");
        String verb = intent.getStringExtra("verb");

        mResultsTextView.setText("Herbert, Bartleby, and Johnifer were going to buy some " + noun + " at the " + adj + " store. They were hoping to " + verb + " their cheese. Oh wow, said Bartleby. What a quirky situation this is.");
    }
}
