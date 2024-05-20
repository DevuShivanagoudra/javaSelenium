package com.atimi.toolsqa;

import com.atimi.toolsqa.pages.home.Home;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

/**
 * Unit test for simple App.
 */
public abstract class BaseTest {

    public WebDriver driver;

    protected PageRegistry pageRegistry = new PageRegistry();

    @BeforeMethod
    public void setUp() {
        this.driver = getDriver(System.getProperty("browser"));
        driver.get("https://toolsqa.com/");
        getPageRegistry().setPageFactory(new PageFactory(driver));
    }

    public WebDriver getDriver(String browser) {
        WebDriver driver = null;
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                System.out.println("Invalid browser specified. Please use chrome/firefox/edge.");
        }
        return driver;
    }

    public PageRegistry getPageRegistry() {
        return pageRegistry;
    }

    public Home getHome() {
        return pageRegistry.get(Home.class);
    }

    @AfterClass(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
    }

    public static class PageRegistry {

        Map<Class<?>, Object> pageObject = new HashMap<>();

        PageFactory pageFactory = null;

        public <T extends BasePage> T get(final Class<T> pageClass) {
            if (!pageObject.containsKey(pageClass)) {
                List<Method> methods = Arrays.stream(pageFactory.getClass().getMethods()).filter(method -> method.getReturnType() == pageClass).collect(Collectors.toList());
                if (methods.size() == 1) {
                    try {
                        pageObject.put(pageClass, methods.get(0).invoke(pageFactory));
                    } catch (InvocationTargetException | IllegalAccessException e) {
                        throw new RuntimeException("Method not found exception.");
                    }
                } else if (methods.size() == 0) {
                    throw new RuntimeException(String.format("No factory method found for the class.", pageClass));
                } else {
                    throw new RuntimeException(String.format("Multiple factory found for the class.", pageClass));
                }
            }
            return (T) pageObject.get(pageClass);
        }


        public void setPageFactory(PageFactory pageFactory) {
            this.pageFactory = pageFactory;
        }
    }
}
