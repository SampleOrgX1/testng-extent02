package tests;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import extent.util.Log;
import io.qameta.allure.Attachment;
import pages.OrangeHomePage;
import pages.SnipITLoginPage;

public class BaseTest {
    public WebDriver driver;
    public OrangeHomePage  homePage;
    protected SnipITLoginPage SnipITPage;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void classLevelSetup() {
        Log.info("Tests is starting!");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @BeforeMethod
    public void methodLevelSetup() {
        homePage = new OrangeHomePage(driver);
        SnipITPage = new SnipITLoginPage(driver);
    }


    @Attachment(value = "{0}", type = "text/plain")
    private static String saveTextLog(String message) {
        return message;
    }
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }
//    private String getTestResult() {
//        return testResult;
//    }
//    private void setTestResult(String testResult) {
//        this.testResult = testResult;
//    }
    @Attachment(value = "Page screenshot", type = "image/png")
	protected byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }






    @AfterClass
    public void teardown() {
        Log.info("Tests are ending!");
//        driver.close();
        driver.quit();
    }
}
