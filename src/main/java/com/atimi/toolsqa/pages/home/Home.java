package com.atimi.toolsqa.pages.home;

import com.atimi.toolsqa.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends BasePage {

    @FindBy(xpath = "//img [@class = \"tools-qa-header__logo\"]")
    private WebElement logo;

    @FindBy(linkText = "Home")
    private WebElement homeLink;

    @FindBy(xpath = "//a[text()='Selenium Training']")
    private WebElement seleniumTrainingLink;

    @FindBy(xpath = "//div[text() = \"Selenium Certification Training | Enroll Now | Study Online\"]")
    private WebElement seleniumTrainingPage;

    public Home(final WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForScreenToLoad() {
        waitForElementToDisplay(logo);
    }

    /**
     * Checks logo is displayed or not.
     *
     * @return true if it is displayed else false
     */
    public boolean isLogoDisplayed () {
        return logo.isDisplayed();
    }

    /**
     * Clicks on 'Home' link.
     */
    public void clickHome() {
        homeLink.click();
    }

    /**
     * Clicks on 'Selenium Training' link.
     */
    public void clickSeleniumTraining() {
        seleniumTrainingLink.click();
    }

    /**
     * Checks 'Selenium Training page' is displayed or not.
     *
     * @return true if 'Selenium Training page' is displayed else false
     */
    public boolean isSeleniumTrainingPageDisplayed() {
        return seleniumTrainingPage.isDisplayed();
    }
}
