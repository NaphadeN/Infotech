package DEC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class chromerlaunchwithTestNG {
	
	static WebDriver driver; // Initialize the Webdriver which can be accessible throughout the class

	
	
	
@Test(priority=1, groups= {"SmokeTest"},invocationCount=2)
	public void Googlesetup() { // Method 1

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // Implicit Wait

		driver.get("http://google.com");

		System.out.println("My Websie Launched Successfuly");
		

	}

	//@Test(dependsOnMethods="Googlesetup")



   @Test(priority=2,dependsOnMethods="Googlesetup",groups= {"SmokeTest"})
   
   
	public void CreateAccount() throws InterruptedException {                   // Method 2

	//	Googlesetup();

		driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[1]/div/div[1]/a")).click();

		driver.findElement(By.linkText("Create an account")).click();

		// driver.findElement(By.partialLinkText("Create")).click();

		driver.findElement(By.id("firstName")).sendKeys("Rajesh"); // Locator Id

		// driver.findElement(By.name("lastName")).sendKeys("Veer");
		driver.findElement(By.cssSelector("#lastName")).sendKeys("Veer"); // Using Css Selector if Id or class is
																			// present

		driver.findElement(By.cssSelector("#lastName")).clear();

		driver.findElement(By.id("i3")).click();

		
		
		// How to Capture Text for any Word / Sentences : 

//Example : 1
		String HeadingName = driver.findElement(By.xpath("//*[@id=\"headingText\"]/span")).getText();

		System.out.println("text Presnt on Page " +HeadingName);
		
		
//Example : 2		
		
		String WorkForYou = driver.findElement(By.xpath("//*[@id=\"initialView\"]/div[2]/div[2]/div/figure/figcaption")).getText();

		System.out.println("Text Name is : " +WorkForYou);


		
		//How to Get title of thr Page
		
		String MyPageTitle = driver.getTitle();	
			
		System.out.println("Hey YOur Page Title is : " +MyPageTitle );
		
		// driver.quit();
	}
   
   
}

