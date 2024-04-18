package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IndeedTest {
	
	protected WebDriver driver;
	
	@BeforeTest()
	public void initTest() {
	 driver = new ChromeDriver();
	 driver.get("https://in.indeed.com/?r=us");
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test()
	public void loginTest() throws InterruptedException {
		driver.findElement(By.linkText("Sign in")).click();
		
		driver.findElement(By.id("ifl-InputFormField-ihl-useId-passport-webapp-1")).click();
	    driver.findElement(By.id("ifl-InputFormField-ihl-useId-passport-webapp-1")).clear();
	    driver.findElement(By.id("ifl-InputFormField-ihl-useId-passport-webapp-1")).sendKeys("joymika@yopmail.com");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(3000);
	    //driver.switchTo().newWindow(WindowType.TAB);
	    driver.findElement(By.name("__password")).click();
	    driver.findElement(By.name("__password")).sendKeys("Test@1234");
	    driver.findElement(By.xpath("//button[@data-tn-element='auth-page-sign-in-password-form-submit-button']")).click();
	    Thread.sleep(2000);
	    //driver.findElement(By.xpath("//button[contains(text(),'Skip for now')]")).click();
	    
	    
	    //
	    driver.findElement(By.id("AccountMenu")).click();
	    driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
	}
	
	@AfterTest()
	public void cleanUpTest() {
		
	}

}
