import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class methodsToHandleClass102 {

	public static void main(String[] args) throws InterruptedException {
		// Sometimes an element may not be on the focus, we may need to scroll and be able to see the element.
		//selenium does not support that, so we need to use java
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(3000);
		
		//What is I want to scroll inside a table? 
		//document.querySelector(".tableFixHead").scrollTop=5000 where "tableFixHead is element class name. We can use scroll left also to scroll horizonally
		js.executeScript("document.querySelector(\'.tableFixHead\').scrollTop=5000");
		
		//let's sum all the values from "amount" column
		//In this page, the 4th column tag is td, nothing else, and to make sure we are not picking any other 4th column from other tables, we travelled form its parent "tableFixHead"
		List<WebElement> values= driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum =0;
		for(int i=0;i<values.size();i++)
		{
			
			sum = sum + Integer.parseInt(values.get(i).getText()); //we need to parse from String to Int
			
		}
		System.out.println(sum);
		
		//Let's grab a text and compare with out previous calculated sum
		int value = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, value);
		
	}

}
