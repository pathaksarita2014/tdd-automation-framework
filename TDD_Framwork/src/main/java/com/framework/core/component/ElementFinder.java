package com.framework.core.component;

import com.framework.core.browser.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ElementFinder
{
    WebDriver driver;

    public ElementFinder()
    {

        driver = WebDriverManager.GetrealWebDriver().get();

    }

    //Finding element by xpath
    public WebElement findElementByXpath(String elementName, String pageName ) throws Exception
    {
        WebElement element=null;

        try
        {
            System.out.println("findElementByXpath is :" + pageName + System.getProperty("envName")+ elementName);
            //String xpath = RepositoryLoader.FetchElementValue("xpath", pageName, System.getProperty("envName"), elementName);
            String xpath = RepositoryLoader.FetchElementValue("xpath", pageName, "staging", elementName);
            element=driver.findElement(By.xpath(xpath));
            //element=waitForPresenceOfElement(By.xpath(xpath));
            //waitForElementToBeVisible(element);
            scrollIntoView(element);
            // jsHighLighter(element);
            return element;

        }
        catch(Exception e)
        {
            System.out.println("THis is the exception found" + e);

        }
        return element;
    }

    //Finding element by id
    public WebElement findElementById(String elementName,String pageName ) throws Exception
    {
        //String id = RepositoryLoader.FetchElementValue("id", pageName, System.getProperty("envName"), elementName);
        String id = RepositoryLoader.FetchElementValue("id", pageName, "staging", elementName);
        WebElement element=driver.findElement(By.id(id));
        //WebElement element=waitForPresenceOfElement(By.id(id));
        // waitForElementToBeVisible(element);
        return element;
    }

    //Finding element by xpath
    public List<WebElement> findElementListByXpath(String elementName, String pageName ) throws Exception
    {


        try
        {
            System.out.println("findElementByXpath is :" + pageName + System.getProperty("envName")+ elementName);
           // String xpath = RepositoryLoader.FetchElementValue("xpath", pageName, System.getProperty("envName"), elementName);
            String xpath = RepositoryLoader.FetchElementValue("xpath", pageName,"staging", elementName);
            List<WebElement> elementList =driver.findElements(By.xpath(xpath));
            //element=waitForPresenceOfElement(By.xpath(xpath));
            //waitForElementToBeVisible(element);
            // scrollIntoView(element);
            // jsHighLighter(element);
            return elementList;

        }
        catch(Exception e)
        {
            System.out.println("THis is the exception found" + e);

        }
        return null;
    }

    // Scroll into view to make element visible if screen is to long
    public void scrollIntoView(WebElement element)
    {
        try
        {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            // javascriptExecutor.executeScript("argument[0].scrollIntoView()", element);
            javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
            // javascriptExecutor.executeScript("window.scrollBy(0,250)", element);
        }
        catch(Exception e)
        {
            System.out.println("Could not scrool the view of element");
            e.printStackTrace();

        }
    }

    public void jsHighLighter(WebElement element)
    {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        try
        {
            js.executeScript("argument[0].setAttribute('style', 'border:3px soild red;');",element);
            Thread.sleep(300);

            js.executeScript("argument[0].setAttribute('style', 'border:none;');",element);
            Thread.sleep(300);

        }
        catch(Exception e)
        {
            System.out.println("Could not HighLighter the view of element");
            e.printStackTrace();

        }

    }

    // Explicit wait to make sure element is present in DOM
    public WebElement waitForPresenceOfElement(By  by)
    {
        WebDriverWait wait=new WebDriverWait(driver,10 ); //ex
        WebElement element= wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return element;

    }

    //Explicit wait to make sure element is present and visible in DOM
    public void waitForElementToBeVisible(WebElement element)
    {
        WebDriverWait wait=new WebDriverWait(driver, 10); //ex
        wait.until(ExpectedConditions.visibilityOf(element));

    }

}
