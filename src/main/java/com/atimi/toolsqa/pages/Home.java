package com.atimi.toolsqa.pages;

import com.atimi.toolsqa.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home extends BasePage {

    public Home(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void waitForScreenToLoad() {
        waitForElementToDisplay(logo);
    }

    @FindBy(xpath = "//img [@class = \"tools-qa-header__logo\"]")
    private WebElement logo;

    public boolean isLogoDisplayed () {
        return logo.isDisplayed();
    }


}
