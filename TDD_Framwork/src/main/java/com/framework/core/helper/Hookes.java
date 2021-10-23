package com.framework.core.helper;
import com.framework.core.browser.WebDriverManager;
import com.framework.core.component.WebComponents;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.annotations.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Hookes  implements ITestListener
{
        public WebDriver driver;

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName(); //ValidateShoppingCart();
    }
    @Override
    public void onTestStart(ITestResult result)
    {
        ExtentTestManager.startTest(getTestMethodName(result),"");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        try {
            String base64 = WebComponents.captureSnapshot(getTestMethodName(result), WebDriverManager.GetrealWebDriver().get());
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed");
            ExtentTestManager.getTest().log(LogStatus.FAIL,
                    ExtentTestManager.getTest().addBase64ScreenShot(base64));
        }catch(Exception e) {

        }

    }
    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test SKIPPED");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentTestManager.stopTest();
        ExtentManager.getReports().flush();

    }

        @BeforeSuite
        public void setUpEnvironment() throws Exception
        {
            Configs.initilizeEnvironmentProperties(); //Initializing application properties
        }

        @BeforeTest()
        public void setUpTestConfig()
        {

        }

        @BeforeMethod
        public void initBrowser() throws Exception
        {

            System.out.println("Browser is :" + Configs.browser);
            System.out.println("Environment is :" + System.getProperty("envName"));
            WebDriverManager driverManager= new WebDriverManager();
            driverManager.initializeWebdriver();  // Initializing driver so that it is available to all the classes
            driver= WebDriverManager.GetrealWebDriver().get();
            driver.get(Configs.AppUrl);
           // driver.get("https://Google.com");
        }

        @AfterMethod
        public void tearDownBrowser()
        {
            driver.close();  //closing only current the browser
        }

        @AfterTest()
        public void tearDownTest()
        {

        }

        //release all the object so they can be ready for garbage collection(like flush out the database or reports
        @AfterSuite()
        public void tearDownEnrironment()
        {
            driver.quit();  //distroy the driver and close all the browser
        }


}
