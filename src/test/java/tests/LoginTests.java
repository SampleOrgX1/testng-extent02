package tests;

import java.lang.reflect.Method;
import java.util.Objects;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import extent.util.ExtentTestManager;

import static extent.util.ExtentTestManager.startTest;;


public class LoginTests extends BaseTest {

	
	@Test(priority = 0, description = "valid Login Scenario with wrong username and password.")
    public void validLoginTest(Method method) throws InterruptedException {
    
		startTest(method.getName(), "valid Login Scenario with invalid username and password.");
        homePage.goToN11().LoginToApp();
        Thread.sleep(7000);
        
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getTest().log(Status.PASS, "Test Pass", ExtentTestManager.getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));           
    }
}