package com.atimi.toolsqa;

import com.atimi.toolsqa.pages.Home;
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
