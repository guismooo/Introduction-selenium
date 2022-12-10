import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendarUIClass98 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		driver.get("https://www.path2usa.com/travel-companions");
		Thread.sleep(1000);
		jse.executeScript("window.scrollTo(0,1200)");
		Thread.sleep(1000);
		
		//April 23 2023
		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
		
		
		
		while(!driver.findElement(By.cssSelector("[class='flatpickr-current-month']")).getText().contains("April"))
		{
			driver.findElement(By.cssSelector("[class='flatpickr-next-month']")).click();
		}
		
		//it is noted that all days have a common class name in this website = "flatpickr-day "
		List<WebElement> dates = driver.findElements(By.className("flatpickr-day")); //put common atribute in list
		int count = driver.findElements(By.className("flatpickr-day")).size(); //get size
		for(int i=0;i<count;i++)
		{
			
			String text =driver.findElements(By.className("flatpickr-day")).get(i).getText(); // get date
			if(text.equalsIgnoreCase("23")) //if matches our date
			{
				driver.findElements(By.className("flatpickr-day")).get(i).click();
				break;
			}
		}
	}

}
