package tests;

import static extent.util.ExtentTestManager.startTest;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import extent.util.ExtentTestManager;
import io.qameta.allure.Allure;

public class SnipeITLoginTest extends BaseTest {


	@Test(priority = 0, description = "SnipeIT Login Scenario with valid cred.")
    public void validLoginTest(Method method) throws InterruptedException {

		startTest(method.getName(), "SnipeIT Valid Login");
		SnipITPage
		   .goToSnipeITHome()
		   .LoginToSnipeIT("admin","password")
		   .waitVisibility(SnipITPage.userLoginDropDown);
        Thread.sleep(3000);

        System.out.println("Taking screenshot of admin page");

        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getTest().log(Status.PASS, "Test Pass", ExtentTestManager.getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));


        Allure.addAttachment("base64Screenshot", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));

	}
}