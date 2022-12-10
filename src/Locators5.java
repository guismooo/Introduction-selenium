import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Sibling - Child to parent traverse
		WebDriver driver = new ChromeDriver();
		// for this exercise we will locate a button and based on that we will select its sibling, 
		// This can be applied in situation where the button name/class or whatever is changing dinamically, so we select a static one,
		// and shift to its sibling
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		
		//now traversing back to parent
		//header/div/button[1]/parent::div/parent::header/a
		//so we went from button to parent div then again parent to header and then down to child a
		//this cannot be done in css, only in xpath
	
		
		//ok so another way of reaching the login button
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
	}

}
