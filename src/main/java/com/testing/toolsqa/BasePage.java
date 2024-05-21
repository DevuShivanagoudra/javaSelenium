package com.testing.toolsqa;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 */
public abstract class BasePage {

    protected WebDriver driver;

    protected abstract void waitForScreenToLoad();
    protected BasePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    protected void waitForElementToDisplay(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(30));
    }
}
