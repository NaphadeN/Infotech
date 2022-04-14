package DEC;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
public class TestNGwithAnnotation {
	
	static WebDriver driver; // Initialize the Webdriver which can be accessible throughout the class

	@BeforeMethod

	public void Googlesetup() { // Method 1

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // Implicit Wait

		driver.get("http://google.com");

		System.out.println("My Websie Launched Successfuly");

		
		
	}




   @Test(priority=2)
   
 //  (priority=2,dependsOnMethods="Googlesetup",groups= {"SmokeTest"})
   
   
	public void CreateAccount() throws InterruptedException {                   // Method 2

		//Googlesetup();

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
		
		
		
	}
   
   @Test(priority=1, invocationCount =1)   //(enabled=false)
   
   
   public void ForWork() throws InterruptedException {
	   
	   driver.findElement(By.linkText("Gmail")).click();
	   
	  driver.findElement(By.partialLinkText("For")).click();

	   driver.findElement(By.linkText("Start Free Trial")).click();
	   
	   driver.findElement(By.id("c2")).sendKeys("Google Business");
	   
	   driver.findElement(By.id("c6")).click();
	   
	 //Scroll Down
	   
	   JavascriptExecutor js = (JavascriptExecutor) driver;  //JavascriptExecutor is an interface
	   js.executeScript("window.scrollBy(0,250)", "");  // executeScript is Method
	 
	   

	   
	   driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div[2]/main/div/div/section[1]/div[3]/div/div/div/div[1]")).click();  // Click on India
	 
	   Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div[2]/main/div/div/section[1]/div[3]/div/div/div/div[2]/ul/li[96]/span[2]")).click(); //Iceland
	
	
	   Thread.sleep(4000);

	driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div[2]/main/div/div/section[1]/div[3]/div[1]/div/div/div[1]")).click(); //Again Click on Iceland
   
	
	
	WebElement Jordan=driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div[2]/main/div/div/section[1]/div[3]/div/div/div/div[2]/ul/li[105]/span[2]")); // Click on Jordan
	
	WebDriverWait wait2 = new WebDriverWait(driver,30);
   
	wait2.until(ExpectedConditions.elementToBeClickable(Jordan)).click();
	
	
	
	String IPAlert =driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div[2]/main/div/div/section[1]/div[3]/div[2]")).getText();
   System.out.println("After Selecting Jordan Getting message as " +IPAlert);
   
   
   Thread.sleep(10000);
   
   JavascriptExecutor js2 = (JavascriptExecutor) driver;  //JavascriptExecutor is an interface
   js2.executeScript("window.scrollBy(0,-250)", "");  // Method
 
   
    
   }
   
   @Test(priority = 3)
   
   public void MyPractice1() throws InterruptedException {
	   driver.findElement(By.linkText("Gmail")).click();
	   
	   JavascriptExecutor js3 = (JavascriptExecutor) driver;  //JavascriptExecutor is an interface
	   js3.executeScript("window.scrollBy(0,3750)", "");  // Method
	 
	   WebElement HelpC=driver.findElement(By.linkText("Help Center"));
	   
	
	   System.out.println("Hey my MyPractice1 Executed ......!!");
	   
   }
   
   @Test(priority =4)
   
   public void Mypractice2() {
	   
	   
	   System.out.println("Hey my MyPractice2 Executed ......!!");

   }
   
   
   @Test(priority=-1)
   
   public void ContactSales() throws InterruptedException, IOException {
	   
	   driver.findElement(By.linkText("Gmail")).click();
	   
		  driver.findElement(By.partialLinkText("For")).click();
		  
		  
		  
		  
	String ActualTitle = driver.getTitle();
    	
    		
    		System.out.println(ActualTitle);
    		
    		
    		
    		String ExpectedTitle = "Gmail: Secure Enterprise Email for Business | Google  ";

    		//Assert.assertEquals(ExpectedTitle, ActualTitle);    //Assertion --> Hard Assert
    		
    		
    		//Soft Assert
    		SoftAssert softassertion = new SoftAssert();
    		softassertion.assertEquals(ActualTitle,ExpectedTitle,"Title  Matched !!"); 
    		
    		
    		System.out.println("PK");
    		System.out.println("OK");
    	
	

			//Take the screenshot
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);   //Import File . TakeScreenshot, OutputType ,FileUtils.
	        
	        //Copy the file to a location and use try catch block to handle exception
	    
	            FileUtils.copyFile(screenshot, new File("D:\\New folder (2)\\Nikhil.png"));
	            
	            
	           

		  System.out.println("My Above Code is Right");
		  driver.findElement(By.linkText("Contact sales")).click();
		  Thread.sleep(4000);
		  
		  driver.findElement(By.xpath("//*[@id=\"faq-list__item-1\"]/h4")).click();
		  
		  Select se56= new Select(driver.findElement(By.name("Number_of_Employees__c")));  //Select is class
		 	  
		  //se56.selectByIndex(1);
		  se56.selectByVisibleText("350-999");
		  
		  
		  
		  List<WebElement> allText = driver.findElements(By.name("Number_of_Employees__c"));
		  
		  for ( WebElement element: allText) {            //  For-each Loop or Enhanced For Loop
			    System.out.println(element.getText());

				softassertion.assertAll();
			    
		  }
   }
 @AfterMethod
 
 public void EndSession() {
	 
//driver.quit();
 }

}

