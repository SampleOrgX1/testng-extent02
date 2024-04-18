package tests;

import static extent.util.ExtentTestManager.startTest;

import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import extent.util.ExtentTestManager;;


public class LoginTests extends BaseTest {


	@Test(priority = 0, description = "Orange Valid Login Test")
    public void validLoginTest(Method method) throws InterruptedException {

		startTest(method.getName(), "Orange Valid Login Test");
        homePage.goToN11().LoginToApp();
        Thread.sleep(7000);

        System.out.println("Taking screenshot of admin page");

        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getTest().log(Status.PASS, "Test Pass", ExtentTestManager.getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));

       ExtentTestManager.getTest().info("Some Test case");
	}
}