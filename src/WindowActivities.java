import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		//open the window in maxmized mode.
		driver.manage().window().maximize();
		driver.get("http://google.com"); ///by default selenium will wait this page to load
		driver.navigate().to("http://rahulshettyacademy.com"); // from an opened browser, navigate to another page. 
		//However selenium will not wait it to fully load here, se careful
		driver.navigate().back();//this will take you back to google.com
		
	}

}
