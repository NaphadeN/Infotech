package DEC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ER {
	
	static WebDriver driver; // Initialize the Webdriver which can be accessible throughout the class

@Test
	public void Googlesetup() { // Method 1

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit Wait

		driver.get("http://google.com");

		System.out.println("My Websie Launched Successfuly");
		
		
		//Explicit Wait : 

		WebElement SearchTogetdata = driver.findElement(By.linkText(
				"Gmail"));

		WebDriverWait Search = new WebDriverWait(driver, 185);
		Search.until(ExpectedConditions.elementToBeClickable(SearchTogetdata)).click();
		
		
	}


public void CreateNewAccount() {
	
	
}



}

