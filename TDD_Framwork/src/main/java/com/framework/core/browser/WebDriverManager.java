package com.framework.core.browser;

import com.framework.core.helper.Configs;
import org.openqa.selenium.WebDriver;

public class WebDriverManager
{
    private static  ThreadLocal<WebDriver> realWebDriver= new ThreadLocal<WebDriver>();

    // This is example of Encapsulation keeping "realWebDriver" as private and public method is returing the "realWebDriver" to other class to use
    // this is restricting to every one to directly access to "realWebDriver"
    public static ThreadLocal<WebDriver> GetrealWebDriver()
    {
        return realWebDriver;
    }

    public void initializeWebdriver()
    {
        loadDriver(BrowserType.valueOf(Configs.browser));
    }

    public void loadDriver(BrowserType type)
    {
        BrowserBase browser= getBrowser(type);
        realWebDriver.set(browser.buildWebDriver());
    }


    public BrowserBase getBrowser(BrowserType type)
    {

        BrowserBase browser = null;
        if (type==BrowserType.CHROME)
        {
            browser=new Chrome();
        }
        if (type==BrowserType.EDGE)
        {
            browser=new Edge();
        }
        if (type==BrowserType.FIREFOX)
        {
            browser=new FireFox();
        }
        if (type==BrowserType.INTERNETEXPLORE)
        {
            browser=new InternetExplorer();
        }
        return browser;

    }


}

