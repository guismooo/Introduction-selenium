import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBoxesExercise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(1500);
		driver.findElement(By.id("checkBoxOption1")).click(); // enable checkbox
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected()); // check if enabled
		driver.findElement(By.id("checkBoxOption1")).click(); // uncheck checkbox
		Thread.sleep(1000);
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected()); // check if unchecked
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
	}

}
