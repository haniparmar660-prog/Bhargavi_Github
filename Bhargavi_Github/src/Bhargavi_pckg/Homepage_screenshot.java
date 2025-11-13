package Bhargavi_pckg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;

public class Homepage_screenshot {
	public WebDriver driver;
	
	 @BeforeTest
	  public void beforeTest() {
		 driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");
		 
	  }
  @Test
  public void f() throws IOException {
	  File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
  FileUtils.copyFile(screenshot, new File("C:\\Users\\hp\\OneDrive\\Desktop\\screenshot\\screenshot.png"));
	 
  }
  

  @AfterTest
  public void afterTest() {
  }

}
