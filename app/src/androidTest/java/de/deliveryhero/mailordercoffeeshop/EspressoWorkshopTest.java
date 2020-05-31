package de.deliveryhero.mailordercoffeeshop;

import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EspressoWorkshopTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule=new ActivityTestRule<>(MainActivity.class);


    @Test
    public void orderCoffee(){

        // Check if view with the text 'Create a custom order...' is shown
        onView(withText("Create a custom order...")).check(matches(isDisplayed()));
        onView(withId(R.id.close_button)).perform(click());

        onView(withText("Customize your order")).check(matches(isDisplayed()));
        onView(withId(R.id.more_espresso)).perform(click());
        onView(withId(R.id.more_espresso)).perform(click());
        //Validating if 2 Espresso are selected
        onView(withId(R.id.espresso_shot_counter)).check(matches(withText("2")));

        //Clicking chocolate and making sure its checked
        onView(withId(R.id.chocolate)).perform(click()).check(matches(isChecked()));
        onView(withId(R.id.milk_type)).perform(click());

        onView(withText("Low fat")).perform(click());
        //Selecting Steamed and making sure its checked
        onView(withText("Steamed")).perform(click()).check(matches(isChecked()));
        onView(withId(R.id.review_order_button)).perform(scrollTo(),click());
        //Validating that Order Review Page has order present
        onView(withId(R.id.beverage_detail_volume_text)).check(matches(withText("120 ML.")));
        onView(withId(R.id.beverage_detail_ingredients)).check(matches(withSubstring("Ingredients")));

        onView(withId(R.id.name_text_box)).perform(click(),typeText("Neeraj"),closeSoftKeyboard());
        onView(withId(R.id.email_text_box)).perform(click(),typeText("neeraj.bakhtani@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.custom_order_name_box)).perform(click(),typeText("Neeraj's Order"),closeSoftKeyboard());
        onView(withId(R.id.mail_order_button)).perform(click());

    }

}
