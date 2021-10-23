package com.framework.core.component;
import com.framework.core.browser.WebDriverManager;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.framework.core.helper.ExtentManager;
import com.framework.core.helper.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import freemarker.template.utility.NullArgumentException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebComponents
{
    WebDriver driver;
    String pageName = "";

    public WebComponents(String pageName) {
        this.pageName = pageName;
        driver = WebDriverManager.GetrealWebDriver().get();
    }

    public void launchWebPage(String url) {
        try {
            driver.get(url);
            ExtentTestManager.getTest().log(LogStatus.INFO, "Launch WebPage [" + url + "]");
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR,
                    "Unable to launch WebPage [" + url + "]");
            throw e;
        }
    }

    public void clickElement(String elementName) throws Exception
    {
        try {
            ElementFinder elementFinder = new ElementFinder();
            WebElement element = elementFinder.findElementByXpath(elementName, pageName);
            // driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
            element.click();
            ExtentTestManager.getTest().log(LogStatus.INFO,
                    "Clicked Element [" + elementName + "] successfully");
        } catch (NullArgumentException e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR,
                    "Unable to click an element [" + elementName + "]");
            throw e;

        }
    }

    public List<WebElement> getElemenstList(String elementName) throws Exception
    {

        try
        {
            ElementFinder elementFinder = new ElementFinder();
            List<WebElement> elementList = elementFinder.findElementListByXpath(elementName, pageName);
            return elementList;
        }
        catch(Exception e)
        {
            throw e;
        }
    }

    public void clearField(String elementName) throws Exception
    {
        try
        {
            ElementFinder elementFinder = new ElementFinder();
            WebElement element = elementFinder.findElementByXpath(elementName, pageName);
            element.clear();
            ExtentTestManager.getTest().log(LogStatus.INFO,
                    "Cleared Element [" + elementName + "] successfully");
        }
        catch (Exception e)
        {
            ExtentTestManager.getTest().log(LogStatus.ERROR,
                    "Unable to clear element [" + elementName + "]");
            throw e;
        }

    }

    public void typeInto(String elementName, String valuesToType) throws Exception {
        try {
            ElementFinder elementFinder = new ElementFinder();
            WebElement element = elementFinder.findElementByXpath(elementName, pageName);
            clickElement(elementName);
            Thread.sleep(200);
            clearField(elementName);
            Thread.sleep(200);
            element.sendKeys(valuesToType);
            ExtentTestManager.getTest().log(LogStatus.INFO,
                    "Entered value [" + valuesToType + "]  for element [" + elementName + "]");
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR, "Unable to enter value ["
                    + valuesToType + "]  for element [" + elementName + "]");
            throw e;
        }

    }

    public String getElementText(String elementName) throws Exception {
        try {
            ElementFinder elementFinder = new ElementFinder();
            WebElement element = elementFinder.findElementByXpath(elementName, pageName);
            return element.getText();
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR,
                    "Unable to fetch text for an element [" + elementName + "]");
            throw e;
        }

    }

    public void MouseHoverElement(String elementName) throws Exception {
        ElementFinder elementFinder = new ElementFinder();
        WebElement element = elementFinder.findElementByXpath(elementName, pageName);
        // driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();

    }

    public void SelectWindow(String elementName) throws Exception {
        try {

            WebElement aa = driver.findElement(By.xpath("//iframe[@class='fancybox-iframe']"));
            driver.switchTo().frame(aa);
            ElementFinder elementFinder = new ElementFinder();
            WebElement element = elementFinder.findElementByXpath(elementName, pageName);
            element.click();
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            System.out.println("File to switch");
        }
    }


    public String handleWindows(String elementName) throws Exception {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it= windows.iterator();
        String parent = it.next();
        String child = it.next();
        driver.switchTo().window(child);
        String cardNumber= getElementText(elementName); return cardNumber; }


    public String selectFromDDL(String elementName, String selectByValue) throws Exception
    {
        try {
            ElementFinder elementFinder = new ElementFinder();
            WebElement element = elementFinder.findElementByXpath(elementName, pageName);
            Select dropdown = new Select(element);
            dropdown.selectByValue(selectByValue);
            String selecteditem = dropdown.getFirstSelectedOption().getText();
            return selecteditem;

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return null;

    }

    public static String captureSnapshot(String testName, WebDriver driver) throws Exception {
        ThreadLocal<String> path = new ThreadLocal<String>();
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        String snapshotFile = "data:image/png;base64,"
                + screenshot.getScreenshotAs(OutputType.BASE64);
        path.set(snapshotFile);
        return path.get();
    }
}

