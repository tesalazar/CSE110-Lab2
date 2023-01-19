package edu.ucsd.cse110.lab2;

import static org.junit.Assert.assertEquals;

import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {
    @Test
    public void test_one_plus_one_equals_two(){
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);

        scenario.onActivity(activity -> {

            Button buttonOne = activity.findViewById(R.id.btn_one);
            Button buttonPlus = activity.findViewById(R.id.btn_plus);
            Button buttonEquals = activity.findViewById(R.id.btn_equals);
            buttonOne.performClick();
            buttonPlus.performClick();
            buttonOne.performClick();
            buttonEquals.performClick();
            TextView displayView = activity.findViewById(R.id.display);
            assertEquals("2", displayView.getText());
        });

    }

}
