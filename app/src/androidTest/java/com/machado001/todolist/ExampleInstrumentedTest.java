package com.machado001.todolist;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import android.os.Bundle;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.machado001.todolist.presentation.MainActivity;
import com.machado001.todolist.presentation.MainFragment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private MainFragment frag;

    @Rule
    public final ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);
    @Before
    public void setup(){
        frag = MainFragment.newInstance("title one");
        ActivityScenario.launchActivityForResult(MainActivity.class);
    }
    @Test
    public void newInstance_Should_create_different_instances() {
        // Context of the app under test.
        MainFragment frag2 = MainFragment.newInstance("title two");
        assertNotEquals(frag2,frag);
    }

    @Test
    public void bundle_should_not_be_null_when_instantiating_fragment_directly() {
        Bundle bundle = frag.getArguments();
        assertNotNull(bundle);
    }
}