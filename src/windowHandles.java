import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		// handling child window

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click(); // now a child page is loaded and we need to shift
																		// focus
		Set<String> windows = driver.getWindowHandles(); // [parentid,childid]

		Iterator<String> it = windows.iterator(); // grab collection of open windows
		String parentId = it.next(); // next will first move to position 0 (parentid)
		String childId = it.next(); // control will switch from 0 to 1 index (childid)
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText()); // remember on css when class contains spaces we must replace by point
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0]; //index 0 is eliminated, only index 1 is grabed. Then with Trim we trim the white spaces
		//Then we split again based on white space and finally grab only index 0 which is email
		//now lets switch back to parent window
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(emailId);
	}

}
