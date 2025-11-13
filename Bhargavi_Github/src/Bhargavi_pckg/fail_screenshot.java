package Bhargavi_pckg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class fail_screenshot {
	public WebDriver driver;
	
	@BeforeTest
	  public void beforeTest() {
		 ChromeOptions options = new ChromeOptions();

		 Map<String, Object> prefs = new HashMap<String, Object>();

		 prefs.put("credentials_enable_service", false);

		 prefs.put("profile.password_manager_enabled", false);

		 prefs.put("profile.password_manager_leak_detection", false);

		 options.setExperimentalOption("prefs", prefs);

		 driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");
	  }

  @Test (priority = 0)
  public void Both_Values_Blank() throws InterruptedException {
	  
	  driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	  Thread.sleep(5000);
	  String Actual_Message01 = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
	  String Expected_Message01 = "Epic sadface: Username is required";
	  Assert.assertEquals(Actual_Message01, Expected_Message01);
  }
  @Test (priority = 1)

  public void Username_Blank() {

  driver.navigate().refresh();
  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
  driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
  String Actual_Message01 = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
  String Expected_Message01 = "Epic sadface: Username is required5";
  Assert.assertEquals(Actual_Message01, Expected_Message01);

  }

  @Test (priority = 2)

  public void Password_Blank() {

  driver.navigate().refresh();
  driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
  driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
  String Actual_Message2 = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
  String Expected_Message2 = "Epic sadface: Password is required9";
  Assert.assertEquals(Actual_Message2, Expected_Message2);

  }
  
  @Test(priority = 3)
  public void invalidusername() throws InterruptedException {

driver.navigate().refresh();
driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("Hani");
driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
Thread.sleep(5000);
   String actual_message=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
   String expect_message="Epic sadface: Username and password do not match any user in this service";
   Assert.assertEquals(actual_message, expect_message);

   }
  @Test(priority = 4)
  public void invalidpassword() throws InterruptedException {

driver.navigate().refresh();
driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Siddhi");
driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
Thread.sleep(5000);
   String actual_message=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
   String expect_message="Epic sadface: Username and password do not match any user in this service";
   Assert.assertEquals(actual_message, expect_message);

   }

  @Test (priority = 5)

  public void Both_Invalid() {

  driver.navigate().refresh();
  driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard");
  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("standard");
  driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
  String Actual_Message3 = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
  String Expected_Message3 = "Epic sadface: Username and password do not match any user in this service1";
  Assert.assertEquals(Actual_Message3, Expected_Message3);

  }
  @Test(priority = 6)
  public void specialorjunkcharecter() throws InterruptedException {
	  
  driver.navigate().refresh();
  driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("b&$>#");
  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("si*^$kl");
  driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
  Thread.sleep(5000);
     String actual_message=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
     String expect_message="Epic sadface: Username and password do not match any user in this service0";
     Assert.assertEquals(actual_message, expect_message);

       }
  @Test(priority = 7)
  public void casesensitive() throws InterruptedException {
  driver.navigate().refresh();
  driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("Standard_user");
  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Secret_sauce");
  driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
  Thread.sleep(5000);
     String actual_message=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
     String expect_message="Epic sadface: Username and password do not match any user in this service";
     Assert.assertEquals(actual_message, expect_message);

       }
  @Test(priority = 8)
  public void trim() throws InterruptedException {
driver.navigate().refresh();
driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("  standard_user ");
driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("   secret_sauce ");
driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
Thread.sleep(5000);
     String actual_message=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
     String expect_message="Epic sadface: Username and password do not match any user in this service";
     Assert.assertEquals(actual_message, expect_message);

       }
  
  @Test (priority = 9 )

  public void Both_valid() throws InterruptedException {

  driver.navigate().refresh();
  driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
  driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
  Thread.sleep(5000);
  driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
  Thread.sleep(5000);
  driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();

  }

  @AfterMethod

  public void Screenshot(ITestResult result) throws IOException {

  if(ITestResult.FAILURE==result.getStatus()) {

  TakesScreenshot screenshot=(TakesScreenshot)driver;

  File src=screenshot.getScreenshotAs(OutputType.FILE);

  FileUtils.copyFile(src, new File("C:\\Users\\hp\\OneDrive\\Desktop\\screenshot\\"+result.getName()+".png"));

  }

  }
  


  
  @AfterTest
  public void afterTest() {
  }

}
