package com.atimi.toolsqa.test;

import com.atimi.toolsqa.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test(priority = 0, description = "Verify tools qa logo ids displayed.")
    public void testLogo() {
        getHome().waitForScreenToLoad();
        Assert.assertTrue(getHome().isLogoDisplayed(), "Tools QA Logo is not displayed.");
    }

    @Test(priority = 1, description = "Verify selenium training page is displayed.")
    public void testHomeLink() {
        getHome().waitForScreenToLoad();
        getHome().clickSeleniumTraining();
        Assert.assertTrue(getHome().isSeleniumTrainingPageDisplayed(),
                "Selenium Training page is not displayed.");
    }

}
