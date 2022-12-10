import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		//Sometimes the loading time may take a few seconds and selenium may throw an error because selenium is too fast for browser response
		//We can set a implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://github.com/login");
		driver.findElement(By.id("login_field")).sendKeys("arthurwv@hotmail.com");
		//driver.findElement(By.id("password")).sendKeys("123");
		//We can use regular expression to build css path, sometimes the type name will have static characters and sufix is changing dinamically
		//Lets say the last 4 chars of password are changing
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("123");
		
		//driver.findElement(By.className("js-sign-in-button")).click(); // In this case we pick one of the class names
		//driver.findElement(By.xpath("//input[@class='btn btn-primary btn-block js-sign-in-button']")).click();//xpath, full class name
		//driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click(); // another way
		driver.findElement(By.xpath("//input[contains(@class,'btn btn-primary')]")).click(); // another way
		
		
		//regular expression to xpath with class that changes dinamically::
		//::button[contains(@class,'submit')] where submit is static class name
		System.out.println(driver.findElement(By.cssSelector("div.js-flash-alert")).getText());//selecting with css selector

		
		driver.findElement(By.xpath("//*[@id=\'login\']/div[4]/form/div/a")).click(); //Lets select reset passwrod using Xpath
		
		
		driver.findElement(By.cssSelector("input[placeholder='Enter your email address']")).clear(); //clear a textbox:
		
		driver.findElement(By.cssSelector("input[placeholder='Enter your email address']")).sendKeys("test@gmail.com");//Customized sintax
		
		driver.findElement(By.cssSelector("input[placeholder='Enter your email address']")).clear();//lets clear again
		
		driver.findElement(By.cssSelector("input[type=\'text\']:nth-child(2)")).sendKeys("test2@gmail.com");//Lets select email box again with different method
		
		driver.findElement(By.cssSelector("input[placeholder='Enter your email address']")).clear();//lets clear again
		driver.findElement(By.xpath("//form/div[3]/input[1]")).sendKeys("test3@gmail.com");//Another way of xpath, traverse from parent to child
		
		driver.get("https://github.com/login"); // back to main page
		driver.findElement(By.xpath("//div[@class='footer container-lg p-responsive py-6 mt-6 f6']/ul/li[2]/a")).click();
		
		//in case we want to set a hard wait
		Thread.sleep(1500);
		
		
			driver.get("https://www.macrotrends.net/stocks/charts/AMZN/amazon/financial-statements");
			Thread.sleep(1500);
			System.out.println(driver.findElement(By.xpath("//*[@id=\'row2jqxgrid\']/div[6]/div")).getText());
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
	}

}
