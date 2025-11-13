package Bhargavi_pckg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class saucedemo {
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
	
  @Test
  public void f() throws InterruptedException {
	  driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
	  driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
	  driver.findElement(By.xpath("//*[@id='login-button']")).click();
	  driver.findElement(By.xpath("//*[@id='react-burger-menu-btn']")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//*[@id='logout_sidebar_link']")).click();
	 
  }
 
  @AfterTest
  public void afterTest() {
  }

}
