package mobileAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NotPossible {

    WebDriver driver;

    @Test(dataProvider = "getData")
    public void startTest(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Brave")) {
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
            driver = new ChromeDriver(options);
        } else {
            System.out.println("No valid browser selected");
            return;
        }

        driver.get("https://www.google.com");
        System.out.println("Title is: " + driver.getTitle());

        // Cleanup for each test
        driver.quit();
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][] {
            { "Chrome" },
            { "Brave" }
        };
    }
}
