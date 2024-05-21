package com.testing.toolsqa.pages.widgets.tabbar;

import com.testing.toolsqa.BasePage;
import com.testing.toolsqa.constants.TabBarOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TabBar extends BasePage {

    @FindBy(linkText = "Selenium Training")
    private WebElement seleniumTraining;

    public TabBar(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForScreenToLoad() {
    }

    public void tap(TabBarOptions options){

    }
}
