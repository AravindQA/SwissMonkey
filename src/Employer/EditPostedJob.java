package Employer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EditPostedJob {
	
	public WebDriver d;
	
	@BeforeClass
	public void launchBrowser(){
		System.setProperty("d.gecko.driver","Users/aravind/Documents/workspace/SwissMonkey/geckodriver.exe");
		d = new FirefoxDriver();
	}
	
	@Test(priority=14)
	public void loginToEditPostJob() throws InterruptedException{
		
		
		d.get("https://checkup.swissmonkey.co/");
		Thread.sleep(4000);
		d.findElement(By.xpath(".//*[@id='main-landdingpage']/div[1]/div/div[1]/div/a")).click();
		Thread.sleep(4000);
		d.findElement(By.id("username")).sendKeys("aravind.313@gmail.com");
		d.findElement(By.id("password")).sendKeys("123456789");
		d.findElement(By.id("submitlogin")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority =15)
	public void NavigatingToEditapostedJob() throws InterruptedException{
		
		//((JavascriptExecutor)d).executeScript("scroll(0,600)");
		Thread.sleep(5000);
		d.findElement(By.xpath(".//*[@id='626']/img")).click();
		Thread.sleep(5000);
		String URL18 = d.getCurrentUrl();
		Thread.sleep(4000);
		if(URL18.equals("https://checkup.swissmonkey.co/editjob/626")){
			System.out.println("Screen navigated to Edit job screen");
		} else {
			System.out.println("Screen did not navigate to edit job screen");
		}
		
	}
	
	@Test(priority=16)
	public void EditingTheExistingpostJobDetails() throws InterruptedException{
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Select profileSelect = new Select (d.findElement(By.className("material-input")));
		profileSelect.selectByValue("104");
		
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select dropdown = new Select(d.findElement(By.id("position")));
		dropdown.selectByVisibleText("Hygienist");
		
		
		Thread.sleep(4000);
		d.findElement(By.xpath(".//*[@id='datepicker']/span[2]/img")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("html/body/div[3]/div[1]/table/tbody/tr[3]/td[7]")).click();
		Thread.sleep(3000);
		
		Select jobtype = new Select(d.findElement(By.id("jobtype")));
		jobtype.selectByVisibleText("Part-time");
		
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//d.findElement(By.xpath("html/body/div[3]/div[1]/table/tbody/tr[4]/td[4]")).click();
		d.findElement(By.id("11")).click();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.findElement(By.id("12")).click();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.findElement(By.id("13")).click();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.findElement(By.id("31")).click();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.findElement(By.id("32")).click();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.findElement(By.id("33")).click();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Select expdropdown = new Select(d.findElement(By.name("experience")));
		expdropdown.selectByVisibleText("3 Years");
		
		System.out.println("Name pass");
		Thread.sleep(6000);
		
		//Scroll the page
		
		/*Object selenium;
		((Object) selenium).getEval("scrollBy(0, 350)");*/
		
		((JavascriptExecutor)d).executeScript("scroll(0,450)");
		
		d.findElement(By.xpath(".//*[@id='job-details-form']/div/div[16]/dl/dt/a/span")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath(".//*[@id='job-details-form']/div/div[16]/dl/dd/div/ul/li[5]/input")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath(".//*[@id='job-details-form']/div/div[16]/dl/dd/div/ul/li[7]/input")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath(".//*[@id='job-details-form']/div/div[16]/dl/dt/a/span")).click();
		Thread.sleep(3000);
		
		System.out.println("Practice software exp");
		Select resume = new Select(d.findElement(By.name("resume")));
		resume.selectByVisibleText("Yes");
		Thread.sleep(3000);
		
		Select resumeRequired = new Select(d.findElement(By.name("recommendation_letter")));
		resumeRequired.selectByVisibleText("Yes");
		
		//d.findElement(By.name("recommendation_letter")).click();
		Thread.sleep(4000);
		System.out.println("Recommendation selected");
		
		
		d.findElement(By.xpath(".//*[@id='job-details-form']/div/div[26]/div/button")).click();
		d.findElement(By.xpath(".//*[@id='job-details-form']/div/div[26]/div/div/ul/li[3]/a/span[1]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath(".//*[@id='job-details-form']/div/div[26]/div/button")).click();
		Thread.sleep(4000);
		System.out.println("additional skill selected");
		
		/*WebElement SalaryRadioButton = d.findElement(By.xpath(".//*[@id='compensation']"));
		SalaryRadioButton.click();*/
		Thread.sleep(5000);
		
		d.findElement(By.xpath(".//*[@id='compensation' AND @value = '3']")).click();
		//d.findElement(By.xpath("html/body/div[2]/div[1]/div/div[1]/div[1]/div[3]/div[1]/form/div/div[28]/div/ul/li[4]/input")).click();
		//d.findElement(By.xpath(".//*[@id='job-details-form']/div/div[29]/div/ul/li[2]")).click();
		
		
		
		System.out.println("Salary type selected");
		
		Thread.sleep(4000);
		d.findElement(By.name("from_compensationRange")).clear();
		d.findElement(By.name("from_compensationRange")).sendKeys("2500");
		Thread.sleep(3000);
		d.findElement(By.name("to_compensationRange")).clear();
		d.findElement(By.name("to_compensationRange")).sendKeys("6000");
		
		Thread.sleep(3000);
		d.findElement(By.name("jobDescription")).clear();
		d.findElement(By.name("jobDescription")).sendKeys("Previously posted job has been modified");
		d.findElement(By.name("photos")).click();
		d.findElement(By.name("videos")).click();
		
		
		 d.findElement(By.id("postJob")).click();
		 
		 d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
/*@AfterClass
public void closeBrowser(){
	d.close();
	d.quit();
}*/
}
