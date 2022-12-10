import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.spicejet.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div[2]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(), 'AMD')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(), 'IXB')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//div[@data-testid='undefined-month-November-2022'] //div[@data-testid='undefined-calendar-day-24']"))
				.click();
		Thread.sleep(1000);

		// Check f UI element is disabled
		// we can try to use .isEnabled() but some websites will fail and not return
		// false when disabled
		// First we need to understand what is the attribute that is getting changed
		// when going enabled or disabled.

		// For this exercise, I noted the class name is different when enabled and
		// disabled. lets use If condition
		if (driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']/div[1]"))
				.getAttribute("style").contains("1.0")) {
			System.out.println("its enabled");
			Assert.assertTrue(true);
		} else {
			System.out.println("its disabled");
			Assert.assertTrue(false);
		}

	}

}
