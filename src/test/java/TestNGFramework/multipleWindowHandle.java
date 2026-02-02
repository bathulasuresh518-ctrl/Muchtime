package TestNGFramework;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class multipleWindowHandle {
     @Test
	public void windows() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector("a[class*='blinkingText']")).click();
		Set<String>window=driver.getWindowHandles();
		Iterator<String>it=window.iterator();
		String parent=it.next();
		String child=it.next();
		driver.switchTo().window(child);
		String a=driver.findElement(By.xpath("//*[text()='Please email us at ']")).getText();
		driver.switchTo().window(parent);
		driver.findElement(By.id("username")).sendKeys(a);
		
	}

}
