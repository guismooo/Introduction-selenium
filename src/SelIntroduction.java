import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//our first go is invoking the browser
		
		// To run in Chrome there is a ChromeDriver -> Methods
		//In Firefox - FirefoxDriver -> Methods
		
		//In selenium, all methods will be same for any browser, therefore no need to memorize if different browser driver is called out
		
		//On top of all  there is something called WebDriver (it is an interface) , that is directing what to do and what to follow.
		
		// https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.html
		
		//Any browser will not allow you to invoke directly from selenium code, 
		//therefore must use chromedriver.exe -> invoke chrome browser
		
		//webdriver.chrome.driver -> give the path**
		//** this can be ignored after selenium 4.6, SeleniumManager was introduced and it will search googledrive automatically
		//System.setProperty("webdriver.chrome.driver", "D://Selenium/chromedriver.exe");
		
		//For firefox
		//System.setProperty("webdriver.gecko.driver", "D://Selenium/geckodriver.exe");
		
		//Google Chrome launch
		//WebDriver driver = new ChromeDriver();
		
		//Firefox Launch
		//Firefox driver is named geckodriver
		//property: webdriver.gecko.driver
		//WebDriver driver = new FirefoxDriver();
		
		
		//Edge Launch
		//Edge driver is named edge
		//property webdriver.edge.driver
		//System.setProperty("webdriver.edge.driver", "D://Selenium/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		
		//Open url
		driver.get("https://rahulshettyacademy.com");
		//lets say we want to check the title of the page, the command below will log into the console.
		System.out.println(driver.getTitle());
		
		//Want to validaded if we have succesfuly navigated to the url we want, maybe it got hacked and is redirecting to another page?
		System.out.println(driver.getCurrentUrl());
		
		//driver.close will only close the url opened by driver, if during test some other tab is opened, will remain opened
		//driver.close();
		
		//will close all tabs associated by automation
		driver.quit();
		
	}

}
