package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import extent.util.Log;

public class HomePage extends BasePage {

	WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver =driver;
    }

    //Variables
    String baseURL = "https://opensource-demo.orangehrmlive.com/";

    // Web Elements
    By username = By.name("username");
    By password = By.name("password");
    By signInButtonClass = By.xpath("//div[contains(@class,'orangehrm-login-action')]/button");


    // Page Methods
    //Go to Homepage
    public HomePage goToN11() {
        Log.info("Opening HRM Website.");
        driver.get(baseURL);
        return this;
    }

    public HomePage LoginToApp() throws InterruptedException {
    	Log.info("user enter data");
    	writeText(username, "Admin");
    	writeText(password, "admin123");
    	Thread.sleep(4000);
    	driver.findElement(signInButtonClass).click();
    	Thread.sleep(4000);
    	return this;
    }


}
