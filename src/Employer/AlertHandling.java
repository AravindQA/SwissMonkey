package Employer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AlertHandling {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver d = new FirefoxDriver();
		d.get("https://checkup.swissmonkey.co/");
		Thread.sleep(5000);
		d.findElement(By.xpath(".//*[@id='main-landdingpage']/div[1]/div/div[1]/div/a")).click();
		Thread.sleep(5000);
		d.findElement(By.xpath("html/body/div[2]/div[2]/form/div[5]/a[1]")).click();
		Thread.sleep(5000);
		d.findElement(By.name("name")).sendKeys("AravindB");
		d.findElement(By.id("email")).sendKeys("aravind.311@gmail.com");
		d.findElement(By.name("password")).sendKeys("123456789");
		d.findElement(By.name("password2")).sendKeys("123456789");
		d.findElement(By.id("contact_name")).sendKeys("Bhavan");
		d.findElement(By.id("numbervalidation")).sendKeys("9491999297");
		d.findElement(By.id("addressLine1")).sendKeys("Image gardends");
		d.findElement(By.id("addressLine2")).sendKeys("27/34-34");
		d.findElement(By.name("city")).sendKeys("Hyderabad");
		d.findElement(By.name("state")).sendKeys("Telangana");
		d.findElement(By.name("zipcode")).sendKeys("500081");
		d.findElement(By.name("privacy_policies")).click();
		d.findElement(By.id("register")).click();
		Thread.sleep(3000);
		String u=d.findElement(By.xpath(".//*[@id='msgModal']/div/div/div[2]/p")).getText();
		System.out.println(u);
		if(u.contains("Thank you for registering ")){
			System.out.println("Employer Registration - Successful");
		} else {
			System.out.println("Employer Registration - Unsuccessful");
		}
	}
	}


	


