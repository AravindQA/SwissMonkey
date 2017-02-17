package Employer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PostaJob {
	
	public WebDriver d;
	
	@BeforeClass
	public void launchBrowser(){
		System.setProperty("d.gecko.driver","Users/aravind/Documents/workspace/SwissMonkey/geckodriver.exe");
		d = new FirefoxDriver();
	}
	
	@Test(priority=11)
	public void logintoPostaJob() throws InterruptedException{
		
		
		d.get("https://checkup.swissmonkey.co/");
		Thread.sleep(5000);
		d.findElement(By.xpath(".//*[@id='main-landdingpage']/div[1]/div/div[1]/div/a")).click();
		Thread.sleep(5000);
		d.findElement(By.id("username")).sendKeys("aravind.313@gmail.com");
		d.findElement(By.id("password")).sendKeys("123456789");
		d.findElement(By.id("submitlogin")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority =12)
	public void NavigationToPostJob() throws InterruptedException{
		d.findElement(By.xpath(".//*[@id='post']/button")).click();
		Thread.sleep(5000);
		String URL8 = d.getCurrentUrl();
		if(URL8.equals("https://checkup.swissmonkey.co/postjob")){
			System.out.println("Screen navigated to post a job screen");
		} else {
			System.out.println("Screen did not navigate to post a job screen");
		}
		
	}
	
	@Test(priority=13)
	public void EnteringDetailsInPostJobScreen() throws InterruptedException{
		d.findElement(By.name("company_id")).sendKeys("Madhapur-image gardens, 234/453");
		Select dropdown = new Select(d.findElement(By.id("position")));
		dropdown.selectByVisibleText("Orthodontist");
		Thread.sleep(4000);
		
		
		d.findElement(By.name("filldate")).click();
		d.findElement(By.xpath("html/body/div[3]/div[1]/table/tbody/tr[2]/td[3]")).click();
		
		
		
		
		
		
		Select jobtype = new Select(d.findElement(By.id("jobtype")));
		jobtype.selectByVisibleText("Temporary");
		
		
		//d.findElement(By.xpath("html/body/div[3]/div[1]/table/tbody/tr[4]/td[4]")).click();
		d.findElement(By.id("01")).click();
		Thread.sleep(3000);
		d.findElement(By.id("02")).click();
		Thread.sleep(2000);
		d.findElement(By.id("03")).click();
		Thread.sleep(2000);
		d.findElement(By.id("21")).click();
		Thread.sleep(2000);
		d.findElement(By.id("22")).click();
		Thread.sleep(2000);
		d.findElement(By.id("23")).click();
		Thread.sleep(2000);
		
		Select expdropdown = new Select(d.findElement(By.name("experience")));
		expdropdown.selectByVisibleText("5 Years");
		
		Thread.sleep(6000);
		
		d.findElement(By.xpath(".//*[@id='job-details-form']/div/div[16]/dl/dt/a/span")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath(".//*[@id='job-details-form']/div/div[16]/dl/dd/div/ul/li[1]/input")).click();
		Thread.sleep(4000);
		d.findElement(By.xpath(".//*[@id='job-details-form']/div/div[16]/dl/dd/div/ul/li[3]/input")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath(".//*[@id='job-details-form']/div/div[16]/dl/dd/div/ul/li[17]")).click();
		Thread.sleep(4000);
		d.findElement(By.xpath(".//*[@id='job-details-form']/div/div[16]/dl/dt/a/p/span[2]")).click();
		Thread.sleep(3000);
		Select resume = new Select(d.findElement(By.name("resume")));
		resume.selectByVisibleText("No");
		Thread.sleep(3000);
		Select resumeRequired = new Select(d.findElement(By.name("recommendation_letter")));
		resumeRequired.selectByVisibleText("No");
		
		//d.findElement(By.name("recommendation_letter")).click();
		Thread.sleep(5000);
		
		d.findElement(By.xpath(".//*[@id='job-details-form']/div/div[25]/div/button")).click();
		d.findElement(By.xpath(".//*[@id='job-details-form']/div/div[25]/div/div/ul/li[5]/a/span[1]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath(".//*[@id='job-details-form']/div/div[25]/div/button")).click();
		Thread.sleep(4000);
		
		//WebElement SalaryRadioButton = d.findElement(By.xpath(".//*[@id='compensation']"));
		//SalaryRadioButton.click();
		
		d.findElement(By.xpath("html/body/div[2]/div[1]/div/div[1]/div[1]/div[3]/div[1]/form/div/div[28]/div/ul/li[4]/input")).click();
		
		
		Thread.sleep(5000);
		
		d.findElement(By.name("from_compensationRange")).sendKeys("1000");
		Thread.sleep(3000);
		d.findElement(By.name("to_compensationRange")).sendKeys("5000");
		
		Thread.sleep(3000);
		d.findElement(By.name("jobDescription")).sendKeys("Test Job");
		d.findElement(By.name("photos")).click();
		d.findElement(By.name("videos")).click();
		
		d.findElement(By.xpath(".//*[@id='job-details-form-buttons']/a")).click();
		
		Thread.sleep(5000);
		 ((JavascriptExecutor)d).executeScript("scroll(0,800)");
		 
		 Thread.sleep(7000);
		 //d.findElement(By.xpath(".//*[@id='jobDetailNext']")).click();
		 d.findElement(By.id("jobDetailNext")).click();
		 Thread.sleep(7000);
		 System.out.println("Navigation pass");
		 Thread.sleep(2000);
		 
		 //Select pricing
		 
		 String Payment = d.getCurrentUrl();
		 Thread.sleep(2000);
		 System.out.println(Payment);
		 
		 Thread.sleep(5000);
		 Boolean x = d.findElement(By.xpath(".//*[@id='job-pricing']/div[2]")).isDisplayed();
		 System.out.println(x);
		 
		 
		
		 d.findElement(By.id("selectpricing")).click();
		 Thread.sleep(3000);
		 
		String xy = d.findElement(By.xpath(".//*[@id='selectpricing']")).getText();
		System.out.println(xy);
		
		if(xy.equals("Selected")) {
			System.out.println("Pass");
			d.findElement(By.id("movetopayment")).click();
			Thread.sleep(4000);
			
		} else {
			System.out.println("fail");
		}
		
		//Payment
		
		((JavascriptExecutor)d).executeScript("scroll(0,800)");
		Thread.sleep(4000);
		Boolean savecard = d.findElement(By.name("save_card")).isEnabled();
		System.out.println(savecard);
		
		if(savecard == true){
			System.out.println("details are in place");
			Thread.sleep(5000);
			d.findElement(By.name("pay_through_card")).click();
			Thread.sleep(2000);
			Boolean autoRenewe=	d.findElement(By.xpath(".//*[@id='payment-form']/div[2]/div[4]/div/label/div[1]")).isEnabled();
			System.out.println(autoRenewe +"- followed by execution");
			Thread.sleep(4000);
			if(autoRenewe == true){
				d.findElement(By.xpath(".//*[@id='payment-form']/div[2]/div[4]/div/label/div[2]")).click();
			} else {
				System.out.println("already enabled");
			}
			d.findElement(By.id("submitBtn")).click();
		} else {
			
		
			((JavascriptExecutor)d).executeScript("scroll(800, 0)");
			d.findElement(By.name("address_zip")).sendKeys("500081");
			d.findElement(By.name("cardnumber")).sendKeys("4242424242424242");
			d.findElement(By.name("exp_month")).sendKeys("11");
			d.findElement(By.name("exp_year")).sendKeys("2017");
			d.findElement(By.name("cvv")).sendKeys("123");
			d.findElement(By.name("save_card")).click();
			Boolean autoRenewe=	d.findElement(By.className("onoffswitch-inner")).isEnabled();
			if(autoRenewe==true){
				d.findElement(By.xpath(".//*[@id='payment-form']/div[2]/div[3]/div/label/div[2]")).click();
			} else {
				System.out.println("already enabled");
			}
			d.findElement(By.id("submitBtn")).click();
		}
		
			
			Thread.sleep(6000);
			
			//Payment successful
			String paymentsuccess = d.findElement(By.className("modal-message")).getText();
			if(paymentsuccess.contains("Payment Successful. Your job has been posted.")){
				System.out.println("Payment successful");
				d.findElement(By.xpath(".//*[@id='modal-activate']")).click();
				Thread.sleep(3000);
			} else {
				System.out.println("payment failed");
			}
			
	}
	
	
	
	@AfterClass
	public void closeBrowser(){
		d.close();
		d.quit();
	}
}



