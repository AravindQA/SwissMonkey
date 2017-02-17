package Employer;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Coordinates {
	public WebDriver d;
	
	@BeforeClass
	public void launc(){
	System.setProperty("d.gecko.driver","Users/aravind/Documents/workspace/SwissMonkey/geckodriver.exe");
	d = new FirefoxDriver();
	
	}
	
	@Test
	 public void getCoordinates() throws Exception {
		
		//Launch and Login
		
		d.get("https://checkup.swissmonkey.co/");
		Thread.sleep(6000);
		d.findElement(By.xpath(".//*[@id='main-landdingpage']/div[1]/div/div[1]/div/a")).click();
		
		Thread.sleep(5000);
		d.findElement(By.id("username")).sendKeys("aravind.313@gmail.com");
		d.findElement(By.id("password")).sendKeys("123456789");
		d.findElement(By.id("submitlogin")).click();
		Thread.sleep(5000);
		
		//Edit job 
		
		d.findElement(By.xpath(".//*[@id='610']/img")).click();
		Thread.sleep(5000);
		String URL18 = d.getCurrentUrl();
		Thread.sleep(4000);
		if(URL18.equals("https://checkup.swissmonkey.co/editjob/610")){
			System.out.println("Screen navigated to Edit job screen");
		} else {
			System.out.println("Screen did not navigate to edit job screen");
		}
		
		
		
		
	  //Locate element for which you wants to retrieve x y coordinates.
	        WebElement Image = d.findElement(By.xpath(".//*[@id='job-details-form']/div/div[16]/dl/dt/a/span"));
	        
	        //Used points class to get x and y coordinates of element.
	        Point point = Image.getLocation();
	        int xcord = point.getX();
	        System.out.println("Element's Position from left side Is "+xcord +" pixels.");
	        int ycord = point.getY();
	        System.out.println("Element's Position from top side Is "+ycord +" pixels.");
	 }
	}


