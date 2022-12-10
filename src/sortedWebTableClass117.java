import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class sortedWebTableClass117 {

	public static void main(String[] args) {
		// Check if table is sorted or not
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// We will click in first cell to sort (this is a feature already built in
		// website)
		driver.findElement(By.xpath("//*[contains(text(),'Veg/fruit name')]")).click();

		// capture all webelements into list.
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		// capture text of all webelements into new(original) list
		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList()); // get
																												// text
																												// and
																												// store
																												// back
																												// into
																												// "originalList"
																												// using
																												// Collectors.tolist
		// Sort on the original list of step 3 -> sorted list.
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		// compare original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList)); // if both are equals, it will pass assertion.

		// Sorting is completed

		// Get Price of each Beans for example.
		// We already have all grabed in elementsList, let's scan the name column with
		// get text.
		List<String> price;
		do {
			// capture all webelements into list.
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList()); // filter is passing text "Beans", passed to map //getPriceVeggie is
													// a custom method we are creating here
			price.forEach(a -> System.out.println(a));

			if (price.size() < 1) // that means search function didn't find our veggie, we will click next and
									// repeat process.
			{
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (price.size() < 1); // while price size is less than 1, will loop

	}

	private static String getPriceVeggie(WebElement s) {
		// The price column has same tag "td" so we will traverse using sibling method
		// with xpath
		// //tr/td[1]/following-sibling::td[1]
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText(); // reason why we skipped
																							// //tr/td[1]/ here is
																							// because it is not
																							// driver.findelement, but
																							// it is already
		// starting from webelement s

		return pricevalue;
	}

}
