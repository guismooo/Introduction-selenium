import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class miscelleanous {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com");
		
		//delete cookies, 
		driver.manage().deleteAllCookies();
		
		//delete specific cookie..
		driver.manage().deleteCookieNamed("asdf");
		
		//how to take screenshots in selenium
		//we need to cast takescreenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Now we need to save file
		//import org.apache.commons.io.FileUtils;
		FileUtils.copyFile(src, new File("D://screenshot.png")); // Saving to C driver may be difficult because admin rights are required. Save in other  driver or to user folder
		//FileUtils.copyFile(src, new File("C:\\Users\\Guilherme\\screenshot.png"));
	}

}
