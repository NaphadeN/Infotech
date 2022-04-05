package DEC;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazon {

	public static void main(String[] args) {


			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

			WebDriver driver = new ChromeDriver(); //WebDriver is an interface and all the methods which are declared in Webdriver interface are implemented by respective driver class.
	                                               //ChromeDriver() is a Constructor, new is a keyword, and new ChromeDriver() is an Object.
			driver.manage().window().maximize();
			
			driver.manage().deleteAllCookies();
			

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit Wait

			driver.get("http://amazon.in");
			
			
			driver.findElement(By.linkText("Bus tickets")).click();
	
	
			
			
			String parent=driver.getWindowHandle();

			Set<String>s=driver.getWindowHandles();

			// Now iterate using Iterator
			Iterator<String> I1= s.iterator();

			while(I1.hasNext())
			{

			String child_window=I1.next();

System.out.println("1");
			

			if(!parent.equals(child_window))
			{
				
			driver.switchTo().window(child_window);
			driver.findElement(By.name("email")).sendKeys("nikhil");

			System.out.println(driver.switchTo().window(child_window).getTitle());

			driver.close();
			}

			}
			//switch to the parent window
			driver.switchTo().window(parent);

		

	}

}
