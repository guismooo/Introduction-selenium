import java.time.Duration;
import java.util.Set;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class exercise93 {

	public static void main(String[] args) throws InterruptedException {
		// How to count links on the page.

		// any link will have a tag "a". "a" standas for anchor.

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// All links on page
		System.out.println(driver.findElements(By.tagName("a")).size()); // get all tags "a" on page

		// All links on footer. We will create a mini driver.
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());

		// All links count on first column of footer section.
		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());

		// Click all links on first column on footer and check if page is opening,
		// dinamically, if size changes it still works
		for (int i = 1; i < columndriver.findElements(By.tagName("a")).size(); i++) // we started from i=1 because we do
																					// not want the first link
		// if we just click, it will open and focus on new tab, creating a problem, we
		// will aproach with the use of ctrl key to open and not focus new tab.
		{
			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);

			Thread.sleep(5000L);
		}
		
		
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();

		while (it.hasNext()) // Now we need to navigate to each child window and grab the title to confirm it
								// was opened.
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
