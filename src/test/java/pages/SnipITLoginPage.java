package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SnipITLoginPage extends BasePage{

	WebDriver driver;

	public SnipITLoginPage(WebDriver driver) {
		super(driver);
	    this.driver=driver;
	}


	//Variables
    String baseURL = "https://demo.snipeitapp.com/login";

    // Web Elements
    By username = By.name("username");
    By password = By.name("password");
    By signInButtonClass = By.xpath("//button[contains(text(),'Login')]");
    public By userLoginDropDown =By.cssSelector("li.dropdown.user.user-menu");


    public SnipITLoginPage goToSnipeITHome() {
    	this.driver.get(baseURL);
    	return this;
    }


    public SnipITLoginPage LoginToSnipeIT(String uname,String pwd) {

    	this.driver.findElement(username).sendKeys(uname);
    	this.driver.findElement(password).sendKeys(pwd);
    	this.driver.findElement(signInButtonClass).click();
    	return this;
    }





}
