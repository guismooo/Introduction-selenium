import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EndToEndTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// aula 66
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.spicejet.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(), 'AMD')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(), 'IXG')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//div[@data-testid='undefined-month-November-2022'] //div[@data-testid='undefined-calendar-day-24']"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();

	}

}
