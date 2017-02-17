package Employer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogincheckwithRegistereduser {
	
	public  WebDriver d;
	
	
	@BeforeClass
	public void launchB(){
		System.setProperty("d.gecko.driver","Users/aravind/Documents/workspace/SwissMonkey/geckodriver.exe");
		d = new FirefoxDriver();
	}
	
	//Login with newly registered user
	//Verify if login is successful or not.
	
	@Test(priority = 8)
	public void loginwithNewlyRegistereduser() throws InterruptedException{
		d.get("https://checkup.swissmonkey.co/");
		Thread.sleep(8000);
		d.findElement(By.xpath(".//*[@id='main-landdingpage']/div[1]/div/div[1]/div/a")).click();
		Thread.sleep(8000);
		d.findElement(By.id("username")).sendKeys("aravind.313@gmail.com");
		d.findElement(By.id("password")).sendKeys("123456789");
		d.findElement(By.id("submitlogin")).click();
		
		Thread.sleep(5000);
		String URL = d.getCurrentUrl();
		if(URL.equals("https://checkup.swissmonkey.co/dashboard")){
			System.out.println("Login Successful no jobs list present");
		}else if(URL.equals("https://checkup.swissmonkey.co/jobslist")){
			System.out.println("Login Successful and List of jobs present");
		}
		
		Thread.sleep(4000);
		/*String noJobs = d.findElement(By.xpath(".//*[@id='page-wrapper']/div[1]/div/div/div/p/strong")).getText();
		if(noJobs.contains("You have no jobs Posted yet.")){
			System.out.println("First time login");
		}else {
			System.out.println("Not a First time login");
		}*/
		
		//Git comment
		//MS recommendation
		
	}

@AfterClass
public void CloseBrowser(){
	d.close();
	d.quit();
}
}


