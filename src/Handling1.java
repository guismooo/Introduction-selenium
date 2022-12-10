import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Handling1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Handling Statis Dropdowns
		//Handling Dynamic Dropdowns
		//Handling Checkboxes
		//Handling Radio Buttons
		//Handling Text Buttons
		//Handling Alerts-Java Popups
		//Handling Webdriver Form Methods
		
		//https://rahulshettyacademy.com/dropdownsPractise/
		
		//Currency dropdown is a static dropdown as options are fixed, this can be confirmed by tag being SELECT
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rahulshettyacademy.com/dropdownsPractise/");
		//dropdown with select tag
		WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropDown); // creating a new class for select
		dropdown.selectByIndex(3);//selecting USD
		dropdown.getFirstSelectedOption().getText();//Extract the text of that element
		dropdown.selectByVisibleText("AED"); // select by text mode
		dropdown.selectByValue("INR"); // in this case it is same as text, but may be different than displayed text
		
		//lets add passengers
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		int i=1;
		while(i<5)
		{
			//Will add adults till reach defined quantity.
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		//Assert
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		//----------------------------------------------------------------------------
		//Dynamic dropdown. 1st the options are only loaded after another dropdown is defined.
		//Dynamic dropdown are loaded based on user actions
		
		// //a[@value='MAA']
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[@value='SXR'])[2]")).click(); //index 2
		//some customers will not like/accept having index, so..
		
		//another way to handle this is using parent to child.
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='SXR']")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
