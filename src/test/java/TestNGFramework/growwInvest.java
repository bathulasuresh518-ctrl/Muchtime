package TestNGFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class growwInvest {
	WebDriver driver;
	@BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
       
    }	
	@Test
	public void Grow() throws InterruptedException {
		driver.get("https://groww.in/login");
		driver.findElement(By.id("login_email1")).sendKeys("rudrasuresh98@gmail.com");
		driver.findElement(By.xpath("//*[text()='Continue']")).click();
		driver.findElement(By.id("login_password1")).sendKeys("Bakkamma@123@123");
		driver.findElement(By.xpath("//*[text()='Submit']")).click();
		Thread.sleep(5000);
		for(int i=1;i<5;i++) {
			driver.findElement(By.xpath("(//*[@class='otpinput88item'])"));
		}
	}

	@AfterMethod
    public void tearDown() {
        if (driver != null) {
            //driver.quit();
        }
    }
}
