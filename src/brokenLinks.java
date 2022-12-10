import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class brokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//we will be testing if links are working and opening correctly.
		//broken link = broken url
		//Wit developer tools in Chrome, go to Network and click on Fetch/XHR
		
		
		//Step 1 - Is to get all URL's tied up t the links using selenium.
		//Step 2 - Java methods will call the URL's and gets you the status code.
		//Step 3 - If status code >400 then that url is not working.
		
		
		//Now let's do it for all inks
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a = new SoftAssert();
		
		for(WebElement link : links) // lets iterate links and create a link element
		{
			String url = link.getAttribute("href");
			HttpURLConnection connection= (HttpURLConnection)new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect(); //make a call to url
			int responseCode =connection.getResponseCode(); // get response code
			System.out.println("Response code :"+responseCode+ " link: "+link.getText());
			
			// Assert.assertTrue(responseCode<400, "The link with text"+link.getText()+" is broken with code: "+responseCode); // This is hard assertion, it will stop the code.
			a.assertTrue(responseCode<400, "The link with text"+link.getText()+" is broken with code: "+responseCode); // This is soft  assertion, it will store the failure and continue the code.
		}
		a.assertAll(); // This will display all failures if existing.
	}

}
