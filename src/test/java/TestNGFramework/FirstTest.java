package TestNGFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public  class FirstTest {
	
	
	

	WebDriver driver;
	//@BeforeMethod
    public void setUp() {

    	 driver = new ChromeDriver();

     
       // driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
       
    }	
	
	@Test(dataProvider="getdata")
	public void FirstTest2(String username, String password, String resume) throws InterruptedException {
		
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[text()='Login']")).click();
		
		driver.findElement(By.xpath("//*[@placeholder='Enter your active Email ID / Username']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@placeholder='Enter your password']")).sendKeys(password);
		driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
		//driver.findElement(By.xpath("//*[@class='crossIcon chatBot chatBot-ic-cross']")).click();
		driver.findElement(By.className("view-profile-wrapper")).click();
		Thread.sleep(2000);
		System.out.println("Executing Naukri login script...");
		driver.findElement(By.id("attachCV")).sendKeys(resume);
		Thread.sleep(3000);
		//driver.quit();
		
	   }
	@DataProvider
	public Object[][] getdata() {
		Object [][] data=new Object [3][3];
		data[0][0]="sureshvarsh34@gmail.com";
		data[0][1]="Suresh@1998";
		data[0][2]="C:\\Users\\Suresh Bathula\\eclipse-workspace\\artifact\\naukarifiles\\Suresh_Automation_Resume1.pdf";
		data[1][0]="bathulasuresh518@gmail.com";
		data[1][1]="Suresh@1998";
		data[1][2]="C:\\Users\\Suresh Bathula\\eclipse-workspace\\artifact\\naukarifiles\\Suresh_Automation_Resume2.pdf";
		data[2][0]="nareshbathula057@gmail.com";
		data[2][1]="Naresh@2000";
		data[2][2]="C:\\Users\\Suresh Bathula\\eclipse-workspace\\artifact\\naukarifiles\\Naresh_resume_resume.pdf";
		
		return data;
		
	}
	

	@AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}