import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.amazon.com");
		Actions a= new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//a[@data-nav-ref='nav_ya_signin']"));
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		
		//moves to specific eelement
		a.moveToElement(move).build().perform();
		
		//move to search box and click,hold shift and write iphone in capital letters.
		a.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("iphone").build().perform();
		
		//select text by double click
		a.moveToElement(search).doubleClick().build().perform();
		
		//right click
		a.moveToElement(move).contextClick().build().perform();
		
		
		

	}

}
