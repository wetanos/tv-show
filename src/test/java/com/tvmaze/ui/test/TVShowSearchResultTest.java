package com.tvmaze.ui.test;

import com.tvmaze.ui.steps.SearchResultStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TVShowSearchResultTest extends AbstractTest {

    @Test
    public void testSearchResultContainsTVShow() {
        String tvShowPartOfName = "Family";
        SearchResultStep searchResultStep = new SearchResultStep().openSearchResultByRequest(tvShowPartOfName);
        Assert.assertTrue(searchResultStep.isSearchResultListContainsTVShow(tvShowPartOfName));
    }

    @Test
    public void testSearchResultMessageWithInvalidRequest() {
        String request = "rgregrgr";
        SearchResultStep searchResultStep = new SearchResultStep().openSearchResultByRequest(request);
        Assert.assertTrue(searchResultStep.isSearchResultContainsExpectedMessage());
    }
}
