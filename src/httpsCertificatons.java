import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class httpsCertificatons {

	public static void main(String[] args) {
		// how to handle ssl certification
		
		//---- Class 105
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		//---
		
		//---Class 106
		options.addExtensions();//give the path to the extension
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444"); // ask network guys for ip adress
		options.setCapability("proxy", proxy); // set proxy capability.
		
		//Block pop-up windows
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		//Set download directory.
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		
		WebDriver driver = new ChromeDriver(options);//we need to pass the optons here, otherwise it will not have effect
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
	}

}
