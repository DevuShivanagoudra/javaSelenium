package com.atimi.toolsqa.test;

import com.atimi.toolsqa.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test
    public void testLogo() {
        getHome().waitForScreenToLoad();
        Assert.assertTrue(getHome()., "Tools QA Logo is not displayed.");
    }
}
