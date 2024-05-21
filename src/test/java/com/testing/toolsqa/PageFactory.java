package com.testing.toolsqa;

import com.testing.toolsqa.pages.home.Home;
import org.openqa.selenium.WebDriver;

public class PageFactory {

    private WebDriver driver;

    public PageFactory(final WebDriver driver) {
        this.driver = driver;
    }

    public Home getHome() {
        return new Home(driver);
    }
}
