import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Aula44 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "rahul";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//Espera 5 segundos antes de jogar erro
		String password = getPassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/"); // Abre o site
		driver.findElement(By.id("inputUsername")).sendKeys(name); // enviar o texto da variavel name
		driver.findElement(By.name("inputPassword")).sendKeys(password); // envia senha
		driver.findElement(By.className("signInBtn")).click(); // clica em logar
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText()); // imprime texto da tag p
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in."); // Confere se texto  confere
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+","); // Check if welcome name matches 
		driver.findElement(By.xpath("//*[text()='Log Out']")).click(); // clica em logout
		driver.close();
		
	}
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		//THis method should give us the password
		driver.get("https://rahulshettyacademy.com/locatorspractice/"); // Abre o site
		driver.findElement(By.linkText("Forgot your password?")).click(); // clica em esqueceu a senha
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText(); // store the string
		//Please use temporary password 'rahulshettyacademy' to login.
		String [] passwordArray = passwordText.split("'");//Inside double quotes, the split char is placed
		//0th index - Please use temporary password
		//1st index - rahulshettyacademy' to login.
		
		//Isso abaixo é..
		//String [] passwordArray2 = passwordArray[1].split("'");
		// o mesmo que:
		String password = passwordArray[1].split("'")[0];
		//0th index - rahulshettyacademy
		//1st indx - to Login.
		return password;
		
	}

}
