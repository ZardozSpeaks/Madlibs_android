package com.example.guest.madlibs;



import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;


public class PlayActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<PlayActivity> activityTestRule =
            new ActivityTestRule<>(PlayActivity.class);

    @Test
    public void validateEditText() {
        onView(withId(R.id.editTextNoun)).perform(typeText("Gerbil"))
                .check(matches(withText("Gerbil")));
    }

    @Test
    public void nounIsSentToResultsActivity() {
        String noun = "hamster";
        onView(withId(R.id.editTextNoun)).perform(typeText(noun), ViewActions.closeSoftKeyboard());
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withId(R.id.viewResultsButton)).perform(click());
        onView(withId(R.id.resultsTextView)).check(matches
                (withText(containsString("Johnifer were going to buy some hamster"))));

    }
}
