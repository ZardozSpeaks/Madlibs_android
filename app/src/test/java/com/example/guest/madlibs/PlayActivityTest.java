package com.example.guest.madlibs;


import android.content.Intent;
import android.os.Build;
import android.widget.EditText;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.Assert.assertTrue;
import android.net.http.AndroidHttpClient;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class PlayActivityTest {
    private PlayActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(PlayActivity.class);

    }

    @Test
    public void validateEditViewContent() {
        EditText editTextNoun = (EditText) activity.findViewById(R.id.editTextNoun);
        assertTrue("noun".equals(editTextNoun.getHint().toString()));
    }

    @Test
    public void resultsActivityStarted() {
        activity.findViewById(R.id.viewResultsButton).performClick();
        Intent expectedIntent = new Intent(activity, ResultsActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
