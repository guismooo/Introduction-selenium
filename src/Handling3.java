import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//TestNG is one of the testing framework


public class Handling3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.spicejet.com");
		//Asserts added from lesson 62
		//assertFalse expects false from test, if false, it will continue, if true, it will stop
		//Assert.assertFalse(driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1d09ksm r-1inuy60 r-m611by']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")).isEnabled());
		//Checking if checkbox is selected
		System.out.println(driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1d09ksm r-1inuy60 r-m611by']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")).isEnabled());
		//Handling Checkbox and getting the size of them with selenium
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1d09ksm r-1inuy60 r-m611by']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")).click();
		//Now to tell if checkbox is selected..
		Thread.sleep(2000);
		//Asserts added from lesson 62
		//assertFalse expects true from test, if true, it will continue, if false, it will stop
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1d09ksm r-1inuy60 r-m611by']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")).isEnabled());
		//Checking if checkbox is selected
		
		System.out.println(driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1d09ksm r-1inuy60 r-m611by']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")).isEnabled());
		
	
		
		
		
		//Count the number of checkboxes
		//driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		
		
	//Assertions in automation testing 
		
		
		
	}

}
