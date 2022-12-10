import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingItemsToCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// AMazon interview question

		WebDriver driver = new ChromeDriver();
		int j = 0;

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		// we want to add cucumber but there is no attribute, if we make xpath by text
		// "ADD TO CART", 30 instances are found. so first let's filter by cucumber
		// there is a class named "product-name"
		// take all items, iterate and find cucumber position.
		// h4.product-name

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name")); // adding to a list named
																							// products
		// expected products array
		String[] itemsNeeded = { "Cucumber", "Brocolli","Carrot" };
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
