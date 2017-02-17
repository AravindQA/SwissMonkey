package Employer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EmployeeRegistration {
	
	
		public WebDriver d;
		
			
			@BeforeClass
			public void launchBrowser(){
				System.setProperty("d.gecko.driver","Users/aravind/Documents/workspace/SwissMonkey/geckodriver.exe");
				d = new FirefoxDriver();
			}
			
			@Test (priority =1)
			public void getpagetitle(){
				d.get("https://checkup.swissmonkey.co/");
				String title = d.getTitle();
				System.out.println(title);
			}
			//To check if the correct application opened
			@Test (priority =2)
			public void verifyPagetitle(){
				d.get("https://checkup.swissmonkey.co/");
				Assert.assertEquals("Swiss Monkey", d.getTitle());
				
			}
			
			//Login with valid credentials
			@Test (priority = 3)
			public void login() throws InterruptedException{
				Thread.sleep(6000);
				d.findElement(By.xpath(".//*[@id='main-landdingpage']/div[1]/div/div[1]/div/a")).click();
				Thread.sleep(11000);
				d.findElement(By.id("username")).sendKeys("sadmin@rapidbizapps.com");
				d.findElement(By.id("password")).sendKeys("123654789");
				d.findElement(By.id("submitlogin")).click();
				Thread.sleep(8000);
				String URL = d.getCurrentUrl();
				if(URL.equals("https://checkup.swissmonkey.co/dashboard")){
					System.out.println("Login Successful");
				}else {
					System.out.println("Login Failed");
				}
			
			}
			//Logout
			@Test (priority = 4)
			public void logout() throws InterruptedException{

				d.findElement(By.className("logout-li")).click();
				Thread.sleep(5000);
				String URL9 = d.getCurrentUrl();
				if(URL9.equals("https://checkup.swissmonkey.co/")){
					System.out.println("Logout successful");
				}else { 
					System.out.println("Logout failure");
				}
			}
				
				//Employer Registration navigation
				
				@Test(priority = 5)
				public void employerRegistrationpageNavigation() throws InterruptedException{
					
					d.findElement(By.xpath(".//*[@id='main-landdingpage']/div[1]/div/div[1]/div/a")).click();
					Thread.sleep(6000);
					d.findElement(By.xpath("html/body/div[2]/div[2]/form/div[5]/a[1]")).click();
					Thread.sleep(6000);
					String URL4 = d.getCurrentUrl();
					if(URL4.equals("https://checkup.swissmonkey.co/register")){
						System.out.println("Employer screen apperared");
					} else {
						System.out.println("Employer screen did not appeard");
					}
					Thread.sleep(5000);
					
				}
				
				//Employer Registration
				@Test (priority =6)
				public void employerRegistration() throws InterruptedException{
					d.findElement(By.name("name")).sendKeys("Aravindn");
					d.findElement(By.id("email")).sendKeys("aravind.313@gmail.com");
					d.findElement(By.name("password")).sendKeys("123456789");
					d.findElement(By.name("password2")).sendKeys("123456789");
					d.findElement(By.id("contact_name")).sendKeys("Bhavana");
					d.findElement(By.id("numbervalidation")).sendKeys("9491997292");
					d.findElement(By.id("addressLine1")).sendKeys("Image gardends");
					d.findElement(By.id("addressLine2")).sendKeys("27/34-34");
					d.findElement(By.name("city")).sendKeys("Hyderabad");
					d.findElement(By.name("state")).sendKeys("Telangana");
					d.findElement(By.name("zipcode")).sendKeys("500081");
					d.findElement(By.name("privacy_policies")).click();
					d.findElement(By.id("register")).click();
					Thread.sleep(5000);
					
					String ValidationAlert = d.findElement(By.xpath(".//*[@id='email_validate']")).getText();
					if(ValidationAlert.equals("Email already registered")){
						d.navigate().back();
					} else {
						
						String Alerttext=d.findElement(By.xpath(".//*[@id='msgModal']/div/div/div[2]/p")).getText();
						System.out.println(Alerttext);
						if(Alerttext.contains("Thank you for registering ")){
							System.out.println("Employer Registration - Successful");
							d.findElement(By.xpath(".//*[@id='msgModal']/div/div/div[3]/a/button")).click();
							
						} else {
							System.out.println("Employer Registration - Unsuccessful");
						}
						
						
					}
					
					
					
				}
				
				@Test(priority = 7)
				public void navigatebackafterRegistration() throws InterruptedException{
					
					Thread.sleep(5000);
					String URL3 = d.getCurrentUrl();
					System.out.println(URL3);
				}
				
				
			
				
			
			@AfterClass
			public void closeBrowser(){
				d.close();
				d.quit();
			}
		  }
