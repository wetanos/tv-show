package com.tvmaze.ui.test;

import com.tvmaze.ui.driver.DriverSingleton;
import com.tvmaze.ui.steps.AuthorizeStep;
import com.tvmaze.ui.utils.TestListener;
import com.tvmaze.ui.utils.UserCreator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class AbstractTest {

    @BeforeTest
    public void logIn() {
        AuthorizeStep.logIn(UserCreator.createDefaultUser());
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
