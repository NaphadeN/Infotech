package DEC;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(); //WebDriver is an interface and all the methods which are declared in Webdriver interface are implemented by respective driver class.
                                               //ChromeDriver() is a Constructor, new is a keyword, and new ChromeDriver() is an Object.
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit Wait

		driver.get("http://google.com");
		
		//driver.navigate().to("http://google.com");
		
		System.out.println("My Google Website Launched Successfully");
		
		//driver.navigate().forward();
		
		
	
	//	driver.navigate().refresh();
		
	//	driver.navigate().back();
		
	//	driver.findElement(By.linkText("Gmail")).click();
		
		

		WebElement SearchTogetdata = driver.findElement(By.linkText(
				"Gmail"));

		WebDriverWait Search = new WebDriverWait(driver, 20);
		Search.until(ExpectedConditions.elementToBeClickable(SearchTogetdata)).click();
		
		
		driver.findElement(By.linkText("Create an account")).click();

		
		driver.findElement(By.id("firstName")).sendKeys("NIKHIL");
		
		driver.findElement(By.id("lastName")).sendKeys("QA Engineer");
		
		driver.findElement(By.id("lastName")).clear();
		
		driver.findElement(By.id("lastName")).sendKeys("Sr.QA Analyst");

		
		
		driver.findElement(By.id("username")).sendKeys("NikhilQAAAAA");

		driver.findElement(By.name("Passwd")).sendKeys("QW!nxnxnnx");
		
		
		driver.findElement(By.name("ConfirmPasswd")).sendKeys("QW!nxnxnnx");

		
		
		driver.findElement(By.id("i3")).click();
		
		
		
		
		
		Thread.sleep(10000);
		
		driver.close(); // method is used to close the current browser window on which the focus is set.

		//driver.quit();  //method essentially calls the driver.closes all the browser windows and ends the WebDriver session 

	}
		
}
