package com.tvmaze.ui.test;

import com.tvmaze.ui.steps.TVShowCalendarStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TVShowCalendarTest extends AbstractTest {

    @Test
    public void testCalendarContainsShowOnDate() {
        String date = "25 May";
        String tvShowName = "The Flash";
        TVShowCalendarStep tvShowCalendarStep = new TVShowCalendarStep().openTVSHowCalendarOnDate(date);
        Assert.assertTrue(tvShowCalendarStep.isCalendarOnDateContainsTVShow(tvShowName));
    }
}
