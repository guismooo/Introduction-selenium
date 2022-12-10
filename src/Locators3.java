import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		String name="Guilherme a vilvert Arthur";

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://outlook.live.com/owa/");
		//Mazimize current window
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='bound']/nav/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//input[@id='i0116']")).sendKeys("arthurwv@hotmail.com");
		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click(); // 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='i0118']")).sendKeys("Guismo1571@!1571");
		driver.findElement(By.xpath("//input[@class='win-button button_primary button ext-button primary ext-primary']")).click(); // 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click(); // 
		//System.out.println(driver.findElement(By.cssSelector("div.js-flash-alert")).getText());//selecting with css selector
		Thread.sleep(5000);
		driver.findElement(By.id("O365_MainLink_NavMenu")).click();
		driver.findElement(By.xpath("//div/div/div[2]/div/div[2]/div[2]/span/a/div[2]")).click(); // 
		Thread.sleep(5000);
		//Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ms-Nav-group is-expanded']/div[1]")).getText(),name);
		//System.out.println(driver.findElement(By.xpath("//div[@class='ms-Nav-group is-expanded']/div[1]")).getAttribute("title")); nao funcionou
		//Assert.assertEquals(driver.findElement(By.cssSelector("div.js-flash-alert")).getText(), "Incorrect username or password.  "); // THis will check if retrieved text matches expected text
		//driver.findElement(By.xpath("//div[@class='mectrl_topHeader mectrl_theme_dark']")).click();
	
	//lets
	
	}

}
