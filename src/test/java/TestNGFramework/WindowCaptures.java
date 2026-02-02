package TestNGFramework;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowCaptures {
	@Test
	public void windowNames() throws InterruptedException{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://qaclickacademy.com/practice.php");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500);");
		WebElement element=driver.findElement(By.xpath("//*[text()='Discount Coupons']"));
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(5000);
		List<WebElement>list=driver.findElements(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul/li/a"));
		//System.out.println(list);
		for(WebElement abc:list) {
			abc.sendKeys(Keys.CONTROL,Keys.ENTER);
		}
		Thread.sleep(4000);
		//int i=0;
		Set<String>window=driver.getWindowHandles();
		Iterator<String>it=window.iterator();
		for(String handle:window) {

			driver.switchTo().window(handle);
			System.out.println(driver.getTitle());
			if(driver.getTitle().contains("Apache JMeter")) {
				Thread.sleep(4000);
				WebElement name1=driver.findElement(By.xpath("//*[@class='section']/h1"));
				System.out.println(name1.getText());
				break;
			}
						
			
		}
		//System.out.println(driver.findElement(By.xpath("//*[@class='logo']")).getText());
		
		driver.quit();
		//js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
