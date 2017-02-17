package Employer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class AddAnotherProfile {

	public  WebDriver d;
	
	
	@BeforeClass
	public void launchB() throws InterruptedException{
		//System.setProperty("d.chrome.driver", "/Users/aravind/Documents/workspace/SwissMonkey/chromedriver.exe");
		//d = new ChromeDriver();
		
		
		System.setProperty("d.gecko.driver","Users/aravind/Documents/workspace/SwissMonkey/geckodriver.exe");
		d = new FirefoxDriver();
	}
	
	
	
	@Test(priority = 20)
	public void addnewProfileInPracticeProfileScreen() throws InterruptedException{
		d.get("https://checkup.swissmonkey.co/");
		Thread.sleep(10000);
		d.findElement(By.xpath(".//*[@id='main-landdingpage']/div[1]/div/div[1]/div/a")).click();
		
		Thread.sleep(5000);
		d.findElement(By.id("username")).sendKeys("aravind.313@gmail.com");
		d.findElement(By.id("password")).sendKeys("123456789");
		d.findElement(By.id("submitlogin")).click();
		Thread.sleep(5000);
		
		//Practice profile
		
		d.findElement(By.className("my-profile-li")).click();
		Thread.sleep(3000);
		d.findElement(By.id("btnAdd")).click();
		Thread.sleep(3000);
		d.findElement(By.name("practicename")).sendKeys("Harsha");
		d.findElement(By.name("practicenameanonymous")).click();
		d.findElement(By.id("address_1")).sendKeys("VSKP");
		d.findElement(By.id("city")).sendKeys("VIZAG");
		d.findElement(By.name("state")).sendKeys("Andhra Pradesh");
		d.findElement(By.name("zipcode")).sendKeys("500081");
		
		//Primary contact info
		d.findElement(By.name("name")).sendKeys("Aravind");
		d.findElement(By.id("empemail")).sendKeys("aravind.313@gmail.com");
		d.findElement(By.id("numbervalidation")).sendKeys("9491927292");
		
		//About the Practice
		
		Select DigitalXRays = new Select (d.findElement(By.name("xrays")));
		DigitalXRays.selectByVisibleText("Yes");
		
		d.findElement(By.name("totalDoctors")).sendKeys("3");
		d.findElement(By.name("totaloperatories")).sendKeys("4");
		d.findElement(By.name("appointmentLength")).sendKeys("30MIN");
		
		//Register button
		
		d.findElement(By.id("register")).click();

	
	}
}
