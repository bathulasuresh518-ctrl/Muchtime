package mobileAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CallingFromBase extends BaseTest {

    @Test
    public void testGoogleTitle1() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Google"), "Title does not contain 'Google'");
    }

    @Test
    public void testGoogleTitle2() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Google"), "Title does not contain 'Google'");
    }
}
