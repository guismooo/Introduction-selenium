import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Handling autosuggestive dropdowns
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); //open the window in maxmized mode.
		driver.get("http://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		
		//First we need to grab the options available after typing some words.
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a")); // Get all the elements available
		
		for(WebElement option :options) // iterate options and pick one option
		{
			
			if(option.getText().equalsIgnoreCase("India"))
					{
				option.click();
				break;
					}
		}
	
	//Handling Checkbox and getting the size of them with selenium
		
	
	
	
	}

}
