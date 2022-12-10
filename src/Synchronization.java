import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Synchronization {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Advantage of implicty waiting.
		//--Readable code, apply only once and works all code, no junk code.
		//Disadvantage:
		//The time specified will apply to all code, if any error exists, it will need this amount of time to throw and error
		//Hides performance issues if long time is specified like 8seconds..

		WebDriver driver = new ChromeDriver();

		// expected products array
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Carrot" };
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // implicity wait

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		
		addItems(driver,itemsNeeded);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		
		

		
		
	}

public static void addItems(WebDriver driver, String[] itemsNeeded)
{
	List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name")); // adding to a list named
	// products
	int j = 0;

for (int i = 0; i < products.size(); i++) // iterate list
{
// Brocolli - 1 Kg this is actual name, we need to separate the - 1 Kg
String[] name = products.get(i).getText().split("-");
// we will get something like name[0] = "Brocolli " - now we need to trim the
// white spaces
String formattedName = name[0].trim();
// Format it to get actual vegetable name

// Check wheter name you extracted is present in array or not-
// convert array into array list for easy search. This way is better, we first
// declare array and later convert into array list, this saves memory
List itemsNeededList = Arrays.asList(itemsNeeded);

if (itemsNeededList.contains(formattedName)) // if find Cucumber
{
System.out.println(formattedName);
j++;
// click on add to cart

// driver.findElements(By.xpath("//button[text()='ADD TO
// CART']")).get(i).click(); There is a proble with this approach, when item is
// added to cart the text changes
// Therefore the next item is not corretly added because the indexes changes for
// a few seconds

driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
// If we already found all or items, no point in keeping running the for loop.
if (j == itemsNeeded.length)
break;
}
}
	
}
}
