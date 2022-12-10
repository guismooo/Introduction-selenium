import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingJavaAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String text = "Rahul";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(1000);
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		Thread.sleep(1000);
		// Lets grab the text from the alert
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept(); // Here we are switching to alerts displayed on screen
		Thread.sleep(1000);
		// Lets handle the confirm button which displays an alert with two options
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss(); // dismiss is applied to cancel/no or any negative sentence
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().accept(); // this is used for positive answers like accept or yes

	}

}
