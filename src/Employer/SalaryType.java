package Employer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SalaryType {
	
public  WebDriver d;
	
	
	@BeforeClass
	public void launchB(){
		System.setProperty("d.gecko.driver","Users/aravind/Documents/workspace/SwissMonkey/geckodriver.exe");
		d = new FirefoxDriver();
	}
	
	//Login with newly registered user
	//Verify if login is successful or not.
	
	@Test(priority = 80)
	public void loginwithNewlyRegistereduser() throws InterruptedException{
		d.get("https://checkup.swissmonkey.co/");
		Thread.sleep(8000);
		d.findElement(By.xpath(".//*[@id='main-landdingpage']/div[1]/div/div[1]/div/a")).click();
		Thread.sleep(8000);
		d.findElement(By.id("username")).sendKeys("aravind.313@gmail.com");
		d.findElement(By.id("password")).sendKeys("123456789");
		d.findElement(By.id("submitlogin")).click();
		
		Thread.sleep(5000);
		d.findElement(By.xpath(".//*[@id='post']/button")).click();
		Thread.sleep(5000);
		String URL8 = d.getCurrentUrl();
		if(URL8.equals("https://checkup.swissmonkey.co/postjob")){
			System.out.println("Screen navigated to post a job screen");
		} else {
			System.out.println("Screen did not navigate to post a job screen");
		}
		((JavascriptExecutor)d).executeScript("scroll(0,700)");
		Thread.sleep(4000);
		d.findElement(By.xpath("html/body/div[2]/div[1]/div/div[1]/div[1]/div[3]/div[1]/form/div/div[28]/div/ul/li[2]/input")).click();
		//d.findElement(By.xpath(".//*[@id='job-details-form']/div/div[29]/div/ul/li[2]")).click();
		System.out.println("Salary type selected");
	}
}
