package com.tvmaze.ui.steps;

import com.tvmaze.ui.entity.TVShow;
import com.tvmaze.ui.pages.AuthorizedHomePage;
import com.tvmaze.ui.pages.TVShowCalendarPage;
import com.tvmaze.ui.utils.DateConverter;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TVShowCalendarStep extends TVShowCalendarPage {
    List<TVShow> tvShowList;
    private String month;
    private String date;

    @Step("Calendar date:  {0}")
    public TVShowCalendarStep openTVSHowCalendarOnDate(String date) {
        logger.info("Date: " + date);
        String[] split = date.split(" ");
        this.date = split[0];
        this.month = split[1];
        new AuthorizedHomePage().clickCalendarButton()
                .selectShowCalendarFilter()
                .chooseDate(month);
        return this;
    }

    @Step(" Create ShowList by date")
    @Attachment
    public List<TVShow> createShowList() {
        String ShowLocator = String.format(patternShowLocator, DateConverter.monthToInt(month), date);
        List<WebElement> tvShowElements = driver.findElements(By.xpath(ShowLocator));
        tvShowList = new ArrayList<>();
        for (WebElement showElement : tvShowElements) {
            String tvShowName = showElement.findElement(By.xpath("./div/span/a")).getText();
            String episodeName = showElement.findElement(By.xpath("./div/a")).getAttribute("title");
            tvShowList.add(new TVShow(tvShowName, episodeName));
        }
        logger.info(tvShowList);
        return tvShowList;
    }

    @Step("is Calendar contains TVShow: {0}")
    @Attachment
    public boolean isCalendarOnDateContainsTVShow(String tvShow) {
        if (tvShowList == null) {
            tvShowList = createShowList();
        }
        return tvShowList.stream().anyMatch(s -> s.getShowName().contains(tvShow));
    }
}
