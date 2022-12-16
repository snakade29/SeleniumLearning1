package seleniumlearning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/*
1) Launch browser
2) open url
	https://opensource-demo.orangehrmlive.com/
3) Provide username  - Admin
4) Provide password  - admin123
5) Click on Login button 
6) Verify the title of dashboard page   
	Exp title : OrangeHRM
7) close browser

 */
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		
		//1) Launch browser
		//ChromeDriver driver=new ChromeDriver();
		WebDriver driver=new ChromeDriver();
		
		//2) open url on the browser
	     driver.get("https://demo.actitime.com/login.do");
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize(); // maximize the page
		
		
		
		//3) Provide username  - Admin
	    driver.findElement(By.id("username")).sendKeys("admin");
	  
	       
	      
	      
		
	 
		
		 
	 
		
		//4) Provide password  - 
	        driver.findElement(By.name("pwd")).sendKeys("manager");
		
		//5) Click on  Login button 
	        driver.findElement(By.xpath("//div[text()='Login ']")).click();
		 
		
		//6) Verify the title of dashboard page   
	
	       String act_title =driver.getTitle();
	       System.out.println(act_title);
	        
	        String exp_title ="actiTIME - Login";
		
		if(act_title.equals(exp_title))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("failed");
		}
 
		
		// Lable validation after successful login
		String act_label = "";
		try
		{
		act_label=driver.findElement(By.xpath("//td[text()='Enter Time-Track']")).getText();
		}
		catch(NoSuchElementException e)	{ 
			}
		
		String exp_label="Enter Time-Track";
		
		if(act_label.equals(exp_label))
		{
			System.out.println("test passed");
		}
		else
		{
			System.out.println("test failed");
		}
		
		//7) close browser
		//driver.close();
		driver.quit();
		
	}

}
