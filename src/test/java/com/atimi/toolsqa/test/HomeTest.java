package com.atimi.toolsqa.test;

import com.atimi.toolsqa.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test(priority = 0)
    public void testLogo() {
        getHome().waitForScreenToLoad();
        Assert.assertTrue(getHome().isLogoDisplayed(), "Tools QA Logo is not displayed.");
    }

    @Test(priority = 1)
    public void testHomeLink() {
        getHome().waitForScreenToLoad();
        getHome().clickSeleniumTraining();
        Assert.assertTrue(getHome().isSeleniumTrainingPageDisplayed(),
                "Selenium Training page is not displayed.");
    }
}
