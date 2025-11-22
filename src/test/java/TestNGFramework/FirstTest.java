package TestNGFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public  class FirstTest {
	
	
	

	WebDriver driver;
	//@BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
       
    }	
	
	@Test(invocationCount = 10)
	public void FirstTest2() throws InterruptedException {
		
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[text()='Login']")).click();
		
		driver.findElement(By.xpath("//*[@placeholder='Enter your active Email ID / Username']")).sendKeys("sureshvarsh34@gmail.com");
		driver.findElement(By.xpath("//*[@placeholder='Enter your password']")).sendKeys("Suresh@1998");
		driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
		//driver.findElement(By.xpath("//*[@class='crossIcon chatBot chatBot-ic-cross']")).click();
		driver.findElement(By.xpath("//*[text()=' profile']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("attachCV")).sendKeys("C:\\Users\\Suresh Bathula\\Downloads\\Suresh-resume1.pdf");
		Thread.sleep(4000);
		driver.quit();
		FirstTest1();
	   }
	@Test
public  void FirstTest1() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[text()='Login']")).click();
		
		driver.findElement(By.xpath("//*[@placeholder='Enter your active Email ID / Username']")).sendKeys("bathulasuresh518@gmail.com");
		driver.findElement(By.xpath("//*[@placeholder='Enter your password']")).sendKeys("Suresh@1998");
		driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
		//driver.findElement(By.xpath("//*[@class='crossIcon chatBot chatBot-ic-cross']")).click();
		driver.findElement(By.xpath("//*[text()=' profile']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("attachCV")).sendKeys("C:\\Users\\Suresh Bathula\\Desktop\\Suresh_Automation_ResumeCV.pdf");
		Thread.sleep(4000);
		FirstTest2();
		
	}
	@AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}
