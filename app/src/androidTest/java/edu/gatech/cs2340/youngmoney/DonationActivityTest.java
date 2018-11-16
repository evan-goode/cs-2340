/**
 * @author: John Thompson
 * @decription: Tests LoginActivity
 */
package edu.gatech.cs2340.youngmoney;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import edu.gatech.cs2340.youngmoney.activity.HomeActivity;
import edu.gatech.cs2340.youngmoney.activity.NewDonationActivity;


public class DonationActivityTest {

    @Rule
    public ActivityTestRule<NewDonationActivity> mActivityRule = new ActivityTestRule<>(NewDonationActivity.class);

    /**
     * Tests mainly the newDonation method and AddDonationTask of DonationActivity
     */
    @Test
    public void checkAddDonation() {

        //Test when both fields are empty
        onView(withId(R.id.create)).perform(click());
        onView(withId(R.id.item)).check(matches(hasErrorText("This field is required")));

        onView(withId(R.id.item)).perform(typeText("Dog"), closeSoftKeyboard());
        onView(withId(R.id.user)).perform(typeText("Big Man"), closeSoftKeyboard());
        onView(withId(R.id.date)).perform(typeText("11/9/18"), closeSoftKeyboard());
        onView(withId(R.id.fulldesc)).perform(typeText("Super nice dog"), closeSoftKeyboard());
        onView(withId(R.id.value)).perform(typeText("$12"), closeSoftKeyboard());
        onView(withId(R.id.category)).perform(typeText("Animal"), closeSoftKeyboard());

        //Test when everything correct
        onView(withId(R.id.create)).perform(click());
    }
}