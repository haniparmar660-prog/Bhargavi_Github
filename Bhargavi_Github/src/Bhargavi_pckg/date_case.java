package Bhargavi_pckg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class date_case {
	public WebDriver driver;
	
	@BeforeTest
	  public void beforeTest() { 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(" https://demo.guru99.com/test/");
	  }
  
 @Test
  public void f() { 
	 WebElement dateBox = driver.findElement(By.xpath("/html/body/form/input[1]"));
	 dateBox.sendKeys("2912");
	 dateBox.sendKeys("2004");
	 dateBox.sendKeys(Keys.TAB);
	 dateBox.sendKeys("0251PM");
	 driver.findElement(By.xpath("/html/body/form/input[2]")).click();
	 
	 
	 String actual_message=driver.findElement(By.xpath("/html/body/div[2]")).getText();
	 String expect_message="Your Birth Date is 2004-12-29\n"
	 		+ "Your Birth Time is 02:51";
	 Assert.assertEquals(actual_message, expect_message);
	 
  }
  
  @AfterTest
  public void afterTest() {
  }

}
