import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class filterWebTableClass121 {

	public static void main(String[] args) {
		String product = "Rice";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys(product);
		
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		//Results
		List<WebElement> search= elementsList.stream().filter(s->s.getText().contains(product)).collect(Collectors.toList());
		Assert.assertEquals(elementsList.size(),search.size());

	}

}
